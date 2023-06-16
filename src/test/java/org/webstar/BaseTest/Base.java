package org.webstar.BaseTest;

import org.openqa.selenium.WebDriver;
import org.webstar.Factory.BrowserConfig.BrowserSetup;
import org.webstar.Utilities.ReadProperties;

import java.util.Properties;

public class Base {

    private WebDriver driver;
    BrowserSetup setup;
    Properties prop;
    public WebDriver getDriver(){
        setup = new BrowserSetup();
        prop = new ReadProperties().init_Prop();
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
