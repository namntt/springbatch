package com.nam.springbatchdemo.config;

import com.nam.springbatchdemo.task.MyTaskOne;
import com.nam.springbatchdemo.task.MyTaskThree;
import com.nam.springbatchdemo.task.MyTaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    MyTaskThree myTaskThree;

    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
                .tasklet(new MyTaskOne())
                .listener(new StepItemProcessListener())
                .build();
    }

    @Bean
    public Step stepTwo(){
        return steps.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .listener(new StepItemProcessListener())
                .build();
    }

    @Bean
    public Step stepThree(){
        return steps.get("stepThree")
                .tasklet(myTaskThree)
                .listener(new StepItemProcessListener())
                .build();
    }

    @Bean(name = "demoJobOne")
    public Job demoJobOne(){
        return jobs.get("demoJobOne")
                .start(stepOne())
                .next(stepTwo())
                .next(stepThree())
                .build();
    }

    @Bean(name = "demoJobTwo")
    public Job demoJobTwo(){
        return jobs.get("demoJobTwo").flow(stepOne())
                .build()
                .build();
    }



//    @Bean
//    public Job job(@Qualifier("demoJobOne") Step step1, @Qualifier("demoJobTwo") Step step2) {
//        return jobs.get("myJob").start(step1).next(step2).build();
//    }
}
