package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sh.timeslot.common.enums.BaseStatus;
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
@EqualsAndHashCode(callSuper = false)
class Customer extends Base  implements Serializable {

    private static final long serialVersionUID = 523746732432344686L;
    @Size(max = 255, message = "{error.common.maxlength}")
    private String lastName ;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String firstName;

    private Contact contact;

    private BaseStatus status;
}
