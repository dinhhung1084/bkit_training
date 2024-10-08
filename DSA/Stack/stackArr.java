package DSA.Stack;

public class stackArr {
    private static final int MAX = 4;

    public static int[] intArray = new int[MAX];
    public static int top = -1;

    public static void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
        top = top + 1;
        intArray[top] = data;
    }

    public static int pop() {
        int value;
        if (isEmpty()) {
            System.out.println("Stack overflow!");
            System.exit(1);
        }
        value = intArray[top];
        top = top - 1;
        return value;
    }

    public static int peek() {
        int value;
        if (isEmpty()) {
            System.out.println("Stack overflow!");
            System.exit(1);
        }
        value = intArray[top];
        return value;
    }

    public static void print() {
        if (isEmpty()) {
            System.out.println("Stack overflow!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(intArray[i]);
            System.out.println("\n");
        }
    }

    public static boolean isFull() {
        if (top == MAX - 1) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int data;
        push(1);
        push(2);
        push(3);
        push(4);
        data = pop();
        System.out.println(peek());
        System.out.println("Deleted: " + data);
        print();
    }
}
