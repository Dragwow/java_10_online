
package ua.com.alevel.hw_7.reactiv;

import ua.com.alevel.hw_7.config.LoaderPage;

import java.util.function.Consumer;

public class NativePubSub {

    private static final NativePubSub instance = new NativePubSub();
    private Consumer<LoaderPage> publisher;
    private Consumer<Boolean> publisherGroup;
    private Consumer<Boolean> publisherAcc;

    private NativePubSub() { }

    public static NativePubSub getInstance() {
        return instance;
    }

    public void publish(LoaderPage page) {
        publisher.accept(page);
    }

    public void publishAcc(Boolean publishAcc){
        if (this.publisherAcc != null) {
            this.publisherAcc.accept(publishAcc);
        }
    }

    public void publishGroup(Boolean publishGroup) {
        publisherGroup.accept(publishGroup);
    }

    public void subscribe(Consumer<LoaderPage> consumer) {
        this.publisher = consumer;
    }

    public void subscribeAcc(Consumer<Boolean> consumer){
        this.publisherAcc = consumer;
    }

    public void subscribeGroup(Consumer<Boolean> consumer) {
        this.publisherGroup = consumer;
    }

}
