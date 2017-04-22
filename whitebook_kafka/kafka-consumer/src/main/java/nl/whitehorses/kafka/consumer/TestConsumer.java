/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.consumer;

/**
 *
 * @author rphgoossens
 */
public class TestConsumer {
    
    //private static final String TOPIC = "PubSubTopic";
    private static final String TOPIC = "OutputStreamerTopic";

    public static void main(String[] args) {
        new DataConsumer(TOPIC, "Group1").consume();
    }
}
