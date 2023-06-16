package org.webstar.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.webstar.BaseTest.TestContextSetup;
import org.webstar.Pages.CheckoutPage;
import org.webstar.Pages.LandingPage;

public class CheckoutStepDef {
    TestContextSetup testContextSetup;
    LandingPage landingPage;
    CheckoutPage checkoutPage;

    public CheckoutStepDef(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @Then("user increases the cart quantity by {string} and add items to cart")
    public void userIncreasesTheCartQuantityAndAddItemsToCart(String arg) {
        landingPage.increaseCartQuantity(Integer.parseInt(arg));
        landingPage.clickAddToCart();

    }

    @And("user view the cart and proceeds to checkout")
    public void userViewTheCartAndProceedsToCheckout() {
        landingPage.clickCart();
        landingPage.clickCheckout();
    }

    @Then("verify the product name in the cart matches the one that was searched")
    public void verifyTheProductNameInTheCartMatchesTheOneThatWasSearched() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getProductName(),testContextSetup.productName);
    }

}
