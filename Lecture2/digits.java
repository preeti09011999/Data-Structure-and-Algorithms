import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int r;
      int a = n;
      int count = 0;
    while(n!=0){
        count = count + 1;
        n = n/10;
    }
     int multiplier = 1;
     while(count!=1){
         multiplier *= 10;
         count -=1;
     }
    while(multiplier!=0){
        
        r = a/multiplier;
        a = a%multiplier;
        System.out.println(r);
        
        multiplier = multiplier/10;
        
        
    }
    
     }
    }