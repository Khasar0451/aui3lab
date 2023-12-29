import '../../profession/type/types.js'

/**
 * Single character.
 *
 * @typedef {Object} Character
 * @property {string} id character's unique identifier
 * @property {string} name character's name.
 */

/**
 * List of characters.
 *
 * @typedef {Object} Characters
 * @property {Character[]} characters - An array of Character objects.
 */

/**
 * Single character with details.
 *
 * @typedef {Object} CharacterDetails
 * @property {string} id character's unique identifier
 * @property {string} name  character's name
 * @property {string} background  character's background description
 * @property {number} age  character's age
 * @property {number} strength  character's strength attribute
 * @property {number} constitution  character's constitution attribute
 * @property {number} charisma  character's charisma attribute
 * @property {number} health  character's health points
 * @property {number} level  character's level
 * @property {number} experience  character's experience points
 * @property {Profession} profession  character's profession
 */

/**
 * Single character update.
 *
 * @typedef {Object} CharacterUpdate
 * @property {string} name  character's updated name
 * @property {number} age  character's updated age
 * @property {string} background  character's updated background description
 * @property {number} constitution  character's updated constitution attribute
 * @property {number} strength  character's updated strength attribute
 * @property {number} charisma  character's updated charisma attribute
 * @property {string} profession  character's updated profession identifier
 */
