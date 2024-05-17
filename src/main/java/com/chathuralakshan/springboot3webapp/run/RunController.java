package com.chathuralakshan.springboot3webapp.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
            return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid  @RequestBody Run run){
        runRepository.createRun(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run,@PathVariable Integer id){
        runRepository.update(run,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
