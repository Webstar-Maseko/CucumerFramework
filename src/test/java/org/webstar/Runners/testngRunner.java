package org.webstar.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/org/webstar/Features", glue = "org.webstar.Steps", plugin = {"pretty","html:Report/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class testngRunner extends AbstractTestNGCucumberTests {

    //Overriding the data provider will allow you to run your tests parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
