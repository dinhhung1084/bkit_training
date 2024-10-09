package Datastructures.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
        Queue<Integer> num = new LinkedList<>();
//        Queue<Integer> num = new PriorityQueue<>();
        num.add(2); // add new value and return exception if add fails
        num.offer(3); // add new value and return false if add fails
        num.offer(4);
        num.offer(1);
        num.offer(9);
        System.out.println("Queues: " + num);
        System.out.println("First Value: " + num.element()); // get First Value and return exception if Queue is empty
        System.out.println("First Value: " + num.peek()); // get First Value and return null if Queue is empty
        System.out.println("Remove Value: " + num.remove()); // remove and return exception if Queue is empty
        System.out.println("Remove Value: " + num.poll()); // remove and return null if Queue is empty
        System.out.println("Queue Updated: " + num);
    }
}
