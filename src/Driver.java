import java.util.function.Consumer;

public class Driver {

    public static void main(String[] args) {
        DLPriorityQueue<Integer, String> testQueue = new DLPriorityQueue<>();
        testQueue.enqueue(21, "21");
        testQueue.enqueue(5, "5");
        testQueue.enqueue(82, "82");
        testQueue.enqueue(54, "54");
        testQueue.enqueue(234, "234");
        testQueue.enqueue(7, "7");

        DLPriorityQueue<Integer, String> testQueue2 = new DLPriorityQueue<>();
        testQueue2.enqueue(1, "1");
        testQueue2.enqueue(2, "2");
        testQueue2.enqueue(9, "9");
        testQueue2.enqueue(64, "64");
        testQueue2.enqueue(5, "5");
        testQueue2.enqueue(4, "4");


        DLPriorityQueue<Integer, String> testQueue3 = (DLPriorityQueue<Integer, String>) testQueue.merge(testQueue2);

        testQueue2.getEntryLinkedList().forEach(o -> {
            if (o != null) {
                System.out.println(((Entry) o).getValue());
            }
        });


    }
}
