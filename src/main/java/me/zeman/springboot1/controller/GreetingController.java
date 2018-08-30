package me.zeman.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Random;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        Random r = new Random();
        int c = r.nextInt(40);
        model.addAttribute("sleep", c * 1000);

        try {
            Thread.sleep( c * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "greeting";
    }

}