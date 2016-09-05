package Queue;

/**
 * Created by jml90 on 9/4/2016.
 */
public class Test {
    public static void main(String []args)
    {
        Queue<Integer> queue = new Queue<Integer>();
        queue.offer(1);
        System.out.println("Offer 1");
        System.out.println("size " + queue.size());
        queue.offer(2);
        System.out.println("Offer 2");
        System.out.println("size " + queue.size());
        queue.offer(3);
        System.out.println("Offer 3");
        System.out.println("size " + queue.size());
        int a = queue.peek();
        System.out.println("peek element " + a);
        BoundedQueue<Integer> queue1 = new BoundedQueue<Integer>(3);
        queue1.offer(1);
        System.out.println("Offer 1");
        System.out.println("size " + queue1.size());
        queue1.offer(2);
        System.out.println("Offer 2");
        System.out.println("size " + queue1.size());
        queue1.offer(3);
        System.out.println("Offer 3");
        System.out.println("size " + queue1.size());
        int p = queue1.poll();
        System.out.println("Poll " + p);
        System.out.println("peek " + queue1.peek());
        queue1.offer(4);
        System.out.println("Offer 4");
        System.out.println("size " + queue1.size());
        System.out.println("peek " + queue1.peek());

    }

}
