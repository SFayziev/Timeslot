package com.sh.timeslot.db.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.TimeZone;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperationHour  extends Base{
    private TimeZone timeZone;
    private String name ;
    private Set<OperationHourSlot> operationHourSlots;

}
