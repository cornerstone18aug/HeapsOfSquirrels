import java.util.function.Consumer;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Tests \n");
        DLPriorityQueue<Integer, String> testDLQueue = new DLPriorityQueue<>();
        testDLQueue.enqueue(21, "21");
        testDLQueue.enqueue(5, "5");
        testDLQueue.enqueue(82, "82");
        testDLQueue.enqueue(54, "54");
        testDLQueue.enqueue(234, "234");
        testDLQueue.enqueue(7, "7");

        DLPriorityQueue<Integer, String> testDLQueue2 = new DLPriorityQueue<>();
        testDLQueue2.enqueue(1, "1");
        testDLQueue2.enqueue(2, "2");
        testDLQueue2.enqueue(9, "9");
        testDLQueue2.enqueue(64, "64");
        testDLQueue2.enqueue(5, "5");
        testDLQueue2.enqueue(4, "4");

        System.out.println("Single DL Queue: ");
        testDLQueue2.getEntryLinkedList().forEach(o -> {
            if (o != null) {
                System.out.println(((Entry) o).getValue());
            }
        });
        System.out.println();

        System.out.println("Merge DL Queue: ");
        DLPriorityQueue<Integer, String> testDLQueue3 = (DLPriorityQueue<Integer, String>) testDLQueue.merge(testDLQueue2);
        testDLQueue3.getEntryLinkedList().forEach(o -> {
            if (o != null) {
                System.out.println(((Entry) o).getValue());
            }
        });
        System.out.println();

        ALPriorityQueue<Integer, String> testALQueue = new ALPriorityQueue<>();
        testALQueue.enqueue(21, "21");
        testALQueue.enqueue(5, "5");
        testALQueue.enqueue(82, "82");
        testALQueue.enqueue(54, "54");
        testALQueue.enqueue(234, "234");
        testALQueue.enqueue(7, "7");

        ALPriorityQueue<Integer, String> testALQueue2 = new ALPriorityQueue<>();
        testALQueue2.enqueue(1, "1");
        testALQueue2.enqueue(2, "2");
        testALQueue2.enqueue(9, "9");
        testALQueue2.enqueue(64, "64");
        testALQueue2.enqueue(5, "5");
        testALQueue2.enqueue(4, "4");

        ALPriorityQueue<Integer, String> testALQueue4 = new ALPriorityQueue<>();
        testALQueue4.enqueue(1, "1");
        testALQueue4.enqueue(2, "2");
        testALQueue4.enqueue(9, "9");
        testALQueue4.enqueue(64, "64");
        testALQueue4.enqueue(5, "5");
        testALQueue4.enqueue(4, "4");

        System.out.println("Single AL Queue: ");
        int toIterate = testALQueue4.size();
        for (int i = 0; i < toIterate; i++){
            System.out.println(testALQueue4.dequeueMin().getValue());
        }
        System.out.println();

        System.out.println("Merge AL Queue: ");
        ALPriorityQueue<Integer, String> testALQueue3 = (ALPriorityQueue<Integer, String>) testALQueue.merge(testALQueue2);
        toIterate = testALQueue3.size();
        for (int i = 0; i < toIterate; i++){
            System.out.println( testALQueue3.dequeueMin().getValue());
        }
        System.out.println();


        BHPriorityQueueue<Integer, String> testBHQueue = new BHPriorityQueueue<>();
        testBHQueue.enqueue(21, "21");
        testBHQueue.enqueue(5, "5");
        testBHQueue.enqueue(82, "82");
        testBHQueue.enqueue(54, "54");
        testBHQueue.enqueue(234, "234");
        testBHQueue.enqueue(7, "7");

        BHPriorityQueueue<Integer, String> testBHQueue2 = new BHPriorityQueueue<>();
        testBHQueue2.enqueue(1, "1");
        testBHQueue2.enqueue(2, "2");
        testBHQueue2.enqueue(9, "9");
        testBHQueue2.enqueue(64, "64");
        testBHQueue2.enqueue(5, "5");
        testBHQueue2.enqueue(4, "4");

        System.out.println("Single BH Queue: ");
        testBHQueue2.getList().forEach(o -> {
            if (o != null) {
                System.out.println(((Entry) o).getValue());
            }
        });
        System.out.println();

        System.out.println("Merge BH Queue: ");
        BHPriorityQueueue<Integer, String> testBHQueue3 = (BHPriorityQueueue<Integer, String>) testBHQueue.merge(testBHQueue2);
        testBHQueue3.getList().forEach(o -> {
            if (o != null) {
                System.out.println(((Entry) o).getValue());
            }
        });
        System.out.println();



    }
}
