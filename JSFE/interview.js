// //

// console.log(x);
// var x = 1;
// function x(){console.log("inside function x")}
// console.log(x)

// //
// setTimeout(() => console.log('1'), 0);
// console.log('2');
// Promise.resolve('3').then((val) => console.log(val));
// setImmediate(() => console.log('4'), 1000);

//
const promise = new Promise((resolve, reject) => {
  console.log(1);
  setTimeout(() => {
    console.log("timerStart");
  
    resolve("success");
    console.log("timerEnd");
  }, 0);
  console.log(2);
 });
 promise.then((res) => {
  console.log(res);
 });
 console.log(4);

