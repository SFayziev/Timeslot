package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@EqualsAndHashCode(callSuper = false)
public class Address extends Base  implements Serializable {

    private static final long serialVersionUID = 52373243265854686L;


//    @Column(name = "address_one")
    @Size(max = 255, message = "{error.common.maxlength}")
    private String addressOne;

//    @Column(name = "address_two")
    @Size(max = 255, message = "{error.common.maxlength}")
    private String addressTwo;

//    @Column(name = "city")
    @Size(max = 2128, message = "{error.common.maxlength}")
    private String city;

//    @Column(name = "state")
    @Size(max = 64, message = "{error.common.maxlength}")
    private String state;

//    @Column(name = "zipcode")
    @Size(max = 9, message = "{error.common.maxlength}")
    private String zipcode;


}
