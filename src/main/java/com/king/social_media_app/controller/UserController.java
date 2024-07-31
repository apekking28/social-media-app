package com.king.social_media_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.king.social_media_app.models.User;
import com.king.social_media_app.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/api/users")
    public List<User> getUser() {
        List<User> users = userService.findAll();


        return users;
    }

    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {
        User user = userService.findUserById(id);

        return user;
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") Integer userId) throws Exception {
        
       User updatedUser = userService.updateUser(user, userId);

       return updatedUser;
    }

    @PutMapping("/api/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {

        User user = userService.followUser(userId1, userId2);

        return user;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        List<User> users= userService.searchUser(query);

        return users;
    }
}
