import java.util.*;

class CountPossiblePathsTwoVertices {
    private int V;
    private LinkedList<Integer>[] adj;

    CountPossiblePathsTwoVertices(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int countPath(int path1, int path2) {
        int count = 0;
        return countPathUtil(path1, path2, count);
    }

    private int countPathUtil(int path1, int path2, int count) {
        if (path1 == path2) {
            count++;
        } else {
            Iterator<Integer> i = adj[path1].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                count = countPathUtil(n, path2, count);
            }
        }

        return count;
    }

    int countPathV2(int path1, int path2) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(path1);

        if (path1 == path2) count = 1;

        while (!queue.isEmpty()) {
            path1 = queue.poll();

            Iterator<Integer> i = adj[path1].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                queue.add(n);
                if (n == path2) count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPossiblePathsTwoVertices g = new CountPossiblePathsTwoVertices(5);
 
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 2);

        System.out.println(g.countPath(0, 4));
        System.out.println(g.countPathV2(0, 4));
    }
}