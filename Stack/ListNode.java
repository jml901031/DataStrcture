package Stack;

/**
 * Created by jml90 on 9/4/2016.
 */
class ListNode <T> {
    T value  = null;
    ListNode next = null;
    ListNode prev = null;
    public ListNode(T value)
    {
        this.value = value;
        next = null;
        prev = null;
    }
}
