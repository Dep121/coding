/* https://dmitripavlutin.com/differences-between-arrow-and-regular-functions/
 1. this value
*/

/*
  1.1 Regular Function
*/

// simple invocation
function myFunction() {
  console.log(this);
}

myFunction(); // logs global object (window)

// method invocation
const myObject = {
  method() {
    console.log(this);
  }
};

myObject.method();  // logs myObject

// indirect invocation using bind, call, apply
function myFunction2() {
  console.log(this);
}
const myContext = { value: 'A'};

myFunction2.apply(myContext); // logs { value: 'A'}
myFunction2.call(myContext); // logs { value: 'A'}


// constructor invocation
function myFunction3() {
  console.log(this);
}

new myFunction3(); // logs an instance of function

//  2. Arrow Function

const myObject2 = {
  myMethod(items) {
    console.log(this); // logs myObject
    const callback = () => {
      console.log(this); // logs myObject
    };
    items.forEach(callback);
  }
};
myObject2.myMethod([1, 2, 3]); 


let a = 10
let b = 5
let c = a + b

a = 5

console.log("c =>", c)

