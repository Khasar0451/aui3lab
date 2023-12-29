import {DataBinder} from '../../../data-binder.js';
import {CharacterService} from '../../service/character-service.js';
import '../../type/types.js'
import '../../../profession/type/types.js'

window.addEventListener('load', () => {
    new CharacterViewComponent(new DataBinder(), new CharacterService()).onInit();
});

/**
 * Represents component listing all characters.
 */
class CharacterViewComponent {

    /**
     * Selected characters.
     *
     * @type {CharacterDetails}
     */
    character;

    /**
     * Character service.
     *
     * @type {CharacterService}
     */
    characterService;

    /**
     * Manages state of layout based on data model.
     *
     * @type {DataBinder}
     */
    dataBinder;

    /**
     * @param {DataBinder} dataBinder manages state of layout based on data model
     * @param {CharacterService} characterService character service
     */
    constructor(dataBinder, characterService) {
        this.dataBinder = dataBinder;
        this.characterService = characterService;
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
       this.characterService.getCharacter(this.getParameterByName('id'))
            .then(data => {
                this.character = data;
                this.onRender();
            });
    }

    /**
     * Called when component data should be bound to layout.
     */
    onRender() {
        this.dataBinder.render(this, document.getRootNode());
    }

}
