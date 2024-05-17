package com.chathuralakshan.springboot3webapp.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

//record classes comes with constructors, getters, setters, eqaul, hash
// and toString methods automatically
public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Double distance,
        Location location
) {
    //validations
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}

