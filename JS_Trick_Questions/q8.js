alert(foo());

function foo() {
    var bar = function() {
        return 3;
    };

    return bar();

    var bar = function() {
        return 8;
    };
}

/*
3
*/