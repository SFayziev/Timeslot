package com.sh.timeslot.db.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.DayOfWeek;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperationHourSlot extends Base{

    private LocalTime startTime = LocalTime.MIN;
    private LocalTime endTime =LocalTime.MAX;
    private DayOfWeek dayOfWeek;

}
