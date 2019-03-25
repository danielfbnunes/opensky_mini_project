package LabProject;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
@EnableAutoConfiguration
public class Main 
{
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) throws Exception
    {
        SpringApplication app = new SpringApplication(Main.class);
        
        Properties properties = new Properties();
        //app.setDefaultProperties(properties);
        
        app.run(args);
    }
}