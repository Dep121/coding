const arr = [10, 12, 15, 21];

for (var i=0; i<arr.length; i++) {
	setTimeout(function (i_local) {
		console.log('The index of this number is: ' + i_local);
	} (i), 3000);
}

/*
The index of this number is: 0
timers.js:118
    throw new ERR_INVALID_CALLBACK(callback);
    ^

TypeError [ERR_INVALID_CALLBACK]: Callback must be a function. Received undefined
    at setTimeout (timers.js:118:11)
    at Object.<anonymous> (/home/dep/projects/competitive-coding/JS_Trick_Questions/q3.js:4:2)
    at Module._compile (internal/modules/cjs/loader.js:1121:30)
    at Object.Module._extensions..js (internal/modules/cjs/loader.js:1160:10)
    at Module.load (internal/modules/cjs/loader.js:976:32)
    at Function.Module._load (internal/modules/cjs/loader.js:884:14)
    at Function.executeUserEntryPoint [as runMain] (internal/modules/run_main.js:67:12)
    at internal/main/run_main_module.js:17:47 {
  code: 'ERR_INVALID_CALLBACK'

*/
