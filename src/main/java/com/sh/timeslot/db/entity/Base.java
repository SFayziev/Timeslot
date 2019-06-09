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
@EqualsAndHashCode(callSuper = false)
abstract class  Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @CreatedBy
    @Field("created_by")
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Field("created_date")
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Field("last_modified_by")
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Field("last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();

}
