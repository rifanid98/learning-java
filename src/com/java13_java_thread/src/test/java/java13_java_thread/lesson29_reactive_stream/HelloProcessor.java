package java13_java_thread.lesson29_reactive_stream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class HelloProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        submit("Hello : " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }
}
