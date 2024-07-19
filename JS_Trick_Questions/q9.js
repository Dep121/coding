function parent1() {
    return hoisted();
    
    var hoisted = "I'm a variable";
    function hoisted() {
        return "I'm a function";
    }
    
}

function parent2() {

    var hoisted = "I'm a variable";
    function hoisted() {
        return "I'm a function";
    }
    return hoisted;
}

console.log(parent1());
console.log(parent2());

/**
 * I'm a function
 * I'm a variable
 */