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

//import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Address extends Base  implements Serializable {

    private static final long serialVersionUID = 52373243265854686L;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String addressOne;

    @Size(max = 255, message = "{error.common.maxlength}")
    private String addressTwo;

    @Size(max = 128, message = "{error.common.maxlength}")
    private String city;


    @Size(max = 64, message = "{error.common.maxlength}")
    private String state;

    @Size(max = 9, message = "{error.common.maxlength}")
    private String zipCode;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonDeserialize(using = GeoJsonPointDeserializer.class)
    @NotNull
    private GeoJsonPoint point;

}
