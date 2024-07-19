function debouncer(func, delay) {
  let timer;
  return function() {
    const args = arguments
    clearTimeout(timer);
    timer = setTimeout(() => {
      func.apply(this, arguments)
    }, delay);
  }
}

function x(b) {
  // "use strict"
  console.log("x ", this)
  setTimeout(() => {
    console.log("setTimeout ===> ", this.a)
  }, 1000)
}

// x();

function y() {
  a = 9;
  console.log("y ", this)
  setTimeout(() => x(7), 1000)
}

y();
console.log("a ==> ", this.a)
