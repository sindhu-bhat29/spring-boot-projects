package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	
	@GetMapping("/redirect")
    public String handleRedirect(@RequestParam("token") String token) {
        // Process the token here
        return "Token received: " + token;
    }

}
