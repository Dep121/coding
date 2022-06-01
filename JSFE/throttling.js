/**
 * Throttling
 * @param {function} func function which will be executed.
 * @param {timeInterval} delay in this time interval function will not get executed.
 */
function throttling(func, delay) {
  // to store previous timestamp
  let prev = 0;

  return function(...args) {
    // get the current timestamp
    let now = new Date().getTime();
    if (now - prev > delay) { // if more time period has passed than delay then executed function
      // set the prev to now
      prev = now;

      return func(...args)
    }
  }
}
