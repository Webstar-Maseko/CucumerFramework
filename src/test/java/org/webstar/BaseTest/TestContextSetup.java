package org.webstar.BaseTest;

import org.openqa.selenium.WebDriver;
import org.webstar.Factory.BrowserConfig.BrowserSetup;
import org.webstar.Pages.PageObjectManager;
import org.webstar.Utilities.ReadProperties;

import java.util.Properties;

public class TestContextSetup {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public String productName;
    BrowserSetup setup;
    Properties prop;


    public TestContextSetup(){
        setup = new BrowserSetup();
        prop = new ReadProperties().init_Prop();
        driver = getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    public WebDriver getDriver(){
        if(driver == null){
            String browser = System.getProperty("browser") == null? prop.getProperty("browser"): System.getProperty("browser");
            setup.browserSetup(browser);
            driver = setup.getDriver();
            driver.manage().window().maximize();

            driver.get(prop.getProperty("url"));
        }

        return driver;
    }


}
