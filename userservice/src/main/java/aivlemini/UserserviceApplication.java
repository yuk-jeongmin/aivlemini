package aivlemini;

import aivlemini.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
@EnableScheduling
public class UserserviceApplication {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
            SpringApplication.run(UserserviceApplication.class, args);
    }
}
