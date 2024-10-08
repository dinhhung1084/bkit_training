package DSA.LinkedList;



public class LinkedList2 {

    Node head;

    LinkedList2() {
        this.head = null;
    }

    public void createLinkedList() {
        DSA.LinkedList.Node node1 = new DSA.LinkedList.Node(11);
        this.head = node1;

        DSA.LinkedList.Node node2 = new DSA.LinkedList.Node(18);
        node1.next = node2;

        DSA.LinkedList.Node node3 = new DSA.LinkedList.Node(24);
        node2.next = node3;
    }

    public void append(DSA.LinkedList.Node newNode) {

        DSA.LinkedList.Node current = this.head;

        if (current == null) {
            this.head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void insert(DSA.LinkedList.Node newNode, int index) {

        DSA.LinkedList.Node current = this.head;
        if (index == 0) {
            newNode.next = current;
            this.head = newNode;
        } else {

            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            }

        }

    }

    public int delete(int index) {

        DSA.LinkedList.Node current = this.head;
        DSA.LinkedList.Node previous = null;
        int deletedValue = -1;

        if (index == 0) {
            deletedValue = this.head.data;
            this.head = this.head.next;
            return deletedValue;
        }

        else {
            for (int i = 0; i < index && current != null; i++) {
                previous = current;
                current = current.next;

            }
            if (current != null) {

                deletedValue = current.data;
                previous.next = current.next;
            }
            return deletedValue;
        }
    }

    public void displayLinkedList() {

        DSA.LinkedList.Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;

        }
    }


    public static void main(String[] args) {
        LinkedList2 l1 = new LinkedList2();
        DSA.LinkedList.Node newNode1 = new DSA.LinkedList.Node(22);
        DSA.LinkedList.Node newNode2 = new DSA.LinkedList.Node(43);
        DSA.LinkedList.Node newNode3 = new DSA.LinkedList.Node(5);
        l1.createLinkedList();

        l1.append(newNode1);
        l1.insert(newNode2, 0);
        l1.insert(newNode3, 2);
        l1.delete(2);
        l1.displayLinkedList();
    }
}
