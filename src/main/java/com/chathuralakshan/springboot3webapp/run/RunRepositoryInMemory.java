package com.chathuralakshan.springboot3webapp.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//repository is a special type of component - spring has a instance of this class and is managed by spring
@Repository
public class RunRepositoryInMemory {
    private List<Run> runs=new ArrayList<>();


    //post construct method is something that we have to run after dependency injection is done ,
    // this method will run once all the dependencies of the bean have been injected
    @PostConstruct
    private void init(){
        runs.add(
                new Run(1,
                        "Monday Morning Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                        5.0,
                        Location.OUTDOOR,null)
        );

        runs.add(
                new Run(2,
                        "Monday Evening Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                        8.0,
                        Location.INDOOR,null)
        );
    }

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run->run.id()==id)
                .findFirst();
    }

    void createRun(Run run){
        runs.add(run);
    }

    void update(Run run,Integer id){
        Optional<Run> exsistingRun=findById(id);
        if(exsistingRun.isPresent()){
            runs.set(runs.indexOf(exsistingRun.get()),run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run->run.id().equals(id));
    }
}
