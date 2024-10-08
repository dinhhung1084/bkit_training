package DSA.Stack;//Design a max stack that supports push, pop, top, peekMax and popMax

import java.util.Stack;

public class LeetCode716 {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public LeetCode716() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
