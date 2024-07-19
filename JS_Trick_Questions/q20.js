var hero = {
    _name: 'Jhon Doe',
    getSecretIdentity: function() {
        return this._name;
    }
};

var stoleSecretIdentity = hero.getSecretIdentity;
console.log(stoleSecretIdentity());
console.log(hero.stoleSecretIdentity());

/**
 * undefined
 * Jhon Doe
 */
