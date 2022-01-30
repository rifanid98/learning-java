package java13_java_thread.lesson03_synchronization;

public class SynchronizeStatementCounter {
    private Long value = 0L;

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public Long getValue() {
        return value;
    }
}
