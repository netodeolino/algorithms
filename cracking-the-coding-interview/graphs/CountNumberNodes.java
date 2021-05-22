import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int countNodesAtLevel(int start, int level) {
        boolean visited[] = new boolean[V];
        int levels[] = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int contNode = 0;

        for (int i = 0; i < V; i++) {
            levels[i] = 0;
        }

        visited[start] = true;
        levels[0] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            
            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    levels[n] = levels[start] + 1;
                    queue.add(n);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (levels[i] == level) contNode++;
        }

        return contNode;
    }
}

public class CountNumberNodes {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 6);
        
        System.out.println(g.countNodesAtLevel(0, 2));
    }
}
