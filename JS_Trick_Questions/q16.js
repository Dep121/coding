var var1 = 10;
(() => {
    var3 = 35;
    console.log(var3);
    var var3 = 45;
    var2 = 15;
    console.log(var1);
})()

console.log(var2);
console.log(var3);
var var1 = 30;
console.log(var1);

/**
 * 35 (var3 is hoisted and initiased at line 3 in the IIFE scope)
 * 10 (global variable)
 * 15 (global variable)
 * Uncaught ReferenceError: var3 is not defined
 * (trying to access the variable that is accessible only in IIFE scope)
 */