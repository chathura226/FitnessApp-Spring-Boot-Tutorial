package com.chathuralakshan.springboot3webapp;

import com.chathuralakshan.springboot3webapp.run.Location;
import com.chathuralakshan.springboot3webapp.run.Run;
import com.chathuralakshan.springboot3webapp.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class SpringBoot3WebAppApplication {

    //get a logger instance for logging
    private static final Logger log= LoggerFactory.getLogger(SpringBoot3WebAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3WebAppApplication.class, args);
        //log that application started successfully
        log.info("Application started successfully");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RunRepository runRepository) {
//        return args -> {
//            Run run=new Run(1,"First run", LocalDateTime.now().minus(1, ChronoUnit.HOURS),LocalDateTime.now(),4.0, Location.OUTDOOR);
//            log.info("Run: "+run);
//            runRepository.createRun(run);
//        };
//    }


}
