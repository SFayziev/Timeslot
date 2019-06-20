package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Resource;
import com.sh.timeslot.model.request.ResourceRequest;
import com.sh.timeslot.model.response.ResourceResponse;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ResourceMapper extends  BaseMapper<Resource, ResourceRequest, ResourceResponse> {
    ResourceMapper INSTANCE = Mappers.getMapper( ResourceMapper.class );

    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    @Mapping(source = "id", target = "identifier")
    default Resource fromRequestToEntity(ResourceRequest request) {
        return null;
    }

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    @Mapping(source = "identifier", target = "id")
    default ResourceResponse fromEntityToResponse(Resource entity) {
        return null;
    }
}
