package com.test.swapnil.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue= {"com.test.swapnil.stepDefs"},
monochrome= true,
plugin = {"pretty", 
		"junit:target/JUnitReports/report.xml",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"html:target/cucumber-reports/ExecutionReport.html"}
		)

public class TestRunner {

}
