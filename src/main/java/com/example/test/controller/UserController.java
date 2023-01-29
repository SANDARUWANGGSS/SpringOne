package com.example.test.controller;

import com.example.test.dto.UserDTO;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public String getUser()
    {
        return "Sandaruwan Gamage";
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO)
    {
        return userService.SaveUser(userDTO);
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
