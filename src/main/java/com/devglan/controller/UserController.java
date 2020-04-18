package com.devglan.controller;

import com.devglan.model.User;
import com.devglan.model.Token;
import com.devglan.service.TokenService;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenStore tokenstore;
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable long id){
        return userService.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable long id, @RequestBody User user){
        user.setId(id);
        user.setUpdate(true);
        User user1=userService.findOne(id);
        user.setPassword(user1.getPassword());
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
    }
    

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public Token logout(@RequestBody Token token){
		
    	Token tk= tokenService.save(token);
    	if(tk!=null)
    	{
    		return tk;
    	}
        return null;
    }
 
}
