package com.sh.timeslot.db.entity;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class OperationHourSlot {

    private LocalTime startTime ;
    private LocalTime endTime ;
    private DayOfWeek dayOfWeek;

}
