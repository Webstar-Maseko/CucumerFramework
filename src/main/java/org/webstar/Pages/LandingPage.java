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

    @FindBy(xpath = "(//div[@class='product']/h4)[1]")
    private WebElement firstVegitable;

    @FindBy(xpath = "//a[normalize-space()='Top Deals']")
    private WebElement topDealsLink;

    @FindBy(xpath = "(//a[@class=\"increment\"])[1]")
    private WebElement increaseCartQuantiy;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='ADD TO CART'])[1]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//a[@class='cart-icon']")
    private WebElement cartBtn;

    @FindBy(xpath = "//button[normalize-space()='PROCEED TO CHECKOUT']")
    private WebElement proceedToCheckout;


    public void searchVegitables(String keyword){
        fill(searchInput,"Search box", keyword);
    }

    public String getFirstVegitableText(){
        if(waitForElement(firstVegitable)){

            return firstVegitable.getText();
        }else
            return "";
    }

    public void clickTopDeals(){
        click(topDealsLink);
        System.out.println("Clicked top deals");
    }

    public Boolean verifyLandingPage(){
        return waitForElement(brandLogo);
    }

    public void increaseCartQuantity(int count){
        for (int i =0; i<count;i++){
            click(increaseCartQuantiy);
        }
    }

    public void clickAddToCart(){
        click(addToCartBtn);
    }

    public void clickCart(){
        click(cartBtn);
    }

    public void clickCheckout(){
        click(proceedToCheckout);
    }


}
