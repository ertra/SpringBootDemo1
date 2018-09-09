package me.zeman.springboot1;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.jms.Queue;

@SpringBootApplication
public class SpringBootDemo1Application {

    public static String W_URL = "http://s2.cotopia.com:8888/weather/";
    //public static String W_URL = "http://localhost:8888";

    // TODO - finish this example
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    public static void main(String[] args) {

        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(SpringBootDemo1Application.class, args);

    }
}

/*

./mvnw spring-boot:run
./mvnw clean package
java -jar target/gs-rest-service-0.1.0.jar

*/

