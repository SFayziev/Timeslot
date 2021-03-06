package com.sh.timeslot.controller.impl;

import com.sh.timeslot.controller.CompanyController;
import com.sh.timeslot.model.helper.CompanyHelper;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.model.response.CompanyResponse;
import com.sh.timeslot.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyControllerImpl implements CompanyController {
    private final CompanyService companyService;
    private final CompanyHelper helper = new CompanyHelper();

    public CompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }


    public ResponseEntity<CompanyResponse> createCompany(CompanyRequest request) {
        return  ResponseEntity.ok(
                        helper.fromEntityToResponse(
                                companyService.createCompany(
                                        helper.fromRequestToEntity(request)
                                )
                        )
                ) ;
    }

    /**
     * Get company list by Example
     *
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<List<CompanyResponse>> getCompany(CompanyRequest request) {
        return ResponseEntity.ok(
                companyService.getCompanies(
                        helper.fromRequestToEntity(request))
                        .stream()
                        .map(helper::fromEntityToResponse)
                        .collect(Collectors.toList())
            );

    }
}
