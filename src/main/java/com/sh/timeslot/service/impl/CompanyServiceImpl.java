package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.ServiceConfig;
import com.sh.timeslot.common.enums.BaseStatus;
import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.common.logging.TSLog;
import com.sh.timeslot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"company"})
public class CompanyServiceImpl extends BaseService<Company> implements CompanyService {

    private ServiceConfig config2;

    @Autowired
    public CompanyServiceImpl(ServiceConfig config, MongoTemplate template) {
        super(config, template);
        config2 = config;


    }


    @Override
    @TSLog()
    public Company createCompany(Company request) {
        request.setStatus(config2.getCompany().getDefaultStatus() );
        request.setIdentifier(getIncreasedSequenceId(Company.class.getName()));
        return super.insert(request);

    }

    @Override
    public List<Company> getCompanies(Company request) {

        return (List<Company>) find(request);
    }

    @Override
    public boolean changeCompanyStatus(String id, BaseStatus status) {


        return false;
    }
}
