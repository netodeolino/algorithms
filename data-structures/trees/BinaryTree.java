import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public void add(int key) {
        root = add(root, key);
    }

    private Node add(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) {
            root.left = add(root.left, key);
        } else {
            root.right = add(root.right, key);
        }
        return root;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.key);
            printInOrder(root.right);
        }
    }

    public void printInLevels() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.key);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) root = null;
            else if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                Node tempRoot = findMin(root.right);
                root.key = tempRoot.key;
                root.right = delete(root.right, tempRoot.key);
            }
        }

        return root;
    }

    private Node findMin(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public int LCA(int one, int two) {
        Node lca = LCA(root, one, two);
        return lca.key;
    }

    private Node LCA(Node root, int one, int two) {
        if (root == null) return null;
        if (root.key == one || root.key == two) return root;

        Node left = LCA(root.left, one, two);
        Node right = LCA(root.right, one, two);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    public int sumValues() {
        return sumValues(root);
    }

    private int sumValues(Node root) {
        if (root == null) return 0;
        return root.key + sumValues(root.left) + sumValues(root.right);
    }

    public int minValue() {
        return (int) minValue(root);
    }

    private double minValue(Node root) {
        if (root == null) return Double.POSITIVE_INFINITY;

        double minLeft = minValue(root.left);
        double minRight = minValue(root.right);

        double minValue = Math.min(minLeft, minRight);

        return minValue < root.key ? minValue : root.key;
    }

    public int maxRootToLeafPathSum() {
        return maxRootToLeafPathSum(root);
    }

    private int maxRootToLeafPathSum(Node root) {
        if (root == null) return 0;

        int sumLeft = maxRootToLeafPathSum(root.left);
        int sumRight = maxRootToLeafPathSum(root.right);

        return Math.max(sumLeft, sumRight) + root.key;
    }

}
