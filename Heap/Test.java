package Heap;

/**
 * Created by jml90 on 9/6/2016.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class Test {
    public static void main(String[] args)
    {
        System.out.println("Test for min Heap pop and pop \n");
        Heap<Integer> minHeap = new Heap<Integer>();
        Random r = new Random(100);

        for(int i = 0; i< 15;i++)
        {
            int num = r.nextInt(100);
            System.out.println("offer number " + num);
            if(r.nextInt(3) == 0) {
                System.out.println("pop number" + minHeap.poll());
            }
            minHeap.offer(num);
        }
        while(minHeap.size()>0)
        {
            System.out.println("poll number" + minHeap.poll());
        }
        System.out.println();
        System.out.println("Test for heapify the whole list \n");
        Integer[] arr = new Integer[]{3,5,2,6,7,1,4};
        Heap<Integer> minHeap1 = new Heap<Integer>(Arrays.asList(arr));
        while(minHeap1.size()>0)
        {
            System.out.println("poll number" + minHeap1.poll());
        }
        System.out.println("Test for External Comparator \n");
        Heap<Integer> maxHeap = new Heap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i< 25;i++)
        {
            int num = r.nextInt(100);
            System.out.println("offer number " + num);
            if(r.nextInt(3) == 0) {
                System.out.println("pop number" + maxHeap.poll());
            }
            maxHeap.offer(num);
        }
        while (maxHeap.size() > 0)
        {
            System.out.println("pop number" + maxHeap.poll());
        }

        System.out.println("Test for HashedIndexHeap \n");
        HashedIndexHeap<Integer> hashedIndexHeap = new HashedIndexHeap<Integer>();
        int []array = new int[]{4,3,-1,5,88,9,-100};
        for(int i = 0; i< array.length;i++)
        {
           System.out.println("offer number" + array[i]);
           hashedIndexHeap.offer(array[i]);
        }
        hashedIndexHeap.remove(array[3]);
        System.out.println("delete number" + array[3]);
        hashedIndexHeap.remove(array[4]);
        System.out.println("delete number" + array[4]);
        hashedIndexHeap.remove(array[0]);
        System.out.println("delete number" + array[0]);
        while (hashedIndexHeap.size()>0)
        {
            System.out.println("pop number " + hashedIndexHeap.poll());
        }

    }
}
