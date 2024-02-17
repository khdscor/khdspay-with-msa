package myKhdsPay.common;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LongingProducer {

    private final KafkaProducer<String, String> producer;

    private final String topic;

    public LongingProducer(@Value("${kafka.clusters.bootstrapservers}") String bootstrapservers,
        @Value("${logging.topic}") String topic) {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapservers);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void sendMessage(String key, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, message);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Success");
            } else {
                exception.printStackTrace();
                System.out.println("Fail");
            }
        });
    }
}
