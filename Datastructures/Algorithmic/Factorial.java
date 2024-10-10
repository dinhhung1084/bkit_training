package Datastructures.Algorithmic;

public class Factorial {
    public static void f(int n){
        if (n == 0){
            System.out.println("**************");
            return;
        }
        for (int i = 0; i < n; i++) {
            f(n-1);
        }
    }

    public static void main(String[] args) {
        f(3);
    }
}
