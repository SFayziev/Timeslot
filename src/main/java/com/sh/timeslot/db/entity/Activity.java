package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sh.timeslot.common.enums.BaseStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
class Activity  extends Base  implements Serializable  {

    private static final long serialVersionUID = 52373423432854686L;

    private int duration ;

    private String name ;

    private BaseStatus status;

    private String branchId;

}
