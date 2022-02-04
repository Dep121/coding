function  BrianKernighan(n) {
  if (!Number.isInteger(n)) {
    console.error(`Invalid Number ${n}`);
  }
  let count = 0;
  while(n != 0) {
    n = n & (n-1);
    count++;
  }
  console.log(`Set bits: ${count}`);
  return count;
}

BrianKernighan(11);

function countSetBits(n) {
  if (!Number.isInteger(n)) {
    console.error(`Invalid Number ${n}`);
  }
  let count = 0;
  while(n > 0) {
    count += n & 1;
    n >>= 1;
  }
  console.log(`Set bits: ${count}`);
  return count;
}

countSetBits(7);
