package com.sh.timeslot.db.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
class TimeSlot {
    @NotNull
    private LocalDateTime startDateTime;

    @NotNull
    private int duration;


}
