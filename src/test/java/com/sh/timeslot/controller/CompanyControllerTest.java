package com.sh.timeslot.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sh.timeslot.controller.impl.BranchControllerImpl;
import com.sh.timeslot.controller.impl.CompanyControllerImpl;
import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.db.entity.Company;
import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.model.request.CompanyRequest;
import com.sh.timeslot.service.CompanyService;
import com.sh.timeslot.service.FakerData;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;

public class CompanyControllerTest extends ControllerBaseTest {

  private MockMvc mockMvc;
  private final String companyAPIPath= "company";

  @Autowired
  private CompanyService companyService;


  @Before
  public void setup(){
    mockMvc = MockMvcBuilders.standaloneSetup(new CompanyControllerImpl(companyService)).build();
  }


  @Test
  public void createCompany_and_getSuccess() throws Exception {
    Company  company = FakerData.generateCompany();

    String json = objectMapper.writeValueAsString(CompanyRequest.builder().id(defCustomerID).build())  ;
    when(mongoTemplate.insert( ArgumentMatchers.any(Company.class) ) ).thenReturn( company );

    mockMvc.perform(post(CORE_TRIP_API +  companyAPIPath ).contentType(MediaType.APPLICATION_JSON).content(json) )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.name", is(company.getName())))
        .andExpect(jsonPath("$.id", is(company.getIdentifier().intValue())))
        .andExpect(jsonPath("$.address.addressOne", is(company.getAddress().getAddressOne())))
    ;
  }


  @Test
  public void getCompanyById_and_getSuccess() throws Exception {
    Company  company = FakerData.generateCompany();
    when(mongoTemplate.find(ArgumentMatchers.any(), ArgumentMatchers.any()   ) ).thenReturn(
        Collections.singletonList( company ));
    String json = objectMapper.writeValueAsString(CompanyRequest.builder().id( company.getIdentifier()).build())  ;
    mockMvc.perform(get(CORE_TRIP_API + companyAPIPath).contentType(MediaType.APPLICATION_JSON).content(json) )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$[0].name", is(company.getName())))
        .andExpect(jsonPath("$[0].id", is(company.getIdentifier().intValue())))
        .andExpect(jsonPath("$[0].address.addressOne", is(company.getAddress().getAddressOne())));
  }

}
