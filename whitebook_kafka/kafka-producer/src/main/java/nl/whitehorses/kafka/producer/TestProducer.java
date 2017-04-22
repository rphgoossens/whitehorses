/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.producer;

/**
 *
 * @author rphgoossens
 */
public class TestProducer {

    //private static final String TOPIC = "PubSubTopic";
    private static final String TOPIC = "InputStreamerTopic";

    public static void main(String[] args) {
        new DataProducer(TOPIC).produce(5);
    }
}
