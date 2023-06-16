package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.Interact;

public class OfferPage extends Interact {
    WebDriver driver;
    public OfferPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);


    }

    @FindBy(css = "span.redLogo")
    private WebElement brandLogo;

    @FindBy(id = "search-field")
    private WebElement searchInput;

    @FindBy(xpath = "(//td)[1]")
    private WebElement firstVegitable;

    public void searchVegitables(String keyword){
        switchToNewTab();
        fill(searchInput,"Search box", keyword);
    }

    public String getFirstVegitableText(){
        if(waitForElement(firstVegitable)){

            return firstVegitable.getText();
        }else
            return "";
    }


}
