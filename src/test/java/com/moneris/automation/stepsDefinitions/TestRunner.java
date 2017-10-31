package com.moneris.automation.stepsDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		 	features = "src/test/java/com/moneris/automation/features",
	        glue = "com.moneris.automation.stepsDefinitions",
	        plugin = { 
	                    "pretty",
	                    "json:target/cucumber.json"
	                }
	        ,
	        tags = { "~@ignore" },
	        monochrome = true

	        )
public class TestRunner {}