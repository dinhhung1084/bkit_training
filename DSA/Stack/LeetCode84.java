package DSA.Stack;

import java.util.Stack;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentAns = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentAns < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }

        return ans;
    }
}
