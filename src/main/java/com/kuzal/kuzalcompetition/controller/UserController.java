package com.kuzal.kuzalcompetition.controller;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;
import com.kuzal.kuzalcompetition.request.UserUpdateRequest;
import com.kuzal.kuzalcompetition.service.UserService;
import com.mongodb.client.result.UpdateResult;
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

    @PutMapping("/{emailAddress}")
    UpdateResult updateUser(@PathVariable String emailAddress, @RequestBody UserUpdateRequest request){
        return userService.updateUserByEmailAddress(emailAddress,request.getNickName());
    }

    @GetMapping("/{emailAddress}")
    User getUser(@PathVariable String emailAddress){
        return userService.getUserByEmailAddress(emailAddress);
    }

}
