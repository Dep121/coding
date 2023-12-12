// behavioural pattern - iterator pattern

function range(start, end, step = 1) {
    return {
        [Symbol.iterator]() {
            return this;
        },
        next() {
            if (start < end) {
                start = start + step;
                return { value: start, done: false };
            }
            return { done: true, value: end };
        }
    }
}

for (const i of range(1, 10, 2)) {
    console.log(i);
}