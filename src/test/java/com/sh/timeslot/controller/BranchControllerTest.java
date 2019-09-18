package com.sh.timeslot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.timeslot.controller.impl.BranchControllerImpl;
import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.model.request.BranchRequest;
import com.sh.timeslot.service.BranchService;
import com.sh.timeslot.service.FakerData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class BranchControllerTest extends ControllerBaseTest {
    private MockMvc mockMvc;
    private final String branchAPIPath= "branch";

    @Autowired
    private BranchService branchService;



    @Before
    public void setup(){
        BranchController branchController = new BranchControllerImpl(branchService);
        mockMvc = MockMvcBuilders.standaloneSetup(branchController).build();
    }


    @Test

    public void createBranch_and_getSuccess() throws Exception {
        Branch fakeBranch = FakerData.generateBranch(defBaseId);

        String json = objectMapper.writeValueAsString(BranchRequest.builder().id(defBaseId).build())  ;
        when(mongoTemplate.insert( ArgumentMatchers.any(Branch.class) ) ).thenReturn( fakeBranch );

        mockMvc.perform(post(CORE_TRIP_API +  branchAPIPath ).contentType(MediaType.APPLICATION_JSON).content(json) )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name", is(fakeBranch.getName())))
                .andExpect(jsonPath("$.id", is(fakeBranch.getIdentifier().intValue())))
                .andExpect(jsonPath("$.contact.email", is(fakeBranch.getContact().getEmail())));
    }

    @Test
    public void getBranchById_and_getSuccess() throws Exception {
        Branch fakeBranch = FakerData.generateBranch(defBaseId);
        when(mongoTemplate.find(ArgumentMatchers.any(), ArgumentMatchers.any()   ) ).thenReturn(Collections.singletonList( fakeBranch ));
        String json = objectMapper.writeValueAsString(BranchRequest.builder().id(defBaseId).build())  ;
        mockMvc.perform(get(CORE_TRIP_API + branchAPIPath ).contentType(MediaType.APPLICATION_JSON).content(json) )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name", is(fakeBranch.getName())))
                .andExpect(jsonPath("$[0].id", is(fakeBranch.getIdentifier().intValue() )))
                .andExpect(jsonPath("$[0].contact.email", is(fakeBranch.getContact().getEmail())));
    }

}