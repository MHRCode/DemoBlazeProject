package com.demoblaze.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		  features = "src/test/resources/features/DemoBlazeHome.feature", 
		    glue = {"com.demoblaze.steps"},
		    plugin = {"pretty", "html:target/cucumber-reports.html"},
		    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}