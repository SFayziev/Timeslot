package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.ServiceConfig;
import com.sh.timeslot.db.entity.Base;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class BaseService<T extends com.sh.timeslot.db.entity.Base > {
    ServiceConfig serverConfig;
    MongoTemplate template;


    public BaseService(ServiceConfig serverConfig , MongoTemplate template) {
        this.serverConfig = serverConfig;
        this.template= template;
    }


    protected T insert(T t){
        return template.insert(t);
    }


    protected List<? extends Base> find(T t){
        MongoQueryBuilder<T> requestMongoService = new MongoQueryBuilder<T>(t);
        Query query = requestMongoService.build();
        return template.find(query, t.getClass());
    }
}
