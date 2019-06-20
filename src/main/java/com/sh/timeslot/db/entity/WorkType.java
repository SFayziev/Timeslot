package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "Company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkType extends Base {
    private String name;
    private String description;
    private boolean active;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
