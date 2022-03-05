public class BinaryTree {

    public class Node {
        int key;
        Node left, right;
    
        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    Node root;

    public void add(int key) {
        root = add(root, key);
    }

    private Node add(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key <= root.key) {
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

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) return root;
        
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node temp = findMin(root.right);
                root.key = temp.key;
                root.right = delete(temp.right, temp.key);
            }
        }

        return root;
    }

    public Node findMin(Node root) {
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public int height() {
        return height(root);
    }

    public int height(Node root) {
        if (root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public void printLevelOrder() {
        int height = height();
        for (int i = 0; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    public void printCurrentLevel(Node root, int level) {
        if (root == null) return;

        if (level == 0) {
            System.out.println(root.key);
        }

        if (level > 0) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    public int lowestCommonAncestor(Node nodeOne, Node nodeTwo) {
        Node lca = LCA(root, nodeOne, nodeTwo);
        return lca.key;
    }

    private Node LCA(Node root, Node nodeOne, Node nodeTwo) {
        if (root == null) return null;

        if (root.key == nodeOne.key || root.key == nodeTwo.key) return root;

        Node left = LCA(root.left, nodeOne, nodeTwo);
        Node right = LCA(root.right, nodeOne, nodeTwo);

        if (left == null && right == null) return null;

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();

        bTree.add(11);
        bTree.add(9);
        bTree.add(8);
        bTree.add(10);
        bTree.add(12);

        // bTree.delete(9);

        // System.out.println(bTree.height());

        // bTree.printLevelOrder();

        // System.out.println(bTree.lowestCommonAncestor(bTree.root.left.left, bTree.root));

        // bTree.printInOrder();
    }
}
