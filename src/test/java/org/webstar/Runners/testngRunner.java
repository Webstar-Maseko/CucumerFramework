package org.webstar.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/org/webstar/Features", glue = "Steps", plugin = {"pretty","html:Report/cucumber.html"})
public class testngRunner extends AbstractTestNGCucumberTests {
}
