package com.sh.timeslot.model.mapper;

public interface BaseMapper<T,R,Q> {


    /**
     *
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    T fromRequestToEntity(R request );

    /**
     *
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    Q fromEntityToResponse(T entity);

}
