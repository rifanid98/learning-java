package java14_reflection.lesson14_parameterized_type;

public class Data<T extends AutoCloseable> {
    private T data;

    public T getData() {
        return data;
    }
}
