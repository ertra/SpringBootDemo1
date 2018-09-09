package me.zeman.springboot1.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String sayHelloWorld() {
        return "<html>" +
                "<body>" +
                "<b>Hello</b><br/>" +
                "<a href='/json1'>json1</a><br/>" +
                "<a href='/greeting'>greeting</a><br/>" +
                "<a href='/weather'>weather</a><br/><br/><br/>" +
                "$ curl http://localhost:8080/people<br/>" +
                "$ curl -i -X POST -H \"Content-Type:application/json\" -d \"{  \\\"firstName\\\" : \\\"Frodo\\\",  \\\"lastName\\\" : \\\"Baggins\\\" }\" http://localhost:8080/people<br/>\n" +
                "$ curl http://localhost:8080/people/1<br/>" +
                "</body>" +

                "</html>" +
                "";
    }

}

