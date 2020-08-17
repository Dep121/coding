console.log(foo());
function foo() {
    function bar() {
        return 3;
    }
    return bar();
    function bar(){
        return 8;
    }
}

/*
8
*/

console.log(foo());
function foo() {
    var bar = 3;
    return bar;
    var bar = 8;
}
