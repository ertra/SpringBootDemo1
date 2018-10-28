package me.zeman.springboot1.controller;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Random;

@Controller
public class GetController {

    @GetMapping("/get")
    public String greeting(@RequestParam(name="url", required=false, defaultValue="http://www.root.cz") String url) {

        String html = "web page here";

        try {
            html = Jsoup.connect(url).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("web page download: " + html.length());

        return "getOutput";
    }

}