function deepCloning (obj) {
  if (typeof obj !== "object") {
    return obj
  }

  let copyObj = Array.isArray(obj) ? [] : {}

  for (let key in obj) {
    copyObj[key] = deepCloning(obj[key])
  }

  return copyObj
}

let x = [{ y: { dep: 'deepak' } }, { c: { o: { h: [] } } }, "hep" ]

let cloned = deepCloning(x)

cloned[1].c.o.h.push("xray")
console.log(x[1].c.o.h[0])
console.log(cloned[1].c.o.h[0])
