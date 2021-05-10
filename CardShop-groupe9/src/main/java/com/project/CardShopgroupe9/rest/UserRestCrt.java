package com.project.CardShopgroupe9.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.service.UserService;


@RestController
public class UserRestCrt {
    @Autowired
    UserService uService;
    
    @RequestMapping(method=RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUser(@PathVariable String id) {
        User u = uService.getUserById(Integer.valueOf(id));
        return u;
    }
    
    @RequestMapping(method=RequestMethod.DELETE,value="/user/{id}")
    public User deleteUser(@PathVariable String id) {
        User u = uService.DeleteUser(Integer.valueOf(id));
        
        return u;
    }
}
