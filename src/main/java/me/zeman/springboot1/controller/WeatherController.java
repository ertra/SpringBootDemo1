package me.zeman.springboot1.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import me.zeman.springboot1.service.HelloService;
import me.zeman.springboot1.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/weather/{country}/{city}")
    @ResponseBody
    public String helloWorld(@PathVariable String country, @PathVariable String city ,HttpServletRequest request, HttpServletResponse response) {

        int r = new Random().nextInt(10);
        if (r == 1){

            try {
                Thread.sleep(10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        String w = weatherService.getWeather(country,city);

        return w;
    }
}
