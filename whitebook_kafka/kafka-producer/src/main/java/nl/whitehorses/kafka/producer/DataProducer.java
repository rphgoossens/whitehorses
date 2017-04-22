/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.producer;

import java.util.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 *
 * @author rphgoossens
 */
public class DataProducer {

    private static final String BROKERHOST = "127.0.0.1";
    private static final String BROKERPORT = "9092";

    private final String topic; 

    public DataProducer(String topic) {
        this.topic = topic;
    }
    
    public void produce(long events) {
        Properties producerProps = new Properties();
        producerProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKERHOST + ":" + BROKERPORT);
        producerProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        try (Producer<String, String> producer = new KafkaProducer<>(producerProps)) {
            for (long nEvents = 0; nEvents < events; nEvents++) {
                String key = "Producer";
                String value = "Hello world " + nEvents;

                ProducerRecord<String, String> data = new ProducerRecord<>(topic, key, value);
                producer.send(data);
            }
        }
    }
}
