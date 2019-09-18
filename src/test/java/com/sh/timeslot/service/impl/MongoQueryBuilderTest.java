package com.sh.timeslot.service.impl;

import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.service.FakerData;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Query;

public class MongoQueryBuilderTest {

    @Test
    public void build() {

        MongoQueryBuilder<CompanyRequest> requestMongoService = new MongoQueryBuilder<>(FakerData.generateCompanyRequest());
        Query query = requestMongoService.build();

        System.out.println(query);
    }
}