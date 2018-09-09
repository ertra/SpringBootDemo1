package me.zeman.springboot1.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import me.zeman.springboot1.SpringBootDemo1Application;
import org.springframework.stereotype.Component;
import us.monoid.web.Resty;

import java.io.IOException;
import java.util.Random;

@Component
public class WeatherService {

    public String getWeather(String c1, String c2) {
        String city = c2; // Prague
        String country = c1; // CZ

        String hello = "";

        Random rnd = new Random();
        int number = rnd.nextInt(10);

        Resty rest = new Resty();

        try {

            if (number==1){
                throw new Exception("Weather Crazy Exception");
            }

             hello = rest.text(SpringBootDemo1Application.W_URL + c1 +"/" + c2).toString();

        } catch (Exception e) {
            System.out.println("Weather exception: " + e.toString());
            e.printStackTrace();

        }

        return hello;
    }

}


