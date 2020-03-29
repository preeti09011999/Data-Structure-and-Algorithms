import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        printSS(str,"");
        System.out.println();
    }

    public static void printSS(String str,String asf) {
        if(str.length() == 0){
            if(asf.length()!=0)
                System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        str = str.substring(1);
        
        //char isn't included in the ans
        printSS(str,asf);
        
        //char is included in the ans
        printSS(str,asf+ch);
        
    }

}