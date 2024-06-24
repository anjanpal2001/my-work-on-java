import org.w3c.dom.ls.LSOutput;

import java.util.*;
class Edge{
    int src;
    int dest;
    int wt;
    Edge(int s, int d,int w){
        this.src=s;
        this . dest=d;
        this.wt=w;
    }
}
public class bfsAlgo {
    public static void bfssearch(ArrayList<Edge>[] graph, boolean[] vis, int curr){
        Queue<Integer>qu=new LinkedList<>();
        qu.add(curr);

        while(!qu.isEmpty()) {
            int src = qu.remove();
            if (!vis[src]) {
                System.out.print(src + "->");

                vis[src]=true;

                for (int i = 0; i < graph[src].size(); i++) {
                    Edge e = graph[src].get(i);
                    qu.add(e.dest);
                }
            }
        }
//        System.out.println();

    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void main(String[] args) {
        int v=7;
        boolean vis[]=new boolean[v];
ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the source");
//        int src=sc.nextInt();
        for(int i=0;i<graph.length;i++) {
            bfssearch(graph, vis, i);
        }
    }
}
