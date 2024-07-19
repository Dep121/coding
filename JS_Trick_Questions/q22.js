function greet() {
    setTimeout(function () {
        console.log(this.name);
    }, 500);
}
greet.call({ name: 'Daniel Craig' });

/**
 * undefined
 */