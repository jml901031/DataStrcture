package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jml90 on 9/6/2016.
 */
//with o(logn) deletion;
public class HashedIndexHeap<T extends Comparable<T>> {
    private int size;
    private T[] array;
    private int capacity;
    private Comparator<T> cmp = null;
    private final static int INITIALIZE_SIZE = 10;
    HashMap<T,Integer> indexRecorder = new HashMap<T, Integer>();
    public HashedIndexHeap() {
        size = 0;
        array = (T[]) new Comparable[INITIALIZE_SIZE];
        capacity = INITIALIZE_SIZE;
    }
    public HashedIndexHeap(Comparator<T> cmp)
    {
        size = 0;
        array = (T[]) new Comparable[INITIALIZE_SIZE];
        capacity = INITIALIZE_SIZE;
        this.cmp = cmp;

    }
    public HashedIndexHeap(int capacity,Comparator<T> cmp)
    {
        array = (T[]) new Comparable[capacity];
        this.capacity = capacity ;
        this.cmp = cmp;
        this.size = 0;
    }
    public HashedIndexHeap(List<T> list) {
        if (list == null) {
            throw new NullPointerException("Null Pointer Exception");
        }
        array = (T[])list.toArray();
        capacity = array.length/2 + array.length;
        size = array.length;
        for(int i = 0;i < array.length;i++)
        {
            indexRecorder.put(array[i],i);
        }
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
        indexRecorder.remove(top);
        size--;
        shiftDown(0,size);
        return top;
    }
    private T[] expand(T []array)
    {
        T[] expandArray =(T[]) new Comparable[array.length/2 + array.length];
        for(int i = 0;i < array.length;i++)
        {
            expandArray[i] = array[i];
        }
        return expandArray;
    }
    public T offer(T val)
    {
        if(size + 1 >= array.length)
        {
            array = expand(array);
            capacity = array.length;
        }
        T top = array[0];
        array[size] = val;
        indexRecorder.put(val,size);
        shiftUp(size);
        size++;
        return top;
    }
    private void shiftUp(int index)
    {
        while(index != 0 && compare(array[getParent(index)],array[index]) > 0)
        {

            swap(array,getParent(index),index);

            index =getParent(index);
        }
    }
    public boolean remove(T val)
    {
        Integer index = indexRecorder.get(val);
        if(index == null)
        {
            return false;
        }
        swap(array,index,size - 1);
        indexRecorder.remove(val);
        size--;
        shiftDown(index,size);
        shiftUp(index);
        return true;
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
        indexRecorder.put(array[i],j);
        indexRecorder.put(array[j],i);
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}