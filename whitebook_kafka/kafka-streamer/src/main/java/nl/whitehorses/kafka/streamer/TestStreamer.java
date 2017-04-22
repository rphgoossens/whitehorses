/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.whitehorses.kafka.streamer;

/**
 *
 * @author rphgoossens
 */
public class TestStreamer {
 
    private static final String INPUT_TOPIC = "InputStreamerTopic";
    private static final String OUTPUT_TOPIC = "OutputStreamerTopic";
 
    public static void main(String[] args) {
        new DataStreamer(INPUT_TOPIC, OUTPUT_TOPIC).stream();
    }
    
}
