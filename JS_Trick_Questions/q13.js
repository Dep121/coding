const user = {
    email: "my@email.com",
    update(email) {
        this.email = email;
    }
};

user.update('newEmail@email.com');
console.log(user.email);

/**
 * newEmail@email.com
 */

/**
 * this points to user object because of normal function
 */