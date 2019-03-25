/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kafka.springbootkafkaconsumerexample;

/**
 *
 * @author dn
 */

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

    @Service
    public class KafkaConsumer {
        
        @KafkaListener(topics = "rddnPortugalPlanes")
        public void consume(String message) {
            PopUp.infoBox(message.split("_")[0], message.split("_")[1]);
            System.out.println("Consumed message: " + message.split("_")[0] + " (" + message.split("_")[1] +")");
    }
        
}
