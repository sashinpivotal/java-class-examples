package com.optum.myfirstspringapp.newPackage;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(/*@ModelAttribute*/ Greeting greeting, Model model) {
        greeting.setContent(greeting.getContent().toUpperCase());
        greeting.setId(greeting.getId()+1000);
        model.addAttribute("greeting", greeting);
        return "result";
    }

}
