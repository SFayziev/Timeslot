package com.sh.timeslot.model.mapper;

import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.model.response.BranchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchMapper extends BaseMapper<Branch, BranchRequest, BranchResponse> {

    BranchMapper INSTANCE = Mappers.getMapper( BranchMapper.class );

    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    Branch fromRequestToEntity(BranchRequest request) ;

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    @Mapping(source = "identifier", target = "id")
    BranchResponse fromEntityToResponse(Branch entity) ;
}
