package com.chathuralakshan.springboot3webapp.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/runner/runs")
public class RunController {

    private final RunRepository runRepository;

    //we should not use 'new' keyword to get a new instance of repository since spring already has an instance of the repository which is managed by it
    //to avoid unnecessary instances, we avoid usage of 'new' keyword.
    //springboot will autowire the class since we used @Repository in repository class.
    //so we 'RunRepository runRepository' to contructor and spring will implicitly use the available instance
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }



}
