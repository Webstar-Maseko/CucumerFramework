package org.webstar.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.webstar.BaseTest.TestContextSetup;
import org.webstar.Pages.LandingPage;

public class LandingPageStepDef {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDef(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }
    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        Assert.assertTrue(landingPage.verifyLandingPage());
    }
    @When("^user searches with shortname (.+) and extracts actual name of product$")
    public void user_searches_with_shortname_and_extracts_actual_name_of_product(String string) throws InterruptedException {
        landingPage.searchVegitables(string);
        testContextSetup.productName = landingPage.getFirstVegitableText();

        Thread.sleep(1000);
    }


    @When("user navigates to offer page")
    public void userNavigatesToOfferPage() {

        landingPage.clickTopDeals();
    }
}
