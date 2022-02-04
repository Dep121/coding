function parent1() {
    return hoisted();
    
    var hoisted = "I'm a variable";
    function hoisted() {
        return "I'm a function";
    }
    
}

function parent2() {

    var hoisted = "I'm a variable";
    function hoisted() {
        return "I'm a function";
    }
    return hoisted;
}

console.log(parent1());
console.log(parent2());

/*
/home/dep/projects/competitive-coding/JS_Trick_Questions/q9.js:6
    return hoisted();
           ^

TypeError: hoisted is not a function
    at parent (/home/dep/projects/competitive-coding/JS_Trick_Questions/q9.js:6:12)
    at Object.<anonymous> (/home/dep/projects/competitive-coding/JS_Trick_Questions/q9.js:9:13)
    at Module._compile (internal/modules/cjs/loader.js:1121:30)
    at Object.Module._extensions..js (internal/modules/cjs/loader.js:1160:10)
    at Module.load (internal/modules/cjs/loader.js:976:32)
    at Function.Module._load (internal/modules/cjs/loader.js:884:14)
    at Function.executeUserEntryPoint [as runMain] (internal/modules/run_main.js:67:12)
    at internal/main/run_main_module.js:17:47
*/