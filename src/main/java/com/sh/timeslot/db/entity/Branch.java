package com.sh.timeslot.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.timeslot.common.jersey.GeoJsonPointDeserializer;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Builder
public class  Branch extends BaseLog  implements Serializable {

    private static final long serialVersionUID = 5237467532432434686L;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String name ;

    private Contact contact;

    @Size(max = 32, message = "{error.common.maxlength}")
    private String timezone ;

}
