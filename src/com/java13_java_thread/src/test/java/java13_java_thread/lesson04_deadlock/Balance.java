package java13_java_thread.lesson04_deadlock;

public class Balance {
    private Long value;

    public Balance(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public static void transfer(Balance from, Balance to, Long value) throws InterruptedException {
        synchronized (from) {
            Thread.sleep(1_000L);
            from.setValue(from.getValue() - value);
        }
        synchronized (to) {
            Thread.sleep(1000L);
            to.setValue(to.getValue() + value);
        }
    }
}
