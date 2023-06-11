package org.webstar.Pages;

import io.cucumber.java.jv.Lan;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        return new LandingPage(driver);
    }
}
