import java.util.LinkedList;
import java.util.List;

public class DLPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {
    LinkedList<Entry<K, V>> entryLinkedList;

    public DLPriorityQueue() {
        this.entryLinkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return entryLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return entryLinkedList.isEmpty();
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newEntry = new Entry<>(key, value);
        if(!isEmpty()) {
            for(int i = 0; i < entryLinkedList.size(); i++) {
               if(newEntry.getKey().compareTo(entryLinkedList.get(i).getKey()) <= 0) {
                   entryLinkedList.add(i, newEntry);
                   break;
               }
            }
            entryLinkedList.add(newEntry);
        } else {
            entryLinkedList.add(newEntry);
        }
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        return entryLinkedList.get(0);
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return entryLinkedList.remove(0);
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        DLPriorityQueue<K, V> newDLPriorityQueue = new DLPriorityQueue<>();

        Entry<K, V> entryToAdd;
        for(int i = 0; i < other.size() + entryLinkedList.size(); i++) {
            if(entryLinkedList.peek().getKey().compareTo(other.peek().getKey()) > 0) {
                entryToAdd = other.dequeueMin();
            } else {
                entryToAdd = dequeueMin();
            }
            newDLPriorityQueue.enqueue(entryToAdd.getKey(), entryToAdd.getValue());
        }
        return newDLPriorityQueue;
    }
}
