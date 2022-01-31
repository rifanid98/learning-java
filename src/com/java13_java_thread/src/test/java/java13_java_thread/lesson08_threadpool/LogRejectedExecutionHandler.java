package java13_java_thread.lesson08_threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class LogRejectedExecutionHandler implements RejectedExecutionHandler  {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task : " + r + " is rejected");
    }
}
