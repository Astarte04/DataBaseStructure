import java.util.Stack;

public class ReversePolan {
    public ReversePolan() {
    }

    public static void main(String[] args) {
        String[] test = new String[]{"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(test);
        System.out.println(result);  // 输出结果
    }

    public static int calculate(String[] str) {
        Stack<Integer> sint = new Stack<>();

        for (int i = 0; i < str.length; ++i) {
            switch (str[i]) {
                case "+":
                    // 弹出两个操作数
                    int i1 = sint.pop();
                    int i2 = sint.pop();
                    int sum = i2 + i1;  // 注意顺序，i2 + i1
                    sint.push(sum);
                    break;
                case "-":
                    i1 = sint.pop();
                    i2 = sint.pop();
                    int diff = i2 - i1;  // 注意顺序，i2 - i1
                    sint.push(diff);
                    break;
                case "*":
                    i1 = sint.pop();
                    i2 = sint.pop();
                    int product = i2 * i1;  // 注意顺序，i2 * i1
                    sint.push(product);
                    break;
                case "/":
                    i1 = sint.pop();
                    i2 = sint.pop();
                    int quotient = i2 / i1;  // 注意顺序，i2 / i1
                    sint.push(quotient);
                    break;
                default:
                    // 如果是数字，直接入栈
                    sint.push(Integer.parseInt(str[i]));
            }
        }

        // 最后栈中应该只有一个元素，就是结果
        return sint.pop();
    }
}



