package prepare.interview.concurrent.thread_pool.executor;

public class WorkerThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + task);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " Finished.");
    }

    private void processCommand() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String task;

    public WorkerThread(String task) {
        this.task = task;
    }

}
