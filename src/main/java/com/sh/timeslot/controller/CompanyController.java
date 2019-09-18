package com.sh.timeslot.controller;

import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController(value = "company")
public interface CompanyController {

    /**
     * Create new company
     *
     * @param request
     * @return
     */
//    @ApiOperation(value = "Create new trip")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest request);


    /**
     * Get company ny request
     *
     * @param request
     * @return
     */
//    @ApiOperation(value = "Create new trip")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CompanyResponse>> getCompany(@RequestBody CompanyRequest request);
}
