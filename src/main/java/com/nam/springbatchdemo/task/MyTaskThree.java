package com.nam.springbatchdemo.task;

import com.nam.springbatchdemo.dto.UserDTO;
import com.nam.springbatchdemo.service.UserService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyTaskThree implements Tasklet{
    @Autowired
    UserService userService;
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//        List<UserDTO> userDTOS=userService.getAllUser();
//        userDTOS.forEach(userDTO -> {
//            System.out.println(userDTO.getFullName());
//        });
        userService.sendMail();
        return RepeatStatus.FINISHED;
    }
}
