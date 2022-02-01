package java13_java_thread.lesson29_reactive_stream;

import java.util.concurrent.Flow;

public class PrintSubcriber implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;
    private String name;
    private Long sleep;

    public PrintSubcriber(String name, Long sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        try {
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName() + " : " + name + " " + item);
            this.subscription.request(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println(Thread.currentThread().getName() + " : DONE");
    }
}
