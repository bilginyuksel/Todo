package com.bilginyuksel.todo.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome to todo app</h1><p>Created by Kaan Yüksel Bilgin xdd</p>";
    }
}
