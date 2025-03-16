public class queueTest {

        public queueTest() {
        }

        public static void main(String[] args) {
            Queue<Integer> q = new Queue<>();
            q.inQueue(10);
            q.inQueue(20);
            q.inQueue(30);
            q.inQueue(40);
            q.printQueue();
            System.out.println("-------------");
            q.outQueue(10);
            q.printQueue();
        }


}
