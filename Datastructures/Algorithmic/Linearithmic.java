package Datastructures.Algorithmic;

public class Linearithmic {
    public static void nLogNFunc(int n){
        int y = n;
        while (n>1){
            n=  (int) Math.floor(n/2);
            for (int i = 0; i <= y ; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        nLogNFunc(8);
    }
}
