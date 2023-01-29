package com.example.test.service;

import com.example.test.dto.UserDTO;
import com.example.test.entity.User;
import com.example.test.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
