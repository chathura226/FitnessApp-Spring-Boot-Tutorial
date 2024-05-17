package com.chathuralakshan.springboot3webapp.run;

import java.time.LocalDateTime;

//record classes comes with constructors, getters, setters, eqaul, hash and toString methods automatically
public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Double distance,
        Location location
) {}

