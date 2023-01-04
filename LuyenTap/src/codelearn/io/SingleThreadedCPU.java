package codelearn.io;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SingleThreadedCPU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            int enqueueTime = scanner.nextInt();
            int processingTime = scanner.nextInt();
            tasks[i][0] = enqueueTime;
            tasks[i][1] = processingTime;
        }
        SingleThreadedCPU cpu = new SingleThreadedCPU();
        cpu.getOrder(tasks);
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];
        List<Task> taskList = new ArrayList<>();
//        PriorityQueue<Task> queue = new PriorityQueue<>(( a, b) -> {
//
//        })
        for (int i = 0; i < n; i++) {
            Task task = new Task(i, tasks[i][0], tasks[i][1]);
            taskList.add(task);
        }



        return result;
    }
}

class Task implements Comparable<Task>{
    private int index, enqueue, processing;

    public Task() {
    }

    public Task(int index, int enqueue, int processing) {
        this.index = index;
        this.enqueue = enqueue;
        this.processing = processing;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getEnqueue() {
        return enqueue;
    }

    public void setEnqueue(int enqueue) {
        this.enqueue = enqueue;
    }

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    @Override
    public int compareTo(Task o) {
        if( enqueue - o.enqueue > 0) return 1;
        if( enqueue - o.enqueue < 0) return -1;

        if( processing - o.processing > 0) return 1;
        if( processing - o.processing < 0) return -1;

        return 0;
    }

    @Override
    public String toString() {
        return String.format("Task %d: %d %d", index, enqueue, processing);
    }
}
/*
4
1 2
2 4
3 2
4 1
 */