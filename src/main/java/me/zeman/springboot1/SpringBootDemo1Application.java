package me.zeman.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemo1Application {

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

