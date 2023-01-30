package com.example.test.controller;

import com.example.test.dto.UserDTO;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public List<UserDTO> getUser()
    {
        return userService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO)
    {
        return userService.SaveUser(userDTO);
    }
    @PutMapping ("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO)
    {
        return userService.updateUser(userDTO);
    }
    @DeleteMapping ("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO)
    {
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserId/{userID}")
    public UserDTO getUserByUserId(@PathVariable String userID){ return userService.getUserByUserID(userID);}

    @GetMapping("/getUserByUserIdAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIdAndAddress(@PathVariable String userID,@PathVariable String address)
    {
        System.out.println("User Id"+userID+"Address"+address);
        return userService.getUserByUserIDAndAddress(userID,address);
    }
}
