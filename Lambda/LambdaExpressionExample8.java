package Lambda;

public class LambdaExpressionExample8 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Turn it up!");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = () -> {
            System.out.println("Every body!");
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }

}
