package com.chathuralakshan.springboot3webapp.run;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run,Integer> {
    List<Run> findAllByLocation(String location);

    //use @Query to write custom queries
}
