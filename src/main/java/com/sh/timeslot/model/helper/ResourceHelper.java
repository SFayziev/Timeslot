package com.sh.timeslot.model.helper;

import com.sh.timeslot.db.entity.Resource;
import com.sh.timeslot.model.mapper.ResourceMapper;
import com.sh.timeslot.model.request.ResourceRequest;
import com.sh.timeslot.model.response.ResourceResponse;

public class ResourceHelper implements ResourceMapper {

    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    public Resource fromRequestToEntity(ResourceRequest request) {
        return INSTANCE.fromRequestToEntity(request);
    }

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    public ResourceResponse fromEntityToResponse(Resource entity) {
        return INSTANCE.fromEntityToResponse(entity);
    }
}
