import '../type/types.js'

/**
 * Service for making API calls for users characters.
 */
export class CharacterService {

    /**
     * Fetches all characters.
     *
     * @returns {Promise<Characters>} completion promise with characters list
     */
    getCharacters() {
        return fetch('/api/characters')
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network error.");
            });
    }

    /**
     * Removes single character.
     *
     * @param {string} id character id
     * @returns {Promise} completion promise
     */
    deleteCharacter(id) {
        return fetch('/api/characters/' + id, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    return;
                }
                throw new Error("Network error.");
            });
    }

    /**
     * Fetches single character.
     *
     * @param {string} id character id
     * @returns {Promise<CharacterDetails>} completion promise with character details
     */
    getCharacter(id) {
        return fetch('/api/characters/' + id)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network error.");
            });
    }

    /**
     *
     * @param {string} id character id
     * @param {CharacterUpdate} request character
     * @returns {Promise} completion promise
     */
    putCharacter(id, request) {
        return fetch('/api/characters/' + id,
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(request)
            })
            .then(response => {
                if (response.ok) {
                    return;
                }
                throw new Error("Network error.");
            });
    }
}
