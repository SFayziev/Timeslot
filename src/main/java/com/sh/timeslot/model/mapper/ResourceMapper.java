package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Resource;
import com.sh.timeslot.model.request.ResourceRequest;
import com.sh.timeslot.model.response.ResourceResponse;
import org.mapstruct.factory.Mappers;

public interface ResourceMapper extends  BaseMapper<Resource, ResourceRequest, ResourceResponse> {
    ResourceMapper INSTANCE = Mappers.getMapper( ResourceMapper.class );
}
