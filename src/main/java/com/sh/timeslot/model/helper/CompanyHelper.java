package com.sh.timeslot.model.helper;

import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.mapper.CompanyMapper;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;

public class CompanyHelper extends BaseHelper {


    public CompanyHelper(){
        INSTANCE = CompanyMapper.INSTANCE ;
    }

    public Company requestToEntity(CompanyRequest request) {
        Company company = (Company) INSTANCE.fromRequestToEntity(request);
        return company;
    }

    public CompanyResponse entityToResponse(Company entity) {
        CompanyResponse companyResponse = (CompanyResponse) INSTANCE.fromEntityToResponse(entity);
        return companyResponse;
    }
}
