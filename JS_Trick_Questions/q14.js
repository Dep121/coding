var variable = 10;
(() => {
    console.log(variable);
    variable = 20;
    console.log(variable);
})()

console.log(variable);
var variable = 30;
console.log(variable);

/**
 * 10
 * 20
 * 20
 * 30
 */

/** global variable is accessible under inner scope unless it is redeclared */