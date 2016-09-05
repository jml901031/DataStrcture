package Queue;

/**
 * Created by jml90 on 9/4/2016.
 */
public class Queue <T>{
    private ListNode head;
    private ListNode tail;
    private int size;
    public Queue()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size()
    {
        return size;
    }
    public void offer(T val)
    {
        if(val == null)
        {
            throw new NullPointerException("NULL Pointer Exception");
        }
        ListNode node = new ListNode(val);
        if(head == null)
        {
            head = tail = node;
        }
        else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public T poll()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Empty Queue");
        }
        ListNode node = head;
        head = head.next;
        size--;
        return (T)node.value;
    }

    public T peek()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Empty Queue");
        }
        return (T)head.value;
    }
}
