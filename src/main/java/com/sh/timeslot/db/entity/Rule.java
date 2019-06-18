package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "Company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rule extends Base {
    private boolean defaultRule;
    private String  name ;

}
