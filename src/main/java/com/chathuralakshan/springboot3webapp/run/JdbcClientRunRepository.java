package com.chathuralakshan.springboot3webapp.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

//repository is a special type of component - spring has a instance of this class and is managed by spring
@Repository
public class JdbcClientRunRepository {
    private static final Logger log=  LoggerFactory.getLogger(JdbcClientRunRepository.class);

    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll(){
        return jdbcClient.sql("SELECT * FROM run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM run where id=:id limit 1")
                .param("id",id)
                .query(Run.class)
                .optional();
    }

    public void createRun(Run run){
        var updated=jdbcClient.sql("INSERT INTO Run(id,title,started_on,completed_on,distance,location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(),run.title(),run.startedOn(),run.completedOn(),run.distance(),run.location().toString()))
                .update();

        Assert.state(updated==1,"Failed to create run "+run.title());
    }

    public void updateRun(Run run,Integer id){
        var updated=jdbcClient.sql("UPDATE Run SET title=?,started_on=?,completed_on=?,distance=?,location=? where id=?")
                .params(List.of(run.title(),run.startedOn(),run.completedOn(),run.distance(),run.location().toString(),id))
                .update();

        Assert.state(updated==1,"Failed to update run "+id);
    }


    public void delete(Integer id){
        var updated=jdbcClient.sql("DELETE FROM Run where id=:id")
                .param("id",id)
                .update();

        Assert.state(updated==1,"Failed to delete run "+id);
    }

    public int count(){return jdbcClient.sql("SELECT * FROM Run;").query().listOfRows().size();}

    public void saveAll(List<Run> runs){
        runs.stream().forEach(this::createRun);
    }

    public List<Run> findByLocation(String location){
        return jdbcClient.sql("SELECT * FROM Run WHERE location=:location")
                .param("location",location)
                .query(Run.class)
                .list();
    }
}
