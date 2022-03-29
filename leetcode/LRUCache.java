import java.util.Map;
import java.util.HashMap;

class NodeLink {
    int key;
    int value;
    NodeLink next;
    NodeLink prev;

    public NodeLink(int key, int value) { this.value = value; }
}

class LRUCache {

    private int capacity;
    private Map<Integer, NodeLink> map;
    private NodeLink head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = this.tail = null;
    }

    public int get(int key) {
        int result = -1;

        NodeLink node = this.map.get(key);

        if (node != null) {
            result = node.value;
            remove(node);
            add(node);
        }

        return result;
    }

    public void put(int key, int value) {
        NodeLink node = this.map.get(key);

        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (this.map.size() == this.capacity) {
                this.map.remove(this.tail.key);
                remove(this.tail);
            }

            NodeLink newNode = new NodeLink(key, value);
            this.map.put(key, newNode);
            add(newNode);
        }
    }

    public void printLRU() {
        NodeLink head = this.head;
        while (head != null) {
            System.out.println(head.value);
            head = head.prev;
        }
        System.out.println();
    }

    private void add(NodeLink node) {
        if (this.head == null) {
            this.head = this.tail = node;
            this.head.next = null;
            this.tail.prev = null;
        } else {
            this.head.next = node;
            node.prev = this.head;
            this.head = node;
            this.head.next = null;
        }
    }

    private void remove(NodeLink delete) {
        if (delete == null) return;

        if (this.head == delete) {
            this.head = delete.next;
        }

        if (this.tail == delete) {
            this.tail = this.tail.next;
            this.tail.prev = null;
        }

        if (delete.next != null) {
            delete.next.prev = delete.prev;
        }

        if (delete.prev != null) {
            delete.prev.next = delete.next;
        }
    }

}

class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 10);
        lruCache.put(2, 5);
        lruCache.put(3, 8);

        lruCache.printLRU();

        lruCache.get(2);

        lruCache.printLRU();

        lruCache.put(1, 10);

        lruCache.printLRU();
    }
}