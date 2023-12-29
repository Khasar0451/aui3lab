import {DataBinder} from '../../../data-binder.js';
import {UiUtils} from '../../../ui-utils.js';
import {CharacterService} from '../../service/character-service.js';
import {ProfessionService} from '../../../profession/service/profession-service.js';
import '../../type/types.js'
import '../../../profession/type/types.js'

window.addEventListener('load', () => {
    new CharacterEditComponent(new DataBinder(), new UiUtils(), new CharacterService(), new ProfessionService()).onInit();
});

/**
 * Represents component listing all characters.
 */
class CharacterEditComponent {

    /**
     * Selected characters.
     *
     * @type {CharacterUpdate}
     */
    character;

    /**
     * All available professions.
     *
     * @type {Professions}
     */
    professions;

    /**
     * Character service.
     *
     * @type {CharacterService}
     */
    characterService;

    /**
     * Professions service.
     *
     * @type {ProfessionService}
     */
    professionService;

    /**
     * Manages state of layout based on data model.
     *
     * @type {DataBinder}
     */
    dataBinder;

    /**
     * Utility component for UI related code.
     *
     * @type {UiUtils}
     */
    uiUtils;

    /**
     * @param {DataBinder} dataBinder manages state of layout based on data model
     * @param {UiUtils} uiUtils utility component for UI related code
     * @param {CharacterService} characterService character service
     * @param {ProfessionService} professionService profession service
     */
    constructor(dataBinder, uiUtils, characterService, professionService) {
        this.dataBinder = dataBinder;
        this.uiUtils = uiUtils;
        this.characterService = characterService;
        this.professionService = professionService;
    }

    /**
     * Returns value for query param.
     *
     * @param {string} name name of the query param
     * @returns {string} query param value
     */
    getParameterByName(name) {
        return new URLSearchParams(window.location.search).get(name);
    }

    /**
     * Called when component is initialized.
     */
    onInit() {
        let characterPromise = this.characterService.getCharacter(this.getParameterByName('id'))
            .then(data => {
                this.character = {
                    name: data.name,
                    age: data.age,
                    background: data.background,
                    constitution: data.constitution,
                    strength: data.strength,
                    charisma: data.charisma,
                    profession: data.profession.id
                };
            });

        let professionsPromise = this.professionService.getProfessions()
            .then(data => {
                this.professions = data;
            });

        Promise.all([characterPromise, professionsPromise])
            .then(() => {
                this.onRender();
            });
    }

    /**
     * Called when component data should be bound to layout.
     */
    onRender() {
        this.dataBinder.render(this, document.getRootNode());
        this.uiUtils.initInputs();
    }

    /**
     * Called when component data should be updated with layout inputs.
     */
    onUpdateComponent() {
        this.dataBinder.update(this, document.getRootNode());
    }

    // noinspection JSUnusedGlobalSymbols
    /**
     * Called on form submit.
     */
    onSubmit() {
        this.onUpdateComponent();
        this.characterService.putCharacter(this.getParameterByName('id'), this.character)
            .then(() => {
                this.onInit();
            });
    }

    // noinspection JSUnusedGlobalSymbols
    /**
     * Can be used with form onreset callback. Because onreset callback is called before actual form resetting, the
     * setTimeout workaround is used. As default values are stored in DOM, default reset action is enough. This callback
     * is only for initializing MDB input controls.
     */
    onReset() {
        setTimeout(this.uiUtils.initInputs, 0);
    }

}
