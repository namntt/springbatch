package com.nam.springbatchdemo.service.impl;

import com.nam.springbatchdemo.constants.Constants;
import com.nam.springbatchdemo.dto.UserDTO;
import com.nam.springbatchdemo.entity.User;
import com.nam.springbatchdemo.repository.UserRepository;
import com.nam.springbatchdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Qualifier("getJavaMailSender")
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users= (List<User>) userRepository.findAll();
        List<UserDTO> userDTOS=new ArrayList<>();
        users.forEach(user ->{
            UserDTO userDTO=new UserDTO();
            userDTO.setIdUser(user.getIdUser());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            userDTO.setCreatedDate(user.getCreatedDate());
            userDTO.setUpdatedDate(user.getUpdatedDate());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    @Override
    public void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("You will die");
        message.setText("I KILL YOU!!!!");
        javaMailSender.send(message);
    }
}
