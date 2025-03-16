import java.util.Stack;

public class BracketsMatchTest {
    public BracketsMatchTest() {
    }

    public static void main(String[] args) {
        String str = "上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str + " 中的括号是否匹配：" + match);
    }

    public static boolean isMatch(String str) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < str.length(); ++i) {
            char currChar = str.charAt(i);
            if (currChar == '(') {
                stack.push(currChar);
            } else if (currChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
