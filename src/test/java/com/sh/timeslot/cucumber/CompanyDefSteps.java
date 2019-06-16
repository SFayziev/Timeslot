package com.sh.timeslot.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.timeslot.model.request.CompanyRequest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanyDefSteps  {

    private CompanyRequest companyRequest;


    @Autowired
    ObjectMapper objectMapper;

    ResultActions result ;

    @Autowired
    MockMvc mockMvc;

    @Given("^company \"([^\"]*)\"$")
    public void the_company_name(String name) throws Throwable {
        companyRequest = CompanyRequest.builder().name(name).build();

    }

    @When("^client call api post (.+)$")
    public void the_client_callpost_Api(String path) throws Throwable {

        result = mockMvc
                .perform(post(path).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(companyRequest)));
    }

    @And("^the client receives company status (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        result.andExpect(jsonPath("$.status", is(version)));
    }

    @And("^the client receives companies with status (.+)$")
    public void the_client_receives_servers_version_body(String version) throws Throwable {
        result.andExpect(jsonPath("$[0].status", is(version)));
    }


    //    When  client call api get /company by name
    @When("^client call api get (.+)$")
    public void the_client_call_getApi(String path) throws Throwable {

        result = mockMvc
                .perform(get(path).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(companyRequest)));
    }


}
