package me.zeman.springboot1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.jms.Queue;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import org.apache.catalina.connector.Connector;


@SpringBootApplication
public class SpringBootDemo1Application {

    //public static String W_URL = "http://s2.cotopia.com:8888/weatherService/";
    public static String W_URL = "http://localhost:8888/weatherService/";

    public static String QUEUE_NAME = "RabbitMQ";

    public static ConnectionFactory factory = new ConnectionFactory();
    public static Connection connection = null;

    // TODO - finish this example
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    public static void main(String[] args) {

        try {
            factory.setUri("amqp://wabpvmhu:RGadx15VBIsBIHGXUVyIlYAYvVWCnjZS@chimpanzee.rmq.cloudamqp.com/wabpvmhu");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


        connection = null;
        //Channel channel;

        try {
            connection = factory.newConnection();

           // channel = connection.createChannel();

         //   channel.queueDeclare(QUEUE_NAME, false, false, false, null);
          //  String message = "Hello World!";
        //    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
         //   System.out.println(" [x] Sent '" + message + "'");
       //     channel.close();
           // connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

       // System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(SpringBootDemo1Application.class, args);

    }


}

/*

./mvnw spring-boot:run
./mvnw clean package
java -jar target/gs-rest-service-0.1.0.jar

*/

