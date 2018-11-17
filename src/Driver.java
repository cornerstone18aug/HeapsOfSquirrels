public class Driver {

    public static void main(String[] args) {
        BHPriorityQueueue testQueue = new BHPriorityQueueue();
        testQueue.enqueue(11, "Eleven");
        testQueue.enqueue(1, "One");
        testQueue.enqueue(10, "Ten");
        testQueue.enqueue(3, "Three");
        testQueue.enqueue(5, "Five");
        testQueue.enqueue(4, "Four");

        System.out.println(testQueue.peek().getValue());
        System.out.println(testQueue.dequeueMin().getValue());
        System.out.println(testQueue.dequeueMin().getValue());
        System.out.println(testQueue.dequeueMin().getValue());
        System.out.println(testQueue.dequeueMin().getValue());
        System.out.println(testQueue.dequeueMin().getValue());
        System.out.println(testQueue.dequeueMin().getValue());


    }

}
