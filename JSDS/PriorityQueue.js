class PriorityQueue { // using max heap
  size;
  heap;
  capacity;

  constructor(c) {
    this.size = 0;
    this.capacity = c;
    this.heap = new Int32Array(this.capacity);
  }

  swap(r, i) {
    let temp = this.heap[r];
    this.heap[r] = this.heap[i];
    this.heap[i] = temp;
  }

  heapify(r) {
    let largest = r;
    let left = r * 2 + 1;
    let right = r * 2 + 2;

    if (left < this.size && this.heap[largest] < this.heap[left]) {
      largest = left;
    }

    if (right < this.size && this.heap[largest] < this.heap[right]) {
      largest = right;
    }

    if (largest !== r) {
      this.swap(r, largest);
      this.heapify(largest);
    }
  }

  insert(data) {
    if (this.isFull()) {
      console.log(`heap overflow...`);
    }

    this.size += 1;
    this.heap[this.size - 1] = data;

    for (let i = Math.floor(this.size / 2) - 1; i>=0; --i) {
      this.heapify(i);
    }
    console.log(`----> ${this.heap}`);
  }

  delete(data) {
    if (!Number.isInteger(data)) {
      console.log(`invalid number ${data}`);
      return;
    }
    if (this.isEmpty()) {
      console.log(`heap empty...`);
      return;
    }
    let i = 0;
    while (i<this.size && this.heap[i] !== data) i++;
    
    // swap i th element with last element
    let temp = this.heap[i];
    this.heap[i] = this.heap[this.size - 1];
    this.heap[this.size - 1] = temp;

    this.size -= 1;

    for (let i = Math.floor(this.size / 2) - 1; i >= 0; i--) {
      this.heapify(i);
    }
  }

  isFull() {
    return this.size === this.capacity;
  }

  isEmpty() {
    return this.size === 0;
  }

  display() {
    if (this.isEmpty()) {
      console.log(`heap empty...`);
      return;
    }
    for(let i=0; i<this.size; i++) {
      process.stdout.write(`${this.heap[i]} `);
    }
    console.log(`-----`);
  }
}

function main() {
  const pq = new PriorityQueue(10);

  pq.insert(9);
  pq.insert(3);
  pq.insert(5);
  pq.insert(1);
  pq.insert(4);
  pq.insert(2);
  pq.insert(7);

  pq.display();

  pq.delete ();

  pq.display();
}

main();

// my output:
//       9
//   5       4
// 1   3   2   7

