package org.webstar.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        System.out.println("here");
    }

    @Then("verify that logo brand is displayed")
    public void verifyThatLogoBrandIsDisplayed() {
        Assert.assertTrue(landingPage.verifyLandingPage());
    }

    @And("user should be able to fill the search box")
    public void userShouldBeAbleToFillTheSearchBox() {
        landingPage.searchVegitables("Tomato");
    }
}
