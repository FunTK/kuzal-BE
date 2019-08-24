package com.kuzal.kuzalcompetition.controller;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;
import com.kuzal.kuzalcompetition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", consumes = "application/json")
     User login(@RequestBody UserLoginRequest request){

        System.out.println("userINfo  : "+request);

        return userService.findUserByEmailAddress(request);
    }

}
