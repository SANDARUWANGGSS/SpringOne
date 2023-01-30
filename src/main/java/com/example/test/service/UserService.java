package com.example.test.service;

import com.example.test.dto.UserDTO;
import com.example.test.entity.User;
import com.example.test.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService
{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public UserDTO SaveUser(UserDTO userDTO)
    {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers()
    {
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO)
    {
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO)
    {
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    //User Id > user details
    //select * from user where userid=2
    public UserDTO getUserByUserID(String userID)
    {
        User user= userRepo.getUserByID(userID);
        return modelMapper.map(user,UserDTO.class);
    }

    //user Id, address >User details
    //select * from user where userid=1 AND address="colombo"
    public UserDTO getUserByUserIDAndAddress(String userID,String address)
    {
        User user = userRepo.getUserByIDAndAddress(userID,address);
        return modelMapper.map(user,UserDTO.class);
    }
}
