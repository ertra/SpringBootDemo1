package me.zeman.springboot1.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    public String getWeather() {
        String city = "Prague";
        String country = "CZ";

        String URL = "http://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "," +
                country +
                "&appid=765590d744a203e6c96eda4b88d4bfdb&units=metric";

        HttpResponse<JsonNode> jsonResponse = null;

        try {
            jsonResponse = Unirest.get(URL)
                    //.header("accept", "application/json")
                    //.queryString("apiKey", "123")
                    //.field("parameter", "value")
                    //.field("foo", "bar")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        JsonNode j = jsonResponse.getBody();
        //JSONObject obj = new JSONObject(jsonResponse.getBody().toString());

        return jsonResponse.getBody().toString();

    }

}
