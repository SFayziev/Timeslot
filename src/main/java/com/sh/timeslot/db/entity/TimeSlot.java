package com.sh.timeslot.db.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
class TimeSlot extends Base{
    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;

    @NotNull
    private int duration;


}
