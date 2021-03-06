package com.sh.timeslot.model.helper;

import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.mapper.CompanyMapper;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;

public class CompanyHelper implements CompanyMapper  {


    /**
     * Convert object from Request to Entity
     *
     * @param request request object
     * @return Request object
     */
    @Override
    public Company fromRequestToEntity(CompanyRequest request) {
        return INSTANCE.fromRequestToEntity(request);
    }

    /**
     * Convert object from entity to Response
     *
     * @param entity entity object
     * @return Response object
     */
    @Override
    public CompanyResponse fromEntityToResponse(Company entity) {
        return INSTANCE.fromEntityToResponse(entity);
    }
}
