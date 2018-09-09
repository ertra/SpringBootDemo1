package me.zeman.springboot1.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import me.zeman.springboot1.SpringBootDemo1Application;
import org.springframework.stereotype.Component;
import us.monoid.web.Resty;

import java.io.IOException;

@Component
public class WeatherService {

    public String getWeather(String c1, String c2) {
        String city = c2; // Prague
        String country = c1; // CZ

        String hello = "";

        Resty r = new Resty();

        try {
             hello = r.text(SpringBootDemo1Application.W_URL + c1 +"/" + c2).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hello;
    }

}
