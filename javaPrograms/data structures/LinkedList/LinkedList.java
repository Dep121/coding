/**
 * LinkedList
 */

class Node {
  int x;
  char c;
  Node next;

  Node(Integer x){
    this.x = x;
    this.next = null;
  }

  Node(char c){
    this.c = c;
    this.next = null;
  }
}

public class LinkedList {
  
  Node head;

  LinkedList() {
    this.head = null;
  }

  void pll() {
    Node temp = this.head;
    while(temp != null) {
      System.out.print(temp.x + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void push(Node n) {
    Node temp = head;

    if(temp == null) {
      head = n;
      return;
    }

    while(temp.next != null) {
      temp = temp.next;
    }

    temp.next = n;
  }

  void sortedPush(Node n) {
    Node temp = head;

    if(temp == null) {
      head = n;
      return;
    }

    Node prev = null;

    while(temp != null && temp.x < n.x) {
      prev = temp;
      temp = temp.next;
    }

    if(prev != null) {
      prev.next = n;
      n.next = temp;
    } else {
      n.next = temp;
      head = n;
    }

  }

  // delete a given node
  void deleteNode(int i) {
    Node temp = this.head;
    Node prev = null;
    
    while(temp != null && temp.x != i) {
      prev = temp;
      temp = temp.next;
    }

    if(temp != null) {
      if(prev == null) {
        head = null;
      } else {
        prev.next = temp.next;
      }
    } else {
      System.out.println("Linked list is empty");
    }
  }

  public static void main(String[] args) {
    LinkedList l = new LinkedList();

    l.push(new Node(8));
    l.push(new Node(7));
    l.push(new Node(4));
    l.push(new Node(3));

    l.pll();

    LinkedList sl = new LinkedList();
    
    sl.sortedPush(new Node(8));
    sl.sortedPush(new Node(4));
    sl.sortedPush(new Node(7));
    sl.sortedPush(new Node(3));

    sl.pll();

    sl.deleteNode(7);

    sl.pll();

    LinkedList sl2 = new LinkedList();

    sl2.deleteNode(8);

    sl2.pll();
  }
}
