const p1 = new Promise((res, rej) => {
  console.log('4');
  res('1')
});


p1.then((res, rej) => {
  console.log(res);
});


setTimeout(() => {
  console.log('2');
}, 0);

console.log('3');