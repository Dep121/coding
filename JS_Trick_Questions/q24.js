function Employee(name) {
    this.name = name;
}

Employee.prototype.getName = () => {
    return this.name;
}

const jason = new Employee('Jason');
console.log(jason.getName());

/**
 * undefined
 * becuase this has lexical scope in arrow function
 */