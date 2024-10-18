package Thread;

public class UsingJoinMethod2 extends Thread{
    public UsingJoinMethod2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!!!");
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(i+ " ");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        UsingJoinMethod2 t1 = new UsingJoinMethod2("Thread 1");
        UsingJoinMethod2 t2 = new UsingJoinMethod2("Thread 2");

        t1.start();
        try {
            t1.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        System.out.println("Main thread stopped!!!");
    }
}
