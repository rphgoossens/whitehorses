/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 *
 * @author rphgoossens
 */
public class DataConsumer {

    private static final String BROKERHOST = "127.0.0.1";
    private static final String BROKERPORT = "9092";

    private final String topic;
    private final String group;

    public DataConsumer(String topic, String group) {
        this.topic = topic;
        this.group = group;
    }

    public void consume() {
        Properties consumerProps = new Properties();
        consumerProps.setProperty(ConsumerConfig.GROUP_ID_CONFIG, group);
        consumerProps.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKERHOST + ":" + BROKERPORT);
        consumerProps.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        try (Consumer<String, String> consumer = new KafkaConsumer<>(consumerProps)) {
            consumer.subscribe(Arrays.asList(new String[]{topic}));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(group + " " + record.offset() + ": " + record.key() + ":" + record.value());
                }
            }

        }
    }
}
