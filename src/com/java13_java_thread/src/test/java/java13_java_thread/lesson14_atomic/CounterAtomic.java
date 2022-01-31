package java13_java_thread.lesson14_atomic;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

    private final AtomicLong value = new AtomicLong(0L);

    public void increment() {
        value.incrementAndGet();
    }

    public Long getValue() {
        return value.get();
    }
}
