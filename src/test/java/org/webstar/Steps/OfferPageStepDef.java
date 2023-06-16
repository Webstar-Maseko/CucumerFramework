package org.webstar.Steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.webstar.BaseTest.TestContextSetup;
import org.webstar.Pages.OfferPage;

public class OfferPageStepDef {
    TestContextSetup testContextSetup;
    OfferPage offerPage;
    public OfferPageStepDef(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        offerPage = testContextSetup.pageObjectManager.getOfferPage();
    }

    @Then("^user should find the same product in the offers page by searching (.+)$")
    public void userShouldFindTheSameProductInTheOffersPageBySearching(String arg0) {
        offerPage.searchVegitables(arg0);
    }

    @And("validate product name in offers page matches the one in landing page")
    public void validateProductNameInOffersPageMatchesTheOneInLandingPage() {
        Assert.assertEquals(offerPage.getFirstVegitableText().trim(),testContextSetup.productName.split("-")[0].trim());
    }
}
