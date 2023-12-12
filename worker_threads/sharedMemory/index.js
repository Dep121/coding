const { Worker } = require('worker_threads');

const sharedBuffer = new SharedArrayBuffer(4);
const buffer = new Uint8Array(sharedBuffer);

buffer.fill(5);

console.log('buffer before modify: ', buffer);

// create a worker and pass the sharedBuffer
const worker = new Worker('./w.js', {
    workerData: {
        sharedBuffer
    },
})

worker.once('message', () => {
    console.log('buffer after modify: ', buffer);
});
