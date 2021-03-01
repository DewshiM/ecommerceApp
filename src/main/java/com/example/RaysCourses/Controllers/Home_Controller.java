package com.example.RaysCourses.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home_Controller {

    @GetMapping(path = "/index")
    public String showHomePage(){

        return "index";
    }

    @GetMapping(path = "/login")
    public String showLoginPage(){
        return "login";
    }

}
