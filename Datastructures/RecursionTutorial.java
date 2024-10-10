package Datastructures;

public class RecursionTutorial {
    public static void main(String[] args) {
        sayHi(1000);
    }
    public static void sayHi(int n){
        System.out.println("Hi!");
        if (n <= 1){
            return;
        }
        sayHi(n -1);
    }
}
