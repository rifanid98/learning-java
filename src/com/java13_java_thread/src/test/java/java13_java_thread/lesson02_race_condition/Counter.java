package java13_java_thread.lesson02_race_condition;

public class Counter {

    private Long value = 0L;

    public void increment() {
        value++;
    }

    public Long getValue() {
        return value;
    }
}
