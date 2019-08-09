package com.sh.timeslot.db.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
@Data
@Builder
public class SequenceId {

    @Id
    private String id;

    private long seq;

}
