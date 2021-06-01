import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    private final int SIZE;
    private Deque<Integer> doubleQueue;

    public LRUCache(int size) {
        SIZE = size;
        doubleQueue = new LinkedList<>();
    }

    public void refer(int page) {
        if (!doubleQueue.contains(page)) {
            if (doubleQueue.size() == SIZE) doubleQueue.removeLast();
        } else {
            doubleQueue.remove(page);
        }

        doubleQueue.push(page);
    }

    public void display() {
        Iterator<Integer> iterator = doubleQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        
        cache.display();
    }
}