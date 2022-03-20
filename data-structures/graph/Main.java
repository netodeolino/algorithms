public class Main {

    public static void main(String[] args) {
//        Graph graph = new Graph();
//        Node a = new Node("a");
//        Node b = new Node("b");
//        Node c = new Node("c");
//        Node d = new Node("d");
//        Node e = new Node("e");
//        Node f = new Node("f");
//        graph.add(a, b);
//        graph.add(a, c);
//        graph.add(b, d);
//        graph.add(c, e);
//        graph.add(d, f);
//        graph.add(e, null);
//        graph.add(f, null);
//        graph.depthFirstPrint(a);
//        graph.breadthFirstPrint(a);

//        Graph graph = new Graph();
//        Node f = new Node("f");
//        Node g = new Node("g");
//        Node h = new Node("h");
//        Node i = new Node("i");
//        Node j = new Node("j");
//        Node k = new Node("k");
//        graph.add(f, g);
//        graph.add(f, i);
//        graph.add(g, h);
//        graph.add(h, null);
//        graph.add(i, g);
//        graph.add(i, k);
//        graph.add(j, i);
//        graph.add(k, null);
//        boolean hasPath = graph.hasPath(f, k);

//        Graph graph = new Graph();
//        Node i = new Node("i");
//        Node j = new Node("j");
//        Node k = new Node("k");
//        Node m = new Node("m");
//        Node l = new Node("l");
//        Node o = new Node("o");
//        Node n = new Node("n");
//        graph.add(i, j);
//        graph.add(i, k);
//        graph.add(j, i);
//        graph.add(k, i);
//        graph.add(k, m);
//        graph.add(k, l);
//        graph.add(m, k);
//        graph.add(l, k);
//        graph.add(o, n);
//        graph.add(n, o);
//        boolean hasUndirectedPath = graph.hasUndirectedPath(j, m);

//        Graph graph = new Graph();
//        Node n0 = new Node("0");
//        Node n1 = new Node("1");
//        Node n5 = new Node("5");
//        Node n8 = new Node("8");
//        Node n2 = new Node("2");
//        Node n3 = new Node("3");
//        Node n4 = new Node("4");
//        graph.add(n0, n8);
//        graph.add(n0, n1);
//        graph.add(n0, n5);
//        graph.add(n1, n0);
//        graph.add(n5, n0);
//        graph.add(n5, n8);
//        graph.add(n8, n0);
//        graph.add(n8, n5);
//        graph.add(n2, n3);
//        graph.add(n2, n4);
//        graph.add(n3, n2);
//        graph.add(n3, n4);
//        graph.add(n4, n3);
//        graph.add(n4, n2);
//        int countConnected = graph.connectedComponentsCount();
//        int largestComponentSize = graph.largestComponent();

//        Graph graph = new Graph();
//        Node a = new Node("a");
//        Node b = new Node("b");
//        Node c = new Node("c");
//        Node d = new Node("d");
//        Node e = new Node("e");
//        Node f = new Node("f");
//        Node g = new Node("g");
//        graph.add(a, c);
//        graph.add(c, a);
//        graph.add(a, b);
//        graph.add(b, a);
//        graph.add(c, b);
//        graph.add(b, c);
//        graph.add(c, d);
//        graph.add(d, c);
//        graph.add(b, d);
//        graph.add(d, b);
//        graph.add(e, d);
//        graph.add(d, e);
//        graph.add(g, f);
//        graph.add(f, g);
//        int shortestPath = graph.shortestPath(a, e);

        String[][] grid = {
                {"W", "L", "W", "W", "W"},
                {"W", "L", "W", "W", "W"},
                {"W", "W", "W", "L", "W"},
                {"W", "W", "L", "L", "W"},
                {"L", "W", "W", "L", "L"},
                {"L", "L", "W", "W", "W"}
        };

//        int numIslands = Graph.numIslands(grid);
        int lowestIsland = Graph.lowestIsland(grid);
        System.out.println(lowestIsland);
    }

}
