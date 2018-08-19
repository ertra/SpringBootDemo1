package me.zeman.springboot1.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import me.zeman.springboot1.service.HelloService;
import me.zeman.springboot1.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/weather")
    @ResponseBody
    public String helloWorld(HttpServletRequest request, HttpServletResponse response) {

        String w = weatherService.getWeather();

        return w;
    }
}
