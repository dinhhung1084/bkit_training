package DSA.Stack;

import java.util.Stack;

public class LeetCode150 {
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*")
                    || token.equals("-")
                    || token.equals("+")
                    || token.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                int val;
                switch (token) {
                    case "+":
                        val = x + y;
                        break;
                    case "-":
                        val = x - y;
                        break;
                    case "*":
                        val = x * y;
                        break;
                    case "/":
                        val = x / y;
                        break;
                    default:
                        throw new AssertionError();
                }
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(token));
            }

        }
        System.out.println(stack.peek());
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens1 = new String[] { "2", "1", "+", "3", "*" };
        String[] tokens2 = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        evalRPN(tokens2);
    }
}
