package java13_java_thread.lesson25_thread_local;

public class UserService {

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setUser(String user) {
        threadLocal.set(user);
    }

    public void doAction() {
        String user = threadLocal.get();
        System.out.println(user + " do action");
    }
}
