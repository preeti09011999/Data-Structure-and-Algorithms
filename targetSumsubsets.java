import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for(int i = 0; i < n; i++){
           arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);
        System.out.println();
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }
        //if element is there in the answer
        if(sos + arr[idx]<=tar){
            printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        }
        //if element is not there in the answer
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }

}