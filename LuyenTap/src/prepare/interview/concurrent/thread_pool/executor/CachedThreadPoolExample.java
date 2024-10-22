package prepare.interview.concurrent.thread_pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    private static final int NUMBER_OF_THREADS = 5;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
            Thread.sleep(400);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }
}
