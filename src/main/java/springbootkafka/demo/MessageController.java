package springbootkafka.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostMapping
    public void publish(@RequestBody MessageRequest request){
        kafkaTemplate.send("quickstart-events", request.message());
    }
}
