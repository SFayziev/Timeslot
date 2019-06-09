package com.sh.timeslot.controller;

import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;
import com.sh.timeslot.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "company")
//@Api(value = "Trip management controller")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     *
     *
     * @param
     * @return
     */
//    @ApiOperation(value = "Create new trip")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest request) {
        companyService.createCompany(request);
        return null;
    }


}
