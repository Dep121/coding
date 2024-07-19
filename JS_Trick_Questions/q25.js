function Employee(name) {
    this.name = name;
}

Employee.prototype.getName = function() {
    return this.name;
}

const jason = new Employee('Jason');
console.log(jason.getName());

/**
 * Jason
 * becuase this has lexical scope in arrow function
 */
