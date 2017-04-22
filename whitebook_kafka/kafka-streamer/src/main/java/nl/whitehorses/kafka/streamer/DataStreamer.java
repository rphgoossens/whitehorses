/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.streamer;

import java.util.Properties;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

/**
 *
 * @author rphgoossens
 */
public class DataStreamer {

    private static final String BROKERHOST = "127.0.0.1";
    private static final String BROKERPORT = "9092";

    private final String inputTopic;
    private final String outputTopic;

    public DataStreamer(String inputTopic, String outputTopic) {
        this.inputTopic = inputTopic;
        this.outputTopic = outputTopic;
    }

    public void stream() {
        Properties streamerProps = new Properties();
        streamerProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-capitalize");
        streamerProps.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKERHOST + ":" + BROKERPORT);
        streamerProps.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamerProps.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        final Serde<String> stringSerde = Serdes.String();
        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> values = builder.stream(stringSerde, stringSerde, inputTopic);
        values.mapValues(String::toUpperCase).to(stringSerde, stringSerde, outputTopic);

        KafkaStreams streams = new KafkaStreams(builder, streamerProps);

        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}