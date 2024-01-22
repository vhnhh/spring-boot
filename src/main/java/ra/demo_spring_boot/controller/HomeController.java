package ra.demo_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }
}
