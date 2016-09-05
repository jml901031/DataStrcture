package Stack;

import java.util.EmptyStackException;

/**
 * Created by jml90 on 9/4/2016.
 */
public class BoundedStack<T> {
    private T []array = null;
    private int size = 0;
    private final int capacity;
    public BoundedStack(final int capacity)
    {
        array = (T[])new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    public void push(T val)  {
        if(val == null)
        {
            throw new NullPointerException("NULL Pointer Exception");
        }
        if(size == capacity) {
            throw new IndexOutOfBoundsException("Exceed limit Size");
        }
        array[size++] = val;
    }
    public T pop()
    {
        if(size == 0)
        {
            throw new EmptyStackException();
        }
        return array[--size];
    }
    public int size()
    {
        return size;
    }
    public T peek()
    {
        return array[size - 1];
    }
}
