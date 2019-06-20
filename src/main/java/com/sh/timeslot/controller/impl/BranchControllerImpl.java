package com.sh.timeslot.controller.impl;

import com.sh.timeslot.controller.BranchController;
import com.sh.timeslot.model.helper.BranchHelper;
import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.model.response.BranchResponse;
import com.sh.timeslot.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;


public class BranchControllerImpl implements BranchController {

    private BranchService branchService;
    private BranchHelper helper = new BranchHelper();


    @Autowired
    public BranchControllerImpl(BranchService branchService) {
        this.branchService = branchService;
    }

    /**
     * Create new Branch
     *
     * @param request see {@link BranchResponse}
     * @return
     */
    @Override
    public ResponseEntity<BranchResponse> createBranch(BranchRequest request) {
        return ResponseEntity.ok(
                helper.fromEntityToResponse(
                        branchService.createBranch(
                                helper.fromRequestToEntity(request)
                        )
                )
        );
    }

    /**
     * get new Branch
     *
     * @param request see {@link BranchResponse}
     * @return
     */
    @Override
    public ResponseEntity<List<BranchResponse>> getBranch(BranchRequest request) {
        return ResponseEntity.ok(
                branchService.getBranches(
                        helper.fromRequestToEntity(request)
                )
                        .stream()
                        .map(t -> helper.fromEntityToResponse(t))
                        .collect(Collectors.toList())
        );
    }
}
