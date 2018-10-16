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

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTaskThree implements Tasklet{
    @Autowired
    UserService userService;
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<String> list=new ArrayList<>();
        list.add("antuyen211pt@gmail.com");
        list.add(" truongtuan829@gmail.com");
        list.add("phamthidung11091994@gmail.com");
        list.add("chinh2525@gmail.com");
        list.add("anhmihanh97@gmail.com");
        list.add("Tmlinh100587@gmail.com");
        for (String str:list) {
            userService.sendMail(str);
        }

        return RepeatStatus.FINISHED;
    }
}
