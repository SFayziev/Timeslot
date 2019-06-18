package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sh.timeslot.common.enums.BaseStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

//import javax.persistence.Column;

@Data
@EqualsAndHashCode
public abstract class  Base implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String id;

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
