package com.example.RaysCourses.Registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "app/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String showRegistrationForm(){

        return "registration";
    }

    @PostMapping
    public String registration(@RequestBody RegistrationRequest request)
    {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){

        return registrationService.confirmToken(token);
    }

}
