package java13_java_thread.lesson27_fork_join;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TotalForkJoinTask extends RecursiveTask<Long> {

    final private List<Integer> integers;

    public TotalForkJoinTask(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    protected Long compute() {
        if (integers.size() <= 10) {
            return doCompute();
        } else {
            return forkCompute();
        }
    }

    private Long doCompute() {
        return integers.stream().mapToLong(value -> value).peek(value -> {
            System.out.println(Thread.currentThread().getName() + " : " + value);
        }).sum();
    }

    private Long forkCompute() {
        List<Integer> integers1 = this.integers.subList(0, this.integers.size() / 2);
        TotalForkJoinTask task1 = new TotalForkJoinTask(integers1);

        List<Integer> integers2 = this.integers.subList(this.integers.size() / 2, this.integers.size());
        TotalForkJoinTask task2 = new TotalForkJoinTask(integers2);

        ForkJoinTask.invokeAll(task1, task2);
        return task1.join() + task2.join();
    }
}
