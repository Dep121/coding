// reverse a linked list
import java.io.*;
import java.util.*;

class Node {
    Integer data;
    Node next;

    Node(Integer d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;

    void print(PrintWriter pw) {
        Node temp = this.head;
        while(temp != null) {
            pw.print(temp.data + " ");
            temp = temp.next;
        }
        pw.println();
    }

    void reverseList() {
        Node temp = this.head;
        Node pre = null;
        while(temp != null && temp.next != null) {
            Node temp2 = temp;
            temp = temp.next;
            temp2.next = pre;
            pre = temp2;
        }
        temp.next = pre;
        this.head = temp;
    }

    void push(Integer d) {
        if(this.head == null) {
            this.head = new Node(d);
            return;
        }
        Node temp = new Node(d);
        temp.next = this.head;
        this.head = temp;
    }
}

class driver {
    public static void main(String[] args) throws IOException {
    // Scanner Class for Fast buffer Input 
    Scanner br = new Scanner(new FileReader("input.txt")); 

    // PrintWriter class prints formatted representations 
    // of objects to a text-output stream. 
    PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

    Integer size = 0;
    size = br.nextInt();
    LinkedList li = new LinkedList();

    for(int i=0; i<size; ++i) {
        li.push(br.nextInt());
    }

    li.print(pw);
    li.reverseList();
    li.print(pw);

    pw.flush();
}
}
