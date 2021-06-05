import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            if (lheight > rheight) {
                return(lheight+1);
            } else {
                return(rheight+1);
            }
        }
    }

    void printLevelOrder(Node root) {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    void printCurrentLevel(Node root, int level) {
        System.out.println();

        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data);
        } else if (level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    void insertLevelOrder(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(value);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(value);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    void printInOrder(Node root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    void printPreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.data);

        printInOrder(root.left);
        printInOrder(root.right);
    }

    void printPosOrder(Node root) {
        if (root == null) return;

        printInOrder(root.left);
        printInOrder(root.right);
        
        System.out.println(root.data);
    }

    void deleteDeepest(Node root, Node delete) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            
            if (temp == delete) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == delete) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
        
            if (temp.left != null) {
                if (temp.left == delete) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    void delete(Node root, int dataValue) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == dataValue) {
                root = null;
                return;
            } else {
                return;
            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        Node temp = null, nodeValue = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == dataValue) {
                nodeValue = temp;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (nodeValue != null) {
            int x = temp.data;
            deleteDeepest(root, temp);
            nodeValue.data = x;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int rootHeight = tree.height(tree.root);
        int rootChildHeight = tree.height(tree.root.left);

        System.out.println("Height of the root: " + rootHeight);
        System.out.println("Height of the child of the root: " + rootChildHeight);

        System.out.println("------CURRENT LEVEL-------");
        tree.printCurrentLevel(tree.root, 2);
        System.out.println();
        System.out.println("------CURRENT LEVEL-------");
        tree.printCurrentLevel(tree.root.left, 2);
        System.out.println();

        System.out.println("------PRINT LEVEL ORDER-------");
        tree.printLevelOrder(tree.root);
        System.out.println("------PRINT LEVEL ORDER-------");
        tree.printLevelOrder(tree.root.left);

        System.out.println();

        tree.insertLevelOrder(tree.root, 6);

        System.out.println("------PRINT LEVEL ORDER-------");
        tree.printLevelOrder(tree.root);

        System.out.println("------------------------------");
        System.out.println("------------------------------");

        BinaryTree treeToDelete = new BinaryTree();
        treeToDelete.root = new Node(13);
        treeToDelete.root.left = new Node(12);
        treeToDelete.root.right = new Node(10);
        treeToDelete.root.left.left = new Node(4);
        treeToDelete.root.left.right = new Node(19);
        treeToDelete.root.right.left = new Node(16);
        treeToDelete.root.right.right = new Node(9);

        treeToDelete.delete(treeToDelete.root, 12);

        treeToDelete.printLevelOrder(treeToDelete.root);

        treeToDelete.printInOrder(treeToDelete.root);
    }
    
}