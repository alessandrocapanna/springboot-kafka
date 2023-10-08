package springbootkafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "quickstart-events",
            groupId = "groupId"
    )
    void listener (String data){
        System.out.println("Listener recived:" + data+ " 🎉");
    }
}
