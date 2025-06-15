package com.prem.demo.controller;

import com.prem.demo.model.Users;
import com.prem.demo.serivce.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService rs;
    @PostMapping("/register")
    public Users register(@RequestBody Users us)
    {
        return rs.register(us);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users us)
    {
        return rs.verify(us);
    }
}
