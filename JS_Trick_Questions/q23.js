function greet() {
    setTimeout(() => {
        console.log(this.name);
    }, 500);
}
greet.call({ name: 'Daniel Craig' });

/**
 * Daniel Craig
 */