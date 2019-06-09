package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sh.timeslot.common.enums.BaseStatus;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "Company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Company extends Base  implements Serializable  {

    private static final long serialVersionUID = 5237467505965854686L;

    private Address address;

    private String name ;

    private String email ;

    @NotNull
    @Builder.Default
    private BaseStatus status = BaseStatus.INACTIVE;


}

