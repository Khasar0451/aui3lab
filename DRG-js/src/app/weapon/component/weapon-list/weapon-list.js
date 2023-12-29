import {DataBinder} from '../../../data-binder.js';
import {CharacterService} from '../../service/character-service.js';
import '../../type/types.js'
import '../../../profession/type/types.js'

window.addEventListener('load', () => {
    new CharacterListComponent(new DataBinder(), new CharacterService()).onInit();
});

/**
 * Represents component listing all characters.
 */
class CharacterListComponent {

    /**
     * Manages state of layout based on data model.
     *
     * @type Characters
     */
    characters;

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
     * Called when component is initialized.
     */
    onInit() {
        this.characterService.getCharacters()
            .then(data => {
                this.characters = data;
                this.onRender();
            });
    }

    /**
     * Called when component data should be bound to layout.
     */
    onRender() {
        this.dataBinder.render(this, document.getRootNode());
    }

    /**
     * Called when changes in component data should be detected.
     */
    onDetectChanges() {
        this.dataBinder.detectChanges(this, document.getRootNode());
    }

    // noinspection JSUnusedGlobalSymbols
    /**
     * Removes selected character.
     *
     * @param {Character} character
     */
    onDelete(character) {
        this.characterService.deleteCharacter(character.id)
            .then(() => {
                let index = this.characters.characters.findIndex(item => item === character);
                if (index > -1) {
                    this.characters.characters.splice(this.characters.characters.findIndex(item => item === character), 1);
                    this.onDetectChanges();
                }
            });
    }

}
