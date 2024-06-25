import java.util.*;
class Edge2{
    int src;
    int dest;
    int wt;
    Edge2(int s, int d,int wt ) {
        this.src = s;
        this.wt = wt;
        this.dest = d;
    }
}

public class Allpair_of_shortest_path {
    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair P2) {
            return this.dist - P2.dist;
        }
    }

    public static void Dijkstra(ArrayList<Edge>[] graph, int src, int v) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[v];
        int dis[] = new int[v];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int V = e.dest;
                    if (!vis[V] && dis[u] + e.wt < dis[V]) {
                        dis[V] = dis[u] + e.wt;
                        pq.add(new Pair(V, dis[V]));

                    }

                }
            }

        }
        for (int i = 0; i < v; i++) {
            System.out.print(dis[i] + "  ");
        }
        System.out.println();

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        Dijkstra(graph, src,V);


    }
}

