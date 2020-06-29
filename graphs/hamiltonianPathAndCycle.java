import java.io.*;
import java.util.*;

public class Main {
   static class Edge { 
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      hamiltonian(graph,src,src,"",new HashSet<Integer>());
   }

    public static void hamiltonian(ArrayList<Edge>[] graph,int vrtx, int osrc,String psf,HashSet<Integer> visited){
        if(visited.size() == graph.length-1){
            psf += vrtx;
            boolean cycle = false;
            for(Edge e:graph[vrtx]){
                if(e.nbr == osrc){
                    cycle = true;
                    break;
                }
            }
            if(cycle){
                System.out.println(psf+"*");
            }else{
                System.out.println(psf+".");
            }

            return;
        }
        // mark
        visited.add(vrtx);
        for(Edge e : graph[vrtx]){
            if(!visited.contains(e.nbr)){
                hamiltonian(graph,e.nbr,osrc,psf+vrtx,visited);
            }
        }
        visited.remove(vrtx);
    }
}
