package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.ServiceConfig;
import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.service.BranchService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"branch"})
public class BranchServiceImpl extends BaseService<Branch> implements BranchService {


    public BranchServiceImpl(ServiceConfig serverConfig, MongoTemplate template) {
        super(serverConfig, template);
    }


    /**
     * Create branches
     *
     * @param branch {@link Branch}
     * @return
     */
    @Override
    public Branch createBranch(Branch branch) {
        return insert(branch);
    }

    /**
     * Get branches by example
     *
     * @param branch example branch
     * @return list of {@link Branch}
     */
    @Override
    public List<Branch> getBranches(Branch branch) {
        return (List<Branch>) find(branch);
    }
}
