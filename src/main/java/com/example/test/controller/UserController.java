package com.example.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController
{
    @GetMapping("/user")
    public String getUser()
    {
        return "Sandaruwan Gamage";
    }
    @PostMapping("/saveUser")
    public String saveUser()
    {
        return "Saved User";
    }
    @PutMapping ("/updateUser")
    public String updateUser()
    {
        return "Updated User";
    }
    @DeleteMapping ("/deleteUser")
    public String deleteUser()
    {
        return "Deleted User";
    }
}
