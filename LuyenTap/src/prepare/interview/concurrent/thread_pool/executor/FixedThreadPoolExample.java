package prepare.interview.concurrent.thread_pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    private static final int NUMBER_OF_THREADS = 5;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new WorkerThread("" + i);
            executor.execute(runnable);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }
}
