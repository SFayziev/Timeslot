package com.sh.timeslot.model.helper;


import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.model.mapper.BranchMapper;
import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.model.response.BranchResponse;

public class BranchHelper  implements BranchMapper{


    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    public Branch fromRequestToEntity(BranchRequest request) {
        return INSTANCE.fromRequestToEntity(request);
    }

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    public BranchResponse fromEntityToResponse(Branch entity) {
        return INSTANCE.fromEntityToResponse(entity);
    }
}
