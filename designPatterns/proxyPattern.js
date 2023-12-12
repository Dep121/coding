// structural pattern

const original = { name: 'jeff' };

const reactive = new Proxy(original, {
    get(target, key) {
        console.log('Tracking: ', key);
        return target[key];
    },
    set(target, key, value) {
        console.log('updating UI ... ');
        return Reflect.set(target, key, value);
    }
});

console.log(reactive.name);
reactive.name = 'bob';

// proxies are also used when there is a large object and it is difficult to duplicate in memory.