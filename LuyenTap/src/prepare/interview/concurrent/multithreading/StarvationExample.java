package prepare.interview.concurrent.multithreading;

public class StarvationExample extends Thread{
    public static void main(String[] args) {
        System.out.println("Main thread execution started");

        StarvationExample thread1 = new StarvationExample();
        thread1.setPriority(10);
        StarvationExample thread2 = new StarvationExample();
        thread2.setPriority(9);
        StarvationExample thread3 = new StarvationExample();
        thread3.setPriority(8);
        StarvationExample thread4 = new StarvationExample();
        thread4.setPriority(7);
        StarvationExample thread5 = new StarvationExample();
        thread5.setPriority(6);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread5.start();

        System.out.println("Main thread execution completed");
    }

    static int threadCount = 1;
    @Override
    public void run() {
        System.out.println(threadCount + "st child thread execution starts");

        System.out.println("Child thread execution completes");
        threadCount++;
    }
}
