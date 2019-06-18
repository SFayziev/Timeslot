package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sh.timeslot.common.enums.BaseStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Document
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@EqualsAndHashCode(callSuper = false)
public class Resource extends Base  implements Serializable {

    private static final long serialVersionUID = 5237463434365854686L;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String lastName ;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String firstName;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String jobTitle;

    private Contact contact;

    @Builder.Default
    private BaseStatus status= BaseStatus.ACTIVE;

}
