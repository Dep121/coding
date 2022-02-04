class ArrayStack {
  stack;
  top;
  size;

  constructor(s) {
    this.top = -1;
    this.size = s;
    this.stack = new Int32Array(s);
  }

  isFull() {
    return this.top === this.size - 1;
  }

  isEmpty() {
    return this.top === -1;
  }

  push(data) {
    if (this.isFull()) {
      console.log(`stack overflow...`);
      return;
    }
    this.top += 1;
    this.stack[this.top] = data;
  }

  pop() {
    if (this.isEmpty()) {
      console.log(`stack empty...`);
      return;
    }
    this.top -= 1;
  }

  display() {
    if (this.isEmpty()) {
      console.log(`stack empty...`);
      return;
    }

    for(let i=this.top; i>=0; --i) {
      process.stdout.write(`${this.stack[i]} `);
    }
    console.log(`------`);
  }
}

const st = new ArrayStack(5);

st.push(8);
st.push(3);
st.push(9);
st.push(5);

st.display();
st.pop();
st.display();
st.pop();
st.display();
