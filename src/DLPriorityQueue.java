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
        } else {
            entryLinkedList.add(newEntry);
        }
        if(!entryLinkedList.contains(newEntry)){
            entryLinkedList.add(newEntry);
        }
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        if(isEmpty()){
            return null;
        }
        return entryLinkedList.get(0);
    }

    @Override
    public Entry<K, V> dequeueMin() {

        if(isEmpty()){
            return null;
        }
        return entryLinkedList.remove(0);
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {

        DLPriorityQueue<K, V> newDLPriorityQueue = new DLPriorityQueue<>();
        LinkedList<Entry<K,V>> temp = new LinkedList<>(((DLPriorityQueue<K, V>)other).getEntryLinkedList());
        Entry<K, V> entryToAdd;

        int toIterate = other.size() + entryLinkedList.size();
        for(int i = 0; i < toIterate; i++) {
            entryToAdd = null;
            if(other.size() > 0 && entryLinkedList.size() > 0){
                if(entryLinkedList.peek().getKey().compareTo(other.peek().getKey()) > 0) {
                    entryToAdd = other.dequeueMin();
                } else {
                    entryToAdd = dequeueMin();
                }
            } else if(other.size() <= 0){
                entryToAdd = dequeueMin();
            } else if(size() <= 0){
                entryToAdd = other.dequeueMin();
            }
            if (entryToAdd != null){
                newDLPriorityQueue.enqueue(entryToAdd.getKey(), entryToAdd.getValue());
            }
        }
        ((DLPriorityQueue<K, V>) other).setList(temp);
        setList(newDLPriorityQueue.getEntryLinkedList());
        return newDLPriorityQueue;
    }

    public void setList(LinkedList<Entry<K, V>> newList){
        entryLinkedList = newList;
    }

    public LinkedList<Entry<K, V>> getEntryLinkedList() {
        return entryLinkedList;
    }
}
