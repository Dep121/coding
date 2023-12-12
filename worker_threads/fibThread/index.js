
const { Worker } = require('worker_threads');

const doFib = async (iterations) => {
    return new Promise((resolve, reject) => {
        const start = Date.now()

        // start worker
        const worker = new Worker('./fib.js', {
            workerData: {
                iterations
            }
        });

        // listen for message from workers
        worker.once('message', (data) => {
            console.log(`Worker [${worker.threadId}]: done in ${Date.now() - start}`);
            resolve(data);
        })

        // listen for error from workers
        worker.once('error', (err) => reject(err));
    })
}

const main = async () => {
    const start = Date.now();

    const values = await Promise.all([
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40),
        doFib(40)
    ]);

    console.log('values: ', values);

    console.log(`fib done in ${Date.now() - start}ms`);
}

main().catch(console.error);