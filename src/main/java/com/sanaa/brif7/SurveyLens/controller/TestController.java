package com.sanaa.brif7.SurveyLens.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    public TestController() {
        System.out.println("TestController is loaded!");
    }

    @GetMapping
    public String healthCheck() {
        return "done";
    }
}
