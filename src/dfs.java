import java.util.*;
class Edge1 {
    int src;
    int dest;
    int wt;
    Edge1(int s, int d, int w){
        this.src=s;
        this . dest=d;
        this.wt=w;
    }
}
public class dfs {
    public static void dfsAlgo(ArrayList<Edge1>graph[],boolean []vis,int curr){
        if(vis[curr]){
            return ;
        }
        vis[curr] = true;
        System.out.print(curr+"  ");
        for(int i=0;i<graph[curr].size();i++){
            Edge1 e=graph[curr].get(i);
            dfsAlgo(graph,vis,e.dest);
        }

    }
    static void createGraph(ArrayList<Edge1> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge1(0, 1, 1));
        graph[0].add(new Edge1(0, 2, 1));
        graph[1].add(new Edge1(1, 0, 1));
        graph[1].add(new Edge1(1, 3, 1));
        graph[2].add(new Edge1(2, 0, 1));
        graph[2].add(new Edge1(2, 4, 1));
        graph[3].add(new Edge1(3, 1, 1));
        graph[3].add(new Edge1(3, 4, 1));
        graph[3].add(new Edge1(3, 5, 1));
        graph[4].add(new Edge1(4, 2, 1));
        graph[4].add(new Edge1(4, 3, 1));
        graph[4].add(new Edge1(4, 5, 1));
        graph[5].add(new Edge1(5, 3, 1));
        graph[5].add(new Edge1(5, 4, 1));
        graph[5].add(new Edge1(5, 6, 1));
        graph[6].add(new Edge1(6, 5, 1));
    }

    public static void main(String[] args) {
        int v=7;
        boolean vis[]=new boolean[v];
ArrayList<Edge1>graph[]=new ArrayList[v];
createGraph(graph);
for(int i=0;i< graph.length;i++) {
    dfsAlgo(graph, vis, i);
}
    }
}
