package com.sh.timeslot.controller;

import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.model.response.BranchResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "branch")
public interface BranchController {


    /**
     * Create new Branch
     *
     * @param request see {@link BranchResponse}
     * @return
     */
    @ApiOperation(value = "Create new Branch")
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<BranchResponse> createBranch(@RequestBody BranchRequest request);


    /**
     * get new Branch
     *
     * @param request see {@link BranchResponse}
     * @return
     */
    @ApiOperation(value = "Get new Branch")
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<BranchResponse>> getBranch(@RequestBody BranchRequest request);



}
