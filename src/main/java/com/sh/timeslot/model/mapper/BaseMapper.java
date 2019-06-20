package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Base;
import org.mapstruct.Mapping;

public interface BaseMapper<T extends Base,R,Q> {


    /**
     *
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */


    @Mapping(source = "id", target = "identifier")
    @Mapping(target = "id", ignore = true)
    T fromRequestToEntity(R request );

    /**
     *
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */

    @Mapping(source = "identifier", target = "id")
    Q fromEntityToResponse(T entity);

}
