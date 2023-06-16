package org.webstar.Steps;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.webstar.BaseTest.TestContextSetup;

import java.util.Base64;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup contextSetup){
        this.testContextSetup = contextSetup;
    }

    @After
    public void tearDown(){
        testContextSetup.driver.quit();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario){
        try{
            if(scenario.isFailed()){
                String base64 = ((TakesScreenshot)testContextSetup.driver).getScreenshotAs(OutputType.BASE64);
                ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"See captured issue", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
            }


        }catch (Exception ex){

        }
    }
}
