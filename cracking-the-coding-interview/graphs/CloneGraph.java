import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
}

public class CloneGraph {
    public Node cloneGraphInterative(Node node) {
        Map<Integer, Node> cache = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        cache.put(node.val, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node actualNode = queue.poll();

            List<Node> neighbors = actualNode.neighbors;

            for (Node neighbor : neighbors) {
                if (!cache.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    cache.put(neighbor.val, new Node(neighbor.val));
                }

                cache.get(actualNode.val).neighbors.add(new Node(neighbor.val));
            }
        }

        return cache.get(node.val);
    }

    public Node cloneGraphRecursive(Node node, Map<Integer, Node> cache) {
        if (node == null) return null;
        if (cache.containsKey(node.val)) return cache.get(node.val);

        cache.put(node.val, new Node(node.val));

        for (Node neighbor : node.neighbors) {
            if (!cache.containsKey(neighbor.val)) {
                cache.get(node.val).neighbors.add(cloneGraphRecursive(neighbor, cache));
            }
        }

        return cache.get(node.val);
    }

    public Node cloneGraphRecursive(Node node) {
        Map<Integer, Node> cache = new HashMap<>();
        return cloneGraphRecursive(node, cache);
    }

    public void printNeighbors(Node node) {
        for (Node n : node.neighbors) {
            System.out.println("Node: " + node.val + " - Neighbor: " + n.val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();

        System.out.println("---- Interative ----");
        cloneGraph.cloneGraphInterative(node1);
        cloneGraph.printNeighbors(node1);
        cloneGraph.printNeighbors(node2);
        cloneGraph.printNeighbors(node3);
        cloneGraph.printNeighbors(node4);

        System.out.println("---- Recursive----");
        cloneGraph.cloneGraphRecursive(node1);
        cloneGraph.printNeighbors(node1);
        cloneGraph.printNeighbors(node2);
        cloneGraph.printNeighbors(node3);
        cloneGraph.printNeighbors(node4);
    }
}
