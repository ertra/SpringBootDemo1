package me.zeman.springboot1.controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.JsonNode;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import me.zeman.springboot1.model.Person;
import me.zeman.springboot1.service.HelloService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public ArrayList<Person> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, HttpServletRequest request,  HttpServletResponse response) {

        int r = new Random().nextInt(10);

        Gson j = new Gson();
        Person p = new Person();

        p.setName(name);
        p.setNumber("123");

        Person p2 = new Person();

        p2.setName("Jan");
        p2.setNumber("123456789");

        ArrayList<Person> people = new ArrayList();

        people.add(p);
        people.add(p2);

        if (r == 1){
            try {

                throw new Exception("My own exception");

            } catch (Exception e) {
                System.out.println("Exception: " + e.toString());
            } finally {
                try {
                    response.setContentType("text/html");
                    response.sendError(500, "(My own message) Our internal error");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else {

            response.setContentType("application/json");
        }

        return people;
    }

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return helloService.sayHelloWorld();
    }

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}
