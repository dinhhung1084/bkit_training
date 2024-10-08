package DSA.LinkedList;


public class LinkedList1 {

    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static int length(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    private static int checkIfPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val)
                return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 4, 5, 2 };
        // Node x = new Node(array[2]);
        Node head = convertArr2LL(array);

        // System.out.println(x.data);
        // System.out.println(head.data);
        // System.out.println("length " + length(head));
        System.out.println(checkIfPresent(head, 5));
    }
}
