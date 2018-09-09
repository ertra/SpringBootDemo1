package me.zeman.springboot1.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import us.monoid.web.Resty;

import java.io.IOException;

@Component
public class WeatherService {

    public String getWeather(String c1, String c2) {
        String city = c2; // Prague
        String country = c1; // CZ

        String hello = "";

        Random rnd = new Random();
        int number = rnd.nextInt(20);

        Resty rest = new Resty();
        try {

            if (number==1){

                throw new Exception("Tomas Crazy Exception");

            }
             hello = rest.text("http://s2.cotopia.com:8888/weather/" +c1 +"/" + c2).toString();

        } catch (Exception e) {
             hello = r.text(SpringBootDemo1Application.W_URL + c1 +"/" + c2).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hello;
    }

}
