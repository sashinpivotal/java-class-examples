package org.supamassirichotiyakul.catermate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // *** Because of what's specified in SecurityConfiguration,
    // this is the MAIN page when a user goes to http://localhost:8080
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    // Not needed because "/order" is already specified
    // as default URL in SecurityConfiguration.
//    @GetMapping("/")
//    public String doLogin(Model model) {
//        return "redirect:/order";
//    }

}
