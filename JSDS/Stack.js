let Node = require("./Node");
class Stack {
  constructor(){
    this.head=null;
  }

  push(value){
    if(this.head === null){
      this.head = new Node(value);
      return;
    }
    let newNode = new Node(value);
    newNode.next = this.head;
    this.head = newNode;
  }

  pop(){
    if(this.head === null) {
      console.error("stack is empty");
      return
    }
    this.head = this.head.next;
  }

  print(){
    let temp = this.head;
    while(temp !== null) {
      // console.log(temp.value);
      process.stdout.write(temp.value + " ");
      temp = temp.next;
    }
    process.stdout.write("\n");
  }
}

module.exports = Stack;
