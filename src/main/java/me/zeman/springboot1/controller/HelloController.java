package me.zeman.springboot1.controller;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import me.zeman.springboot1.service.HelloService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, HttpServletResponse response) {

        int r = new Random().nextInt(10);

        System.out.println("name: " + name);

        if (r==1){
            try {
                throw new Exception("my own exception");

            } catch (Exception e) {
                System.out.print("exception: " + e.toString());
            } finally {
                try {
                    response.sendError(500, "9Mu own message) Our internal error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "greeting";
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
