package java13_java_thread.lesson03_synchronization;

public class SynchronizeCounter {
    private Long value = 0L;

    public synchronized void increment() {
        value++;
    }

    public Long getValue() {
        return value;
    }
}
