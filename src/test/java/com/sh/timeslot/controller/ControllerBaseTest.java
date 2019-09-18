package com.sh.timeslot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.sh.timeslot.TimeslotApplication;
import com.sh.timeslot.configuration.DatabaseConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore

@Slf4j
@SpringBootTest(classes = ControllerBaseTest.TestConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ControllerBaseTest {
    String  CORE_TRIP_API = "/";
    protected long defBaseId = 2;
    protected long defCustomerID = 7075;

    protected Faker faker = new Faker();

    @Autowired
    public ObjectMapper objectMapper;

    @MockBean
    MongoTemplate mongoTemplate;


    @Configuration
    @EnableAutoConfiguration (exclude = {MongoDataAutoConfiguration.class,  EmbeddedMongoAutoConfiguration.class})
    @ComponentScan(basePackages = "com.sh.timeslot" )
    static class TestConfiguration {

    }

}
