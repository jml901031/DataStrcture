package Stack;

/**
 * Created by jml90 on 9/4/2016.
 */
public class Test {
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        System.out.println("push " + 1);
        System.out.println("Current size: "+stack.size());
        stack.push(2);
        System.out.println("push " + 2);
        System.out.println("Current size: "+stack.size());
        stack.push(3);
        System.out.println("push " + 3);
        System.out.println("Current size: "+stack.size());
        int element = stack.pop();
        System.out.println("pop " + element);
        System.out.println("Current size: "+stack.size());
        element = stack.peek();
        System.out.println("peek " +element );
        System.out.println("Current size: "+stack.size());

        BoundedStack<Integer>  boundedStack = new BoundedStack<Integer>(10);
        for(int i = 1;i <= 10;i++)
        {
            System.out.println("push " + i);
           boundedStack.push(i);
        }
        System.out.println("pop " + boundedStack.pop());
        System.out.println("Current Size: "+ boundedStack.size());
    }
}
