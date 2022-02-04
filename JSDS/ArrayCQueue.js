class CQueue {
  front;
  rear;
  size;
  queue;

  constructor(s) {
    this.front = -1;
    this.rear = -1;
    this.size = s;
    this.queue = new Int32Array(this.size);
  }

  // full check
  isFull() {
    return this.front === (this.rear + 1) % this.size;
  }

  // empty check
  isEmpty() {
    return this.front === -1;
  }

  // function to insert an element at rear of the queue
  queueEnqueue(data) {
    if (this.isFull()) {
      console.error(`Queue is full !!`);
      return;
    }
    if (this.front === -1) {
      this.front = 0;
    }
    this.rear = (this.rear + 1) % this.size;
    this.queue[this.rear] = data
  }

  // function to remove an element from front of the queue
  queueDequeue() {
    if (this.isEmpty()) {
      console.error(`Queue is empty !!`);
      return;
    }

    const element = this.queue[this.front];
    if (this.front === this.rear) {
      this.front = -1;
      this.rear = -1;
    } else {
      this.front = (this.front + 1) % this.size;
    }
    return element;
  }

  display() {
    if (this.isEmpty()) {
      console.error(`Queue is empty`);
      return;
    }
    console.log(`front -> ${this.front}`);
    process.stdout.write(`Items -> `);
    let i;
    for(i = this.front; i != this.rear; i = (i+1) % this.size) {
      process.stdout.write(` ${this.queue[i]}`);
    }
    process.stdout.write(` ${this.queue[i]}\n`);
    console.log(`Rear -> ${this.rear}`);
  }

}

let aq = new CQueue(5)
aq.queueEnqueue(7);
aq.queueEnqueue(5);
aq.queueEnqueue(9);
aq.queueEnqueue(4);

aq.display();

process.stdout.write(`\n`);

aq.queueDequeue();
aq.display();

aq.queueDequeue();
aq.queueDequeue();
aq.queueEnqueue(4);
aq.display();
aq.queueDequeue();
aq.queueEnqueue(42);
aq.queueEnqueue(34);
aq.queueEnqueue(48);

aq.display();
aq.queueDequeue();
