package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
public  abstract class BaseLog extends Base {
    @CreatedBy
    @Field("createdBy")
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Field("createdDate")
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Field("lastModifiedBy")
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Field("lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();
}
