package org.webstar.Pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }

    public OfferPage getOfferPage() {
        return new OfferPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }
}
