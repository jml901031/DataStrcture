package Stack;

import java.util.EmptyStackException;

/**
 * Created by jml90 on 9/4/2016.
 */
public class Stack<T> {
        private ListNode head = null;
        private int size = 0;
        private ListNode cur = null;
        public Stack()
        {
            head = null;
            cur = null;
            size = 0;
        }
        public void push(T val)
        {
            if(val == null)
            {
                throw new NullPointerException("NULLPointerException");
            }
            ListNode element = new ListNode<T>(val);
            if(head == null)
            {
                cur = head = element;
            }
            else
            {
                cur.next = element;
                element.prev = cur;
                cur = cur.next;
            }
            size++;
        }
        public T pop()
        {
            if(size == 0)
            {
                throw new EmptyStackException();
            }
            ListNode node = cur;
            cur.prev.next = null;
            cur = cur.prev;
            size--;
            return (T)node.value;
        }
        public int size()
        {
            return size;
        }
        public T peek()
        {
            if(size == 0)
            {
                throw new EmptyStackException();
            }
            return (T)cur.value;
        }

}