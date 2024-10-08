package DSA.Stack;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(int item) {
        items.add(item);
    }

    public Integer pop() {
        if (!isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null;
    }

    public Integer peek() {
        if (!isEmpty()) {
            return items.get(items.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after popping: " + stack.peek());
    }

}
