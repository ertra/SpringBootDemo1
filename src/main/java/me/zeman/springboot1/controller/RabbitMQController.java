package me.zeman.springboot1.controller;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import me.zeman.springboot1.SpringBootDemo1Application;
import me.zeman.springboot1.model.Person;
import me.zeman.springboot1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import static me.zeman.springboot1.SpringBootDemo1Application.QUEUE_NAME;

@Controller
public class RabbitMQController {


    @GetMapping("/send")
    @ResponseBody
    public String send() {

        Connection connection = null;
        Channel channel;

        String message1 = "";

        try {

            channel = SpringBootDemo1Application.connection.createChannel();

            Random r = new Random();
            int c = r.nextInt(10000);
            channel.queueDeclare(SpringBootDemo1Application.QUEUE_NAME, false, false, false, null);
            message1 = "Hello World: " + c;
            channel.basicPublish("", SpringBootDemo1Application.QUEUE_NAME, null, message1.getBytes());
            //System.out.println(" [x] Sent '" + message +  "'");
            channel.close();
           // connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return "Send : " + message1.toString();
    }

    static final String[] message = {""};


    @GetMapping("/receive")
    @ResponseBody
    public String receive() {

        Channel channel = null;
        try {
            channel = SpringBootDemo1Application.connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            channel.queueDeclare(SpringBootDemo1Application.QUEUE_NAME, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(" [*] Waiting for messages");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                 message[0] = new String(body, "UTF-8");
            }
        };

        try {
            channel.basicConsume(SpringBootDemo1Application.QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Receive : " +  message[0];
    }

}
