import java.util.*;

public class topologicalsort {
    static class Edge{
        int sourse;
        int destination;
        public Edge(int s,int d){
            this.sourse=s;
            this . destination=d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topsortutill(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer>stk){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.destination]){
                topsortutill(graph,e.destination,vis,stk);
            }
        }
        stk.push(curr);
    }
    public static void topoSort(ArrayList<Edge>[] graph){
        boolean[] vis =new boolean[graph.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
               topsortutill(graph,i,vis,st);
            }
        }
        while(!st.isEmpty()){
            System.out.printf("%d ",st.pop());
        }

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topoSort(graph);

    }
}
