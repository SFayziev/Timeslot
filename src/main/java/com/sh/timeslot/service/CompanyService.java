package com.sh.timeslot.service;

import com.sh.timeslot.common.enums.BaseStatus;
import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.request.CompanyRequest;

import java.util.List;

public interface CompanyService {

    /**
     *
     * Create Company
     *
     *
     * @param request {@link Company}
     * @return {@link Company}
     */
    Company createCompany(Company request);

    /**
     * get Company request
     *
     * @param request {@link Company}
     * @return List of {@link Company}
     */
    List<Company> getCompanies(Company request);

    /**
     *
     * change Company status
     *
     * @param id Company id
     * @param status new status
     * @return boolean
     */
    boolean changeCompanyStatus(String id , BaseStatus  status);



}
