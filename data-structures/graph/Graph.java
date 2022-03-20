import java.util.*;

public class Graph {

    private Map<Node, List<Node>> graph;

    public Graph() { graph = new HashMap<>(); }

    public void add(Node key, Node value) {
        List<Node> list;

        if (graph.containsKey(key)) {
            list = graph.get(key);
        } else {
            list = new ArrayList<>();
        }

        if (value != null) list.add(value);

        graph.put(key, list);
    }

    public void depthFirstPrint(Node node) {
        depthFirstPrint(graph, node);
    }

    private void depthFirstPrint(Map<Node, List<Node>> graph, Node node) {
        if (node != null) System.out.println(node.value);
        for (Node neighbor : graph.get(node)) {
            depthFirstPrint(graph, neighbor);
        }
    }

    public void breadthFirstPrint(Node node) {
        breadthFirstPrint(graph, node);
    }

    private void breadthFirstPrint(Map<Node, List<Node>> graph, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.value);
            queue.addAll(graph.get(current));
        }
    }

    public boolean hasPath(Node src, Node dst) {
        return hasPath(graph, src, dst);
    }

    private boolean hasPath(Map<Node, List<Node>> graph, Node src, Node dst) {
        if (src == dst) return true;

        for (Node neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dst)) return true;
        }

        return false;
    }

    public boolean hasUndirectedPath(Node src, Node dst) {
        return hasUndirectedPath(graph, src, dst, new HashSet<>());
    }

    private boolean hasUndirectedPath(Map<Node, List<Node>> graph, Node src, Node dst, Set<Node> visited) {
        if (src == dst) return true;
        if (visited.contains(src)) return false;

        visited.add(src);

        for (Node neighbor : graph.get(src)) {
            if (hasUndirectedPath(graph, neighbor, dst, visited)) return true;
        }

        return false;
    }

    public int connectedComponentsCount() {
        return connectedComponentsCount(graph, new HashSet<>());
    }

    private int connectedComponentsCount(Map<Node, List<Node>> graph, Set<Node> visited) {
        int count = 0;

        for (var entry : graph.entrySet()) {
            if (exploreNodeComponents(graph, entry.getKey(), visited)) {
                count += 1;
            }
        }

        return count;
    }

    private boolean exploreNodeComponents(Map<Node, List<Node>> graph, Node node, Set<Node> visited) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (Node neighbor : graph.get(node)) {
            exploreNodeComponents(graph, neighbor, visited);
        }

        return true;
    }

    public int largestComponent() {
        return largestComponent(graph, new HashSet<>());
    }

    private int largestComponent(Map<Node, List<Node>> graph, Set<Node> visited) {
        double largest = Double.NEGATIVE_INFINITY;

        for (var entry : graph.entrySet()) {
            int componentSize = getNodeComponentSize(graph, entry.getKey(), visited);
            if (componentSize > largest) largest = componentSize;
        }

        return (int) largest;
    }

    private int getNodeComponentSize(Map<Node, List<Node>> graph, Node node, Set<Node> visited) {
        if (visited.contains(node)) return 0;

        visited.add(node);

        int size = 1;
        for (Node neighbor : graph.get(node)) {
            size += getNodeComponentSize(graph, neighbor, visited);
        }

        return size;
    }

    public int shortestPath(Node src, Node dst) {
        return shortestPath(graph, src, dst, new HashSet<>());
    }

    private int shortestPath(Map<Node, List<Node>> graph, Node src, Node dst, Set<Node> visited) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();

        queue.add(src);
        map.put(src, 0);
        visited.add(src);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value.equals(dst.value)) {
                return map.get(current);
            }

            for (Node neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    map.put(neighbor, map.get(current) + 1);
                }
            }
        }

        return -1;
    }

    public static int numIslands(String grid[][]) {
        int num = 0;
        Set<String> set = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (exploreIslands(grid, row, col, set)) {
                    num += 1;
                }
            }
        }
        return num;
    }

    private static boolean exploreIslands(String[][] grid, int row, int col, Set<String> visited) {
        boolean rowInbound = 0 <= row && row < grid.length;
        boolean colInbound = 0 <= col && col < grid[0].length;
        if (!rowInbound || !colInbound) return false;

        if (grid[row][col].equals("W")) return false;

        String pos = row + "," + col;
        if (visited.contains(pos)) return false;
        visited.add(pos);

        exploreIslands(grid, row - 1, col, visited);
        exploreIslands(grid, row, col - 1, visited);
        exploreIslands(grid, row + 1, col, visited);
        exploreIslands(grid, row, col + 1, visited);

        return true;
    }

    public static int lowestIsland(String[][] grid) {
        double lowest = Double.POSITIVE_INFINITY;
        Set<String> set = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int islandSize = exploreLowestIslands(grid, row, col, set);
                if (islandSize > 0 && islandSize < lowest) lowest = islandSize;
            }
        }

        return (int) lowest;
    }

    private static int exploreLowestIslands(String[][] grid, int row, int col, Set<String> visited) {
        boolean rowInbound = 0 <= row && row < grid.length;
        boolean colInbound = 0 <= col && col < grid[0].length;
        if (!rowInbound || !colInbound) return 0;

        if (grid[row][col].equals("W")) return 0;

        String pos = row + "," + col;
        if (visited.contains(pos)) return 0;
        visited.add(pos);

        int cont = 1;
        cont += exploreLowestIslands(grid, row - 1, col, visited);
        cont += exploreLowestIslands(grid, row, col - 1, visited);
        cont += exploreLowestIslands(grid, row + 1, col, visited);
        cont += exploreLowestIslands(grid, row, col + 1, visited);

        return cont;
    }

}
