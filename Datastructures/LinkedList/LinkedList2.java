package Datastructures.LinkedList;



public class LinkedList2 {

    Node head;

    LinkedList2() {
        this.head = null;
    }

    public void createLinkedList() {
        Datastructures.LinkedList.Node node1 = new Datastructures.LinkedList.Node(11);
        this.head = node1;

        Datastructures.LinkedList.Node node2 = new Datastructures.LinkedList.Node(18);
        node1.next = node2;

        Datastructures.LinkedList.Node node3 = new Datastructures.LinkedList.Node(24);
        node2.next = node3;
    }

    public void append(Datastructures.LinkedList.Node newNode) {

        Datastructures.LinkedList.Node current = this.head;

        if (current == null) {
            this.head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void insert(Datastructures.LinkedList.Node newNode, int index) {

        Datastructures.LinkedList.Node current = this.head;
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

        Datastructures.LinkedList.Node current = this.head;
        Datastructures.LinkedList.Node previous = null;
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

        Datastructures.LinkedList.Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;

        }
    }


    public static void main(String[] args) {
        LinkedList2 l1 = new LinkedList2();
        Datastructures.LinkedList.Node newNode1 = new Datastructures.LinkedList.Node(22);
        Datastructures.LinkedList.Node newNode2 = new Datastructures.LinkedList.Node(43);
        Datastructures.LinkedList.Node newNode3 = new Datastructures.LinkedList.Node(5);
        l1.createLinkedList();

        l1.append(newNode1);
        l1.insert(newNode2, 0);
        l1.insert(newNode3, 2);
        l1.delete(2);
        l1.displayLinkedList();
    }
}
