import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   if(i+j==n/2||(i-j)==n/2||(j-i)==n/2||(i+j==(n-1)+n/2)){
                       System.out.print("*\t");
                   }
                   else{
                       System.out.print("\t");
                   }
               }
               System.out.println();
           }
           
           
           
          
           
      
       }
      }