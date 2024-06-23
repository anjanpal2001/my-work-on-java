import java.util.*;
public class cycle {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }
public static boolean isCycleUbdirectedUtill(ArrayList<Edge>graph[],boolean vis[],int curr,int parent){
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[curr]&& e.dest!=parent) return true;
            else if(!vis[curr]){
                if(isCycleUbdirectedUtill(graph,vis,e.dest,curr)){
                    return true;
                }
            }
        }
        return false;
}
    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean vis[]){
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]){
            return    isCycleUbdirectedUtill(graph,vis,i,-1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean vis[]=new boolean[graph.length];
        createGraph(graph);
        System.out.println(isCyclic(graph,vis));
    }
}
