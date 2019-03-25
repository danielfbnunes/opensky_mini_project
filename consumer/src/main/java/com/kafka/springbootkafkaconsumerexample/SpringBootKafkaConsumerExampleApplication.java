package com.kafka.springbootkafkaconsumerexample;

import javax.swing.JFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootKafkaConsumerExampleApplication extends JFrame {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SpringBootKafkaConsumerExampleApplication.class)
                .headless(false).run(args);

	}
}
