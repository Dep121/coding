// Java program For handling Input/Output 
import java.io.*; 
import java.util.*;
class LinkedList 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Scanner Class for Fast buffer Input 
        Scanner br = new Scanner(
                               new FileReader("input.txt")); 
  
        // PrintWriter class prints formatted representations 
        // of objects to a text-output stream. 
        PrintWriter pw=new PrintWriter(new
                BufferedWriter(new FileWriter("output.txt"))); 
  
        Integer a1 = br.nextInt();
        Integer a2 = br.nextInt();

        pw.println("" + a1 + a2);
  
        pw.flush(); 
    } 
}
