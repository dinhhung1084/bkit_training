package Thread;

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class ThreadDemoTest {
    public static void main(String args[]) {
        System.out.println("Main thread running... ");

        ThreadDemo T1 = new ThreadDemo("Thread-1-HR-Database");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2-Send-Email");
        T2.start();

        System.out.println("==&gt; Main thread stopped!!! ");
    }
}
