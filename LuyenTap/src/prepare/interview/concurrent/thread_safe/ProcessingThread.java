package prepare.interview.concurrent.thread_safe;

public class ProcessingThread implements Runnable{
    private int count;
    private final Object mutex=new Object();
    @Override
    public void run() {

        for (int i = 1; i < 5; i++) {
            processSomething(i);
            synchronized (mutex) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
    private void processSomething(int i) {
        try {
            Thread.sleep(i * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
