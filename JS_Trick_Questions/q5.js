function outer(){
    function inner(){
        b++;
        console.log(b);
    }

    var b = 2;

    inner();
}

outer();

/*
3
*/