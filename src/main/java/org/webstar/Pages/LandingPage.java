package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.Interact;

public class LandingPage extends Interact {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span.redLogo")
    private WebElement brandLogo;

    @FindBy(css = "input.search-keyword")
    private WebElement searchInput;

    public void searchVegitables(String keyword){
        fill(searchInput,"Search box", keyword);
    }


    public Boolean verifyLandingPage(){
        return waitForElement(brandLogo);
    }
}
