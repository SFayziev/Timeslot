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


}
