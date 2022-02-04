/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class kadane {
    public static void main (String[] args) {

        // Largest sum contiguous sub array
        //code
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt();
        
        while(t!=0) {
            int size = s.nextInt();
            int arr[] = new int[size];
            for(int i=0; i<size; ++i) {
                arr[i] = s.nextInt();
            }
            
            int currMax = arr[0];
            int maxSoFar = arr[0];
            for(int i=1; i<size; ++i) {
                
                currMax = Math.max(arr[i], currMax + arr[i]);
                maxSoFar = Math.max(maxSoFar, currMax);
            }
            System.out.println(maxSoFar);
            t--;
        }
    }
}