package com.taxtoken.controller;

import com.taxtoken.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.taxtoken.service.UserService;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/birthday")
    public String getBirthday(@PathVariable String name) {
        return userService.getUser(name).getBirthday();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/age")
    public Integer getAge(@PathVariable String name) {
        return userService.getUser(name).getAge();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{name}")
    @ResponseBody
    public User updateUser(@PathVariable String name, @RequestParam(name = "birthday", required = true) String birthday, @RequestParam(name = "age", required = true) Integer age) {
        userService.updateUser(name, birthday, age);
        return new User(name, birthday, age);
    }



}