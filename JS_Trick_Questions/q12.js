const user = {
    email: "my@email.com",
    update: email => { this.email = email }
};

user.update('newEmail@email.com');
console.log(user.email);

/**
 * my@email.com
 */

/**
 * When this is used in the arrow function then this has lexical scope
 * so without the function keyword this is uanble to refer to the object in the outer scope. 
 */