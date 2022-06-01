let a = [
  [8, 4],
  [3, 9],
  8,
  [2, 3],
  [4, 6, 2, [2, 7]]
]

let flattened = [].concat(...a)

console.log(flattened)

const flatArray = (arr) => {
  if (!Array.isArray(arr)) {
    return arr
  }
  let temp = []
  for (const ele of arr) {
    temp.push(flatArray(ele))
  }
  return [].concat(...temp)
}

console.log(flatArray(a))

