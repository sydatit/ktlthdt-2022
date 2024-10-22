package prepare.interview.concurrent.thread_pool.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    private static final int NUM_OF_THREADS = 2;
    private static final int INITIAL_DELAY = 1;
    private static final int DELAY = 3;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_OF_THREADS);

        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.scheduleAtFixedRate(worker, INITIAL_DELAY, DELAY, TimeUnit.SECONDS);
        }

        executor.awaitTermination(10, TimeUnit.SECONDS);

        executor.shutdown();

        while (!executor.isTerminated()) {}
        System.out.println("Finished all threads");
    }
}
