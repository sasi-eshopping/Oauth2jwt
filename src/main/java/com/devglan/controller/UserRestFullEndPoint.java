package com.devglan.controller;



import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
class UserRestFullEndPoint {

    @GetMapping("/userInfo")
    public Principal userInfo(Principal principal){
        return principal;
    }
}