import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    void BFS(int start) {
        System.out.println();

        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " ");
            
            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        System.out.println();
    }

    void DFS(int top) {
        System.out.println();

        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[top] = true;
        stack.add(top);

        while (!stack.isEmpty()) {
            top = stack.pop();
            System.out.print(top + " ");
            
            Iterator<Integer> i = adj[top].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = true;
                    stack.add(n);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
        g.DFS(2);
    }
}
