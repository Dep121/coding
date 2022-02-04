var a = 1;
function b() {
    a = 10;
    console.log("inner log: ", a);
    return;
    function a() {}
} b();

console.log("outer log: ",a);

/*
1
*/

// Variable assignment takes precedence over function declaration
// Function declarations take precedence over variable declarations
