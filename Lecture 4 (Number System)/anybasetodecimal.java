import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      int num =0,i=0,pow=1;
           while(n!=0){
               int r = n%10;
               num = num +r*pow;
               pow = pow*b;
               n = n/10;
           }
           return num;
       }
   
  }