package com.sh.timeslot.db.entity;

//import javax.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Contact  implements Serializable {

    private static final long serialVersionUID = 523743243265854686L;

    private Address address;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String phone;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String email;

}
