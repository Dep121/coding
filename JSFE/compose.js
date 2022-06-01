function multiply (a) {
  return a * 4
}

function add (a) {
  return a + 5
}

function subtract (a) {
  return a - 2
}

// let evaluate = compose(multiply, add, subtract) // evaluate from right to left

// evaluate(6)
// 36

const compose = (...functions) => {
  return (args) => functions.reduceRight((arg, fn) => fn(arg), args)
}

let evaluate = compose(multiply, add, subtract)
console.log(evaluate(6))

