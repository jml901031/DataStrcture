package Queue;

/**
 * Created by jml90 on 9/5/2016.
 */
public class BoundedQueue<T> {
    private T []array = null;
    private int capacity = 0;
    private int size = 0;
    private int cur = 0;
    private int head = 0;
    public BoundedQueue(int capacity)
    {
        this.capacity = capacity;
        this.size = size;
        array = (T[])new Object[capacity];

    }
    public void offer(T val)
    {
        if(val == null)
        {
            throw new NullPointerException("NULL Pointer Exception");
        }
        if(size == capacity)
        {
            throw  new IndexOutOfBoundsException("queue is full");
        }
        array[cur] = val;
        cur = (cur + 1)%capacity;
        size++;
    }
    public T poll()
    {
        if(size == 0)
        {
            throw  new IndexOutOfBoundsException("queue is empty");
        }
        T val = array[head];
        head = (head + 1)%size;
        size++;
        return val;
    }
    public T peek()
    {
        if(size == 0)
        {
            throw  new IndexOutOfBoundsException("queue is empty");
        }
        return array[head];
    }
    public int size()
    {
        return size;
    }
}
