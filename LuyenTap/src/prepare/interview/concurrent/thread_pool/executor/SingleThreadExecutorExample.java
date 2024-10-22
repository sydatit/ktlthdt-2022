package prepare.interview.concurrent.thread_pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }

        executor.shutdown();
//
//        Runnable worker = new WorkerThread("" + 100);
//        executor.execute(worker);

        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}
