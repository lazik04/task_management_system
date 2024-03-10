package uz.pdp.task_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @GetMapping("/auth/login")
    public String login() {
        return "login";
    }

    @GetMapping("/auth/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/auth/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping("/auth/signup")
    public ModelAndView signup(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }


}
