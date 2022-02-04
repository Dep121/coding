class StringComp {

  static int stcmp(LinkedList a, LinkedList b) {
    Node temp1 = a.head;
    Node temp2 = b.head;

    while(temp1 != null && temp2 != null) {
      if(temp1.c > temp2.c) {
        return 1;
      } else if(temp1.c < temp2.c) {
        return -1;
      }
      temp1 = temp1.next;
      temp2 = temp2.next;
    }

    if(temp1 == null && temp2 == null) {
      return 0;
    } else if(temp1 == null) {
      return -1;
    } else {
      return 1;
    }
  }

  static void pll(LinkedList n) {
    Node temp = n.head;
    while(temp != null) {
      System.out.print(temp.c + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    String a = "deepak";
    String b = "deeq";

    LinkedList stra = new LinkedList();
    LinkedList strb = new LinkedList();

    for(int i=0; i<a.length(); ++i) {
      stra.push(new Node(a.charAt(i)));
    }

    for(int i=0; i<b.length(); ++i) {
      strb.push(new Node(b.charAt(i)));
    }

    pll(stra);
    pll(strb);

    System.out.println("Comparision of a: "+ a + " and b: " + b + " = " + stcmp(stra, strb));
  }
}