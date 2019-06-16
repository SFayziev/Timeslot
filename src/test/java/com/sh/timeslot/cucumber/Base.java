package com.sh.timeslot.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Then;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
public class Base  {


    @Autowired
    ObjectMapper objectMapper;

    ResultActions result ;

    @Autowired
    MockMvc mockMvc;

}
