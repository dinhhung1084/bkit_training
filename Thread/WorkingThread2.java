package Thread;

import java.util.Random;

public class WorkingThread2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            processSomething();
        }
    }

    private void processSomething() {
        try {
            System.out.println("Processing working thread");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 70) {
            throw new RuntimeException("Simulate an exception was not handled in the thread");
        }
    }

    public static void main(String[] args) {
        System.out.println("==> Main thread running...");

        Thread thread = new Thread(new WorkingThread2());
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("#Thread: " + t);
                System.out.println("#Thread exception message: " + e.getMessage());
            }
        });

        thread.start();
        System.out.println("==&amp;gt; Main thread end!!!");
    }

}
