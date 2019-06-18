package com.sh.timeslot.service;


import com.sh.timeslot.db.entity.Branch;

import java.util.List;

public interface BranchService {

    /**
     * Create branches
     * @param branch {@link Branch}
     * @return
     */
    Branch createBranch(Branch branch);

    /**
     *
     * Get branches by example
     *
     * @param branch example branch
     * @return list of {@link Branch}
     */
    List<Branch> getBranches(Branch branch);

}
