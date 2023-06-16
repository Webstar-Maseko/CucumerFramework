package org.webstar.BaseTest;

import org.openqa.selenium.WebDriver;
import org.webstar.Pages.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public String productName;
    Base base;

    public TestContextSetup(){
        base = new Base();
        driver = base.getDriver();;
        pageObjectManager = new PageObjectManager(driver);
    }

}
