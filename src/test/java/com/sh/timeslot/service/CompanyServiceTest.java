package com.sh.timeslot.service;

import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.MongoQueryField;
import com.sh.timeslot.model.request.CompanyRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createCompany_and_expect_success(){
        CompanyRequest comRequest  =  FakerData.generateCompanyRequest();
        Company com = companyService.createCompany(comRequest);
        Assert.assertEquals(comRequest.getName(), com.getName() );
        assertEquals( comRequest.getAddress().getCity(), com.getAddress().getCity() );

    }


    @Test
    public void getCompany_and_expect_success(){
        companyService.createCompany(FakerData.generateCompanyRequest());
        companyService.createCompany(FakerData.generateCompanyRequest());
        CompanyRequest comRequest  =  FakerData.generateCompanyRequest();
        companyService.createCompany(comRequest);

        List<Company> companyList = companyService.getCompanies(comRequest);
        assertFalse(companyList.isEmpty());
        assertEquals( companyList.get(0).getName(), comRequest.getName());
        assertEquals( companyList.get(0).getEmail(), comRequest.getEmail());

    }

}