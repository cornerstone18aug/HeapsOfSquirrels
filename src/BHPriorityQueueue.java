import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BHPriorityQueueue<K extends  Comparable, V> implements VCPriorityQueue<K, V> {

    private List<Entry<K, V>> priorityQueue;

    public BHPriorityQueueue() {
        this.priorityQueue = new ArrayList<>();
        priorityQueue.add(0, null);
    }

    //Not used
    public BHPriorityQueueue(List<Entry<K, V>>... lists){
        this.priorityQueue = new ArrayList<>();
        for (List l: lists){
            priorityQueue.addAll(l);
        }
        priorityQueue.add(0, null);
        int firstRootIndex = priorityQueue.size() % 2 == 0 ? priorityQueue.size() / 2 : (priorityQueue.size() - 1) / 2;
        for (int i = firstRootIndex; i>0; i--){
            ClimbUp(priorityQueue.get(i));
        }
    }

    @Override
    public int size() {
        return priorityQueue.size()<= 1 ? 0:(priorityQueue.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.size() <= 2;
    }

    @Override
    public Entry<K,V> enqueue(Comparable key, Object value) throws IllegalArgumentException {
        Entry entityToAdd = new Entry(key, value);
        priorityQueue.add(entityToAdd);
        ClimbUp(entityToAdd);
        return entityToAdd;
    }

    @Override
    public Entry<K, V> peek() {
        if(isEmpty()){
            return null;
        }
        return priorityQueue.get(1);
    }

    @Override
    public Entry<K, V> dequeueMin() {
        if(isEmpty()){
            return null;
        }
        Entry<K, V> entryRemoved = priorityQueue.get(1);
        if(size() <= 1){
            priorityQueue.remove(1);
        } else {
            priorityQueue.set(1, priorityQueue.remove(size()));
            ClimbDown(priorityQueue.get(1));
        }
        return entryRemoved;

    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue other) {
        List<Entry<K, V>> otherList = ((BHPriorityQueueue<K,V>) other).getList();
        otherList.remove(0);
        priorityQueue.addAll(otherList);
        int firstRootIndex = priorityQueue.size()/2 + 1;
        for (int i = firstRootIndex; i>0; i--){
            ClimbDown(priorityQueue.get(i));
        }
        return this;
    }

    private void ClimbUp(Entry entry)
    {
        int selfIndex = priorityQueue.indexOf(entry);
        if(isEmpty()){
            return;
        }
        while (selfIndex >= 1)
        {
            Entry<K, V> entryToCompare;
             if (selfIndex % 2 == 0) {
                entryToCompare = priorityQueue.get(selfIndex/2);
            } else{
                entryToCompare = priorityQueue.get((selfIndex-1)/2);
            }
            if(entryToCompare != null && (entryToCompare.getKey().compareTo(entry.getKey()) > 0)){
                Swap(selfIndex, priorityQueue.indexOf(entryToCompare));
            } else{
                return;
            }
            selfIndex = priorityQueue.indexOf(entry);
        }
    }

    private void ClimbDown(Entry entry){
        int selfIndex = priorityQueue.indexOf(entry);
        while(selfIndex < priorityQueue.size())
        {
            Entry<K,V> leftElement =  (selfIndex*2) > priorityQueue.size()-1 ? null : priorityQueue.get(selfIndex*2);
            Entry<K,V> rightElement = (selfIndex*2)+1 > priorityQueue.size()-1 ? null : priorityQueue.get((selfIndex*2)+1);
            if(rightElement == null && leftElement == null){
                return;
            } else if(leftElement == null){
                if(rightElement.getKey().compareTo(entry.getKey()) < 0){
                    Swap(selfIndex, priorityQueue.indexOf(rightElement));
                } else {
                    return;
                }
            } else if(rightElement == null){
                if(leftElement.getKey().compareTo(entry.getKey()) < 0) {
                    Swap(selfIndex, priorityQueue.indexOf(leftElement));
                } else {
                    return;
                }
            } else {
                if (leftElement.getKey().compareTo(entry.getKey()) < 0 && rightElement.getKey().compareTo(entry.getKey()) < 0) {
                    if (leftElement.getKey().compareTo(rightElement.getKey()) < 0) {
                        Swap(selfIndex, priorityQueue.indexOf(leftElement));
                    } else {
                        Swap(selfIndex, priorityQueue.indexOf(rightElement));
                    }
                } else if (leftElement.getKey().compareTo(entry.getKey()) < 0) {
                    Swap(selfIndex, priorityQueue.indexOf(leftElement));
                } else if (rightElement.getKey().compareTo(entry.getKey()) < 0) {
                    Swap(selfIndex, priorityQueue.indexOf(rightElement));
                } else {
                    return;
                }
            }
            selfIndex = priorityQueue.indexOf(entry);
        }
    }

    private void Swap(int index1, int index2){
        Entry<K, V> temp1 = priorityQueue.get(index1);
        Entry<K, V> temp2 = priorityQueue.get(index2);
        priorityQueue.set(index1, temp2);
        priorityQueue.set(index2, temp1);
    }

    public List<Entry<K, V>> getList(){
        return priorityQueue;
    }


}
