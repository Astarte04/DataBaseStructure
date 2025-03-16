import java.util.Stack;

public class test {
    public test() {
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        for(Integer i : stack) {
            System.out.println(i);
        }

        System.out.println("-------------");
        Integer a = (Integer)stack.pop();
        System.out.println("弹出的元素为:" + a);
        System.out.println("元素个数剩余:" + String.valueOf(stack.peek()));
    }
}
