package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.Interact;

public class CheckoutPage extends Interact {

    public CheckoutPage(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='product-name']")
    private WebElement productName ;

    public String getProductName(){
        if(waitForElement(productName)){

            return productName.getText();
        }else
            return "";
    }
}
