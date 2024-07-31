package com.king.social_media_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String homeControllerHandler() {
        return "This home controller anjay";
    }

    @GetMapping("/home")
    public String homeControllerHandler2() {
        return "This home controller 2 anjay";
    }
}
