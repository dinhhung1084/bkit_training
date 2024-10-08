package DSA.Stack;

public class MinStack {

    private Node head;

    public MinStack() {

    }

    class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min, Node next) {
            this.min = min;
            this.next = next;
            this.value = value;
        }
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }

    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }

    }

    public int top() {
        return head.value;

    }

    public int getMin() {
        if (head == null) {
            return 0;
        } else {
            return head.min;
        }

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */