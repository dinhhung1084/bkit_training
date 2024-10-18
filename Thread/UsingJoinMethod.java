package Thread;

public class UsingJoinMethod extends Thread {
    public UsingJoinMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        UsingJoinMethod t1 = new UsingJoinMethod("Thread 1");
        UsingJoinMethod t2 = new UsingJoinMethod("Thread 2");
        UsingJoinMethod t3 = new UsingJoinMethod("Thread 3");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t3.start();
    }
}
