class Solution {
    public class Pair{
        int v;
        int color;
        Pair(){
            this.v = v;
            this.color = color;
        }
        Pair(int v,int color){
            this.v = v;
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int vis[] = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
            if(vis[i] == -1){
                if(!isBipartite_(i,graph,vis)) return false;        
            }
        }
        return true;
    }
    
    public boolean isBipartite_(int src,int[][] graph,int[] vis){
        LinkedList<Pair> que = new LinkedList<>();
        que.push(new Pair(src,0));
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
            Pair pb = que.removeFirst();
            if(vis[pb.v]!=-1 && vis[pb.v] != pb.color){
                return false;
            }
            vis[pb.v] = pb.color;
            for(int e : graph[pb.v]){
                if(vis[e] == -1){
                    que.addLast(new Pair(e,(pb.color+1)%2));
                }
            }
            }
        }
         return true;                       
    }   
}
