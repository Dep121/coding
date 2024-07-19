function greet() {
    console.log(this.name);
}

const sayHello1 = greet.bind({ name: "Tom Cruise" });
sayHello1();
const sayHello2 = sayHello1.bind({ name: "Zac Efron" });
sayHello2();

/**
 * Tom Cruise
 * Tom Cruise
 * (Binding an already bound function does not change the execution context.)
 */