package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.enums.BaseStatus;
import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.common.logging.TSLog;
import com.sh.timeslot.model.helper.CompanyHelper;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.service.CompanyService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"company"})
public class CompanyServiceImpl implements CompanyService {

   //private CompanyRepository companyRepository;
    private CompanyHelper helper = new CompanyHelper();
    private final MongoTemplate template;



    public CompanyServiceImpl( MongoTemplate template) {
      //  this.companyRepository = companyRepository;
        this.template = template;
    }



    @Override
    @TSLog()
    public Company createCompany(CompanyRequest request) {
        return template
                .save(helper.requestToEntity(request));

    }

    @Override
    public List<Company> getCompanies(CompanyRequest request) {
        MongoQueryBuilder<CompanyRequest> requestMongoService = new MongoQueryBuilder<>(request);
        Query query = requestMongoService.build();
       // return new PagingResponseModel<>(PageableExecutionUtils.getPage(mongoTemplate.find(query, Trip.class), searchParams.getPageable(), () -> mongoTemplate.count(query, Trip.class)));

        return template.find(query, Company.class);
    }

    @Override
    public boolean changeCompanyStatus(String id, BaseStatus status) {


        return false;
    }
}
