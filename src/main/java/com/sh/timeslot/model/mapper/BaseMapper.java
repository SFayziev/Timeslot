package com.sh.timeslot.model.mapper;

public interface BaseMapper<T,R,Q> {


    T fromRequestToEntity(R request );

    Q fromEntityToResponse(T entity);

}
