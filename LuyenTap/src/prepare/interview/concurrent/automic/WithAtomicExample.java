package prepare.interview.concurrent.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomicExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomic = new AtomicInteger(0);
        Runnable run = () -> {
            for (int i = 0; i < 1000; i++) {
                atomic.incrementAndGet();
            }
        };

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(atomic.get());
    }
}
