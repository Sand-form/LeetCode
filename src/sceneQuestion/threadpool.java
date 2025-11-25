package sceneQuestion;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadpool {
    public static void main(String[] args) {
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4,
                60, TimeUnit.SECONDS,
                queue
        );

        executor.execute(new PriorityTask(3, "任务1"));
        executor.execute(new PriorityTask(2, "任务2"));
        executor.execute(new PriorityTask(1, "任务3"));

        executor.shutdown();
    }
}

class PriorityTask implements Runnable, Comparable<PriorityTask> {
    private int priority;
    private String name;

    public PriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("执行任务：" + name + "，优先级：" + priority);
    }

    @Override
    public int compareTo(PriorityTask other) {
        // 如果返回负数，表示当前对象小，排在前面
        return Integer.compare(this.priority, other.priority);
    }
}