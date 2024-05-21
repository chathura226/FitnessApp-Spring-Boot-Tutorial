package com.chathuralakshan.springboot3webapp;

import com.chathuralakshan.springboot3webapp.run.Run;
import com.chathuralakshan.springboot3webapp.run.RunRepository;
import com.chathuralakshan.springboot3webapp.user.User;
import com.chathuralakshan.springboot3webapp.user.UserHttpClient;
import com.chathuralakshan.springboot3webapp.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBoot3WebAppApplication {

    //get a logger instance for logging
    private static final Logger log= LoggerFactory.getLogger(SpringBoot3WebAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3WebAppApplication.class, args);
        //log that application started successfully
        log.info("Application started successfully");
    }

    @Bean
    UserHttpClient userHttpClient(){
        RestClient restClient=RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory factory=HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(UserHttpClient.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserHttpClient client) {
        return args -> {
            List<User> users =client.findAll();
            System.out.println(users);

            User user =client.findById(1);
            System.out.println(user);
        };
    }


}
