package Datastructures.Algorithmic;

public class Logarithmic {
    public static void logFunc(int n) {
        if (n == 0) {
            System.out.println("Done");
            return;
        }
        n = (int) Math.floor(n / 2.0);
        logFunc(n);
    }

    public static void logn(int n){
        while (n >1 ){
            n = (int) Math.floor(n /2.0);
        }
    }

    public static void main(String[] args) {
        logFunc(4);
        logn(5);
    }
}
