package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features="src/test/java/features",
		glue ="stepDefinitions",
		//dryRun=true,
		monochrome=true,
		tags="@91Mobiles or @WhatFixApplication",
		plugin= {"pretty","html:target/CucumberReport.html"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
