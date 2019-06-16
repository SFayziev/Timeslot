package com.sh.timeslot.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber" ,  plugin = {"pretty", "html:target/cucumber"})
public class CucumberTest {
}