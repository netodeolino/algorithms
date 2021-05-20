import java.util.Iterator;
import java.util.LinkedList;

class FindMother {

    private int V;
    private LinkedList<Integer>[] adj;

    FindMother(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();

            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    int findMother() {
        boolean[] visited = new boolean[V];
        int v = -1;
     
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                v = i;
            }
        }

        boolean[] check = new boolean[V];
        
        DFSUtil(v, check);

        for (boolean val : check) {
            if (!val) {
                return -1;
            }
        }

        return v;
    }

    public static void main(String[] args) {
        FindMother mother = new FindMother(7);

        mother.addEdge(0, 1);
        mother.addEdge(0, 2);
        mother.addEdge(1, 3);
        mother.addEdge(4, 1);
        mother.addEdge(6, 4);
        mother.addEdge(5, 6);
        mother.addEdge(5, 2);
        mother.addEdge(6, 0);

        System.out.println(mother.findMother());
    }
    
}
