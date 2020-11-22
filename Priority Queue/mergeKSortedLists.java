import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        int li; // list index
        int di; // data index
        int val;
        Pair(int li,int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
        
        public int compareTo(Pair other){
            return this.val - other.val;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int listIdx = 0;listIdx< lists.size();listIdx++){
          ArrayList<Integer> ithList = lists.get(listIdx);
          int val = ithList.get(0);
          pq.add(new Pair(listIdx,0,val));
      }
    
      while(pq.size()>0){
          Pair minPair = pq.remove();
          // add val to result
          rv.add(minPair.val);
          minPair.di++;
          if(minPair.di < lists.get(minPair.li).size()){
              minPair.val = lists.get(minPair.li).get(minPair.di);
              pq.add(minPair);
          }
      }
      return rv;
   }
   
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
