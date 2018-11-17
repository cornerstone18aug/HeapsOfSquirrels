import java.util.function.Consumer;

public class Driver {

    public static void main(String[] args) {
        BHPriorityQueueue testQueue = new BHPriorityQueueue();
        testQueue.enqueue(11, "Eleven");
        testQueue.enqueue(1, "One");
        testQueue.enqueue(10, "Ten");
        testQueue.enqueue(3, "Three");
        testQueue.enqueue(5, "Five");
        testQueue.enqueue(4, "Four");

        BHPriorityQueueue testQueue2 = new BHPriorityQueueue();
        testQueue.enqueue(9, "Nine");
        testQueue.enqueue(7, "Seven");
        testQueue.enqueue(6, "Six");
        testQueue.enqueue(2, "Two");
        testQueue.enqueue(0, "Zero");
        testQueue.enqueue(8, "Eight");


        BHPriorityQueueue testQueue3 = (BHPriorityQueueue) testQueue.merge(testQueue2);

        testQueue3.getList().forEach(o -> {
            if (o != null){
                System.out.println(((Entry)o).getValue());
            }
        });

    }

}
