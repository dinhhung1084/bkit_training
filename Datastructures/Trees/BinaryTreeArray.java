package Datastructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeArray {

    static String[] binaryTreeArray = {"R", "A", "B", "C", "D", "E", "F", null, null, null, null, null, null, "G"};

    public static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public static List<String> preOrder(int index) {
        List<String> result = new ArrayList<>();
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return result;
        }
        result.add(binaryTreeArray[index]); // Root
        result.addAll(preOrder(leftChildIndex(index))); // Left
        result.addAll(preOrder(rightChildIndex(index))); // Right
        return result;
    }

    public static List<String> inOrder(int index) {
        List<String> result = new ArrayList<>();
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return result;
        }
        result.addAll(inOrder(leftChildIndex(index))); // Left
        result.add(binaryTreeArray[index]); // Root
        result.addAll(inOrder(rightChildIndex(index))); // Right
        return result;
    }

    public static List<String> postOrder(int index) {
        List<String> result = new ArrayList<>();
        if (index >= binaryTreeArray.length || binaryTreeArray[index] == null) {
            return result;
        }
        result.addAll(postOrder(leftChildIndex(index))); // Left
        result.addAll(postOrder(rightChildIndex(index))); // Right
        result.add(binaryTreeArray[index]); // Root
        return result;
    }

    public static String getData(int index) {
        if (index >= 0 && index < binaryTreeArray.length) {
            return binaryTreeArray[index];
        }
        return null;
    }

    public static void main(String[] args) {
        int rightChild = rightChildIndex(0);
        int leftChildOfRightChild = leftChildIndex(rightChild);
        String data = getData(leftChildOfRightChild);

        System.out.println("root.right.left.data: " + data);
        System.out.println("Pre-order Traversal: " + preOrder(0));
        System.out.println("In-order Traversal: " + inOrder(0));
        System.out.println("Post-order Traversal: " + postOrder(0));
    }
}
