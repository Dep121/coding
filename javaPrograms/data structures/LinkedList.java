// Java program For handling Input/Output 
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

    void pList(PrintWriter pw) {
        Node temp = this.head;
        while(temp != null){
            pw.print(temp.data + " ");
            temp = temp.next;
        }
        pw.println();
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    void deleteNode(Integer key) {
        Node temp = this.head;
        Node prev = null;
        while(temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        /* key does not exist */
        if (temp == null) return;

        if (temp.data == key && prev != null) {
            prev.next = temp.next;
        } else {
            this.head = temp.next;
        }
    }

    void push(int d) {
        if (this.head == null) {
            this.head = new Node(d);
            return;
        }

        Node temp = new Node(d);
        temp.next = this.head;
        this.head = temp;
    }

    void pop() {
        if (this.head == null) {
            return;
        }

        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
    }

    Node midNode() {
        Node p1 = this.head;
        Node p2;

        if (p1 == null) { // no element
            return null;
        }

        if (p1.next == null) { // one element
            return null;
        } else if (p1.next.next == null) { // two elements
            return null;
        } else {    // p2 at third element
            p2 = p1.next.next;
        }

        while(true) {
            if (p2.next == null) {
                return p1.next; // 1 (2) 3  // for odd
            } else if (p2.next.next == null) {
                return p1.next; // 1 (2) 3 4    // for even
            } else {
                p2 = p2.next.next;
                p1 = p1.next;
            }
        }
    }

    Boolean detectLoop() {
        Node temp = this.head;
        HashSet<Node> hs = new HashSet<Node>();

        while(temp != null){
            if (hs.contains(temp)) {
                return true;
            }

            hs.add(temp);
            temp = temp.next;
        }

        return false;
    }

    Integer floydCycleDetection() {
        Node p1 = this.head, p2 = this.head;

        // at least length of linked list should be 3;
        while(p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1 == p2) {
                // count nodes and return length
                Node p_dup = p1.next;
                Integer count = 0;
                while(p1 != p_dup) {
                    p_dup = p_dup.next;
                    count++;
                }
                return count;
            }
        }

        return 0;
    }
}

class driver 
{
    public static void main(String[] args) throws IOException {

        // Scanner Class for Fast buffer Input 
        Scanner br = new Scanner(new FileReader("input.txt")); 
  
        // PrintWriter class prints formatted representations 
        // of objects to a text-output stream. 
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt"))); 

        Integer size = 0;
        size = br.nextInt();
        LinkedList llist = new LinkedList();

        for (Integer i = 0; i < size; ++i) {
            llist.push(br.nextInt());
        }

        Integer data = br.nextInt();
        llist.pList(pw);

        llist.pop();
        llist.pList(pw);

        llist.deleteNode(4);
        llist.pList(pw);

        Node mid = llist.midNode();

        if (mid != null) {
            pw.println(mid.data);   
        } else {
            pw.println("no mid");
        }

        pw.flush();
    }
}
