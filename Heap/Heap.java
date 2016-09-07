package Heap;

import java.util.Comparator;
import java.util.List;
/**
 * Created by jml90 on 9/5/2016.
 */
public class Heap<T extends Comparable<T>> {
    private int size;
    private T[] array;
    private int capacity;
    private Comparator<T> cmp = null;
    private final static int INITIALIZE_SIZE = 10;

    public Heap() {
        size = 0;
        array = (T[]) new Comparable[INITIALIZE_SIZE];
        capacity = INITIALIZE_SIZE;
    }
    public Heap(Comparator<T> cmp)
    {
        size = 0;
        array = (T[]) new Comparable[INITIALIZE_SIZE];
        capacity = INITIALIZE_SIZE;
        this.cmp = cmp;

    }
    public Heap(int capacity,Comparator<T> cmp)
    {
        array = (T[]) new Comparable[capacity];
        this.capacity = capacity ;
        this.cmp = cmp;
        this.size = 0;
    }
    public Heap(List<T> list) {
        if (list == null) {
            throw new NullPointerException("Null Pointer Exception");
        }
        array = (T[])list.toArray();
        capacity = array.length/2 + array.length;
        size = array.length;
        Heapify();

    }
    public T peek()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Empty Queue");
        }
        return array[0];
    }
    public T poll()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Empty Queue");
        }
        T top = array[0];
        swap(array,0,size - 1);
        size--;
        shiftDown(0,size);
        return top;
    }
    private T[] expand(T []array)
    {
        T[] expandArray =(T[]) new Comparable[capacity/2 + capacity];
        for(int i = 0;i < array.length;i++)
        {
            expandArray[i] = array[i];
        }
        return expandArray;
    }
    public void offer(T val)
    {
        if(size + 1 >= capacity)
        {
            array = expand(array);
            capacity = array.length;
        }
        array[size] = val;
        shiftUp(size);
        size++;

    }
    private void shiftUp(int index)
    {
        while(index != 0 && compare(array[getParent(index)],array[index]) > 0)
        {
            swap(array,getParent(index),index);
            index =getParent(index);
        }
    }
    private int getParent(int child) {
        return child / 2;
    }

    private int getLeftChild(int parent) {
        return parent * 2 + 1;
    }

    private int getRightChild(int parent) {
        return parent * 2 + 2;
    }


    private void Heapify() {
        int len = size;
        for (int i = len / 2; i >= 0; i--) {
            shiftDown(i,len);
        }
    }
    public int size()
    {
        return size;
    }
    private void shiftDown( int start, int size) {
        while (start < size) {
            int left = getLeftChild(start);
            int right = getRightChild(start);
            int priorityElementIndex = start;

            if (left < size && compare(array[priorityElementIndex], array[left]) > 0) {
                priorityElementIndex = left;
            }
            if (right < size && compare(array[priorityElementIndex],array[right]) > 0) {
                priorityElementIndex = right;
            }
            if (priorityElementIndex == start) {
                break;
            }
            swap(array,start,priorityElementIndex);
            start = priorityElementIndex;
        }
    }

    private int compare(T t1, T t2) {
        if (cmp != null) {
            return cmp.compare(t1, t2);
        }
        return t1.compareTo(t2);
    }

    private void swap(T []array, int i, int j)
    {
       T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
