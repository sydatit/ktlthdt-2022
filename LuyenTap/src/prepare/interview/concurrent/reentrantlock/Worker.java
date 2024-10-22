package prepare.interview.concurrent.reentrantlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    String name;
    ReentrantLock re;

    public Worker(String name, ReentrantLock re) {
        this.name = name;
        this.re = re;
    }

    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            boolean ans = re.tryLock();

            if (ans) {
                try {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println(String.format("Task name: %s outer lock acquired at %s Doing outer work", name, ft.format(d)));
                    Thread.sleep(1500);

                    re.lock();
                    try {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");


                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }
    }
}
