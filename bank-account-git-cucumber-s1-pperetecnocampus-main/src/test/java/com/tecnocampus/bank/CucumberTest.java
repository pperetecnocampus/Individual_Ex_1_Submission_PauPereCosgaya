package com.tecnocampus.bank;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com.tecnocampus.bank.cucumberspringboot")
@ConfigurationParameter(key = "cucumber.glue", value = "com.tecnocampus.bank.steps") // Step definitions package
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, summary")
public class CucumberTest {
}