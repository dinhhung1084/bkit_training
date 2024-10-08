package DSA.Stack;

import java.util.Stack;

public class LeetCode739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
            System.out.println("\n");
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73, 22, 333 };
        dailyTemperatures(temperatures);
    }
}
