package com.kuzal.kuzalcompetition.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @RequestMapping(method = RequestMethod.GET)
    Integer healthCheck(){
        return 200;
    }
}
