package com.nam.springbatchdemo.service;

import com.nam.springbatchdemo.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    void sendMail();
}
