var variable = 10;
(() => {
    console.log(variable);
    var variable = 20;
    console.log(variable);
})()

console.log(variable);
var variable = 30;
console.log(variable);

/**
 * undefined
 * 20
 * 10
 * 30
 */

/** global variable is accessible under inner scope unless it is redeclared */