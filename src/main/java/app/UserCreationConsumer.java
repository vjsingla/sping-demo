package app;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreationConsumer {
    @KafkaListener(topics = "baeldung")
    public void listenGroupFoo(ConsumerRecord<String, String> message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
