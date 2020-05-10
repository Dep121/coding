(function () {
	var foo = 1;
	function bar() {
		var foo = 2;
	} bar();
	console.log(foo);
	if (true) {
		var foo = 3;
	}
	console.log(foo);
})();

/*
	1
	3
*/
console.log("--------------------");
