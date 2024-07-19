
// for (var i = 1; i < 10; i++) {
//   setTimeout(() => {
//       console.log(i);
//   }, 0);
// }
// for (let i = 1; i < 10; i++) {
//   setTimeout(() => {
//       console.log(i);
//   }, 0);
// }
// for (const i = 1; i < 10; i++) {
//   setTimeout(() => {
//       console.log(i);
//   }, 0);
// }


// const heyNew = () => {
//   setTimeout(() => console.log('1'), 0);
//   console.log('2');
//   Promise.resolve('3').then((val) => console.log(val));
//   setTimeout(() => console.log('4'), 1000);
// };
// heyNew();


// const person = {
//   name: 'John',
//   sayHello: function() {
//     console.log(`Hello, ${this.name}!`);
//   }
// };
// person.sayHello();
// const greet = person.sayHello.bind(person);
// greet(); // Output: Hello, John!
