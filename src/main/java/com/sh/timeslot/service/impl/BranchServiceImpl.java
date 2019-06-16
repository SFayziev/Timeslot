package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.ServiceConfig;
import com.sh.timeslot.service.BranchService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"branch"})
public class BranchServiceImpl extends BaseService implements BranchService {


    public BranchServiceImpl(ServiceConfig serverConfig, MongoTemplate template) {
        super(serverConfig, template);
    }


}
