package java17_lombok.lesson13_synchronized;

import lombok.Synchronized;

public class Counter {

    private final Object counterLock = new Object();

    private Long counter = 0L;

    @Synchronized(value = "counterLock")
    public void increment() {
        counter++;
    }

    @Synchronized(value = "counterLock")
    public Long getCounter() {
        return counter;
    }
}
