package com.rest.webservices.controller;

import com.rest.webservices.entities.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    private String HelloWorld()
    {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    private HelloWorldBean HelloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    private HelloWorldBean HelloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
