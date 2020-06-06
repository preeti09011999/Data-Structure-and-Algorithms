import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
      int idx = 0;
      while(idx<size){
          int validIdx = (front+idx)%data.length;
          System.out.print(data[validIdx]+" ");
          idx++;
      }
      System.out.println();
    }

    void add(int val) {
      if(size == data.length){
          System.out.println("Queue overflow");
      }else{
          int validIdx = (front + size)%data.length;
          data[validIdx] = val;
          size++;
      }
    }

    int remove() {
      if(size == 0){
          System.out.println("Queue underflow");
          return -1;
      }
      else{
          
          int temp = data[front];
          data[front] = 0;
          front = (front+1)%data.length;
          size--;
          return temp;
      }
    }

    int peek() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        else{
            int val = data[front];
            return val;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}