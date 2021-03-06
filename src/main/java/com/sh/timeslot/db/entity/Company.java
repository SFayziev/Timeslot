package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sh.timeslot.common.enums.BaseStatus;
import com.sh.timeslot.model.MongoQueryField;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "Company")
@NoArgsConstructor
@AllArgsConstructor
//@Builder(builderMethodName = "createWithBuilder")
public class Company extends Base  implements Serializable  {

    private static final long serialVersionUID = 5237462423265854686L;

    private Address address;

    @Getter(onMethod_ = { @MongoQueryField})
    private String name ;

    @Getter(onMethod_={ @MongoQueryField})
    private String email ;

    @NotNull
//    @Builder.Default
    private BaseStatus status = BaseStatus.INACTIVE;


}

