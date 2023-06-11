package org.webstar.Factory.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Interact {
    WebDriver driver;
    WebDriverWait wait;

    public Interact(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));


        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    protected void fill(WebElement element, String name, String text) {
        if (waitForElement(element)) {
            element.clear();
            element.sendKeys(text);
            System.out.println(text + " was successfully sent to " + name + " input box");
        } else {
            System.out.println(text + " couldn't be sent to " + name + " input box because it cannot be found ");
        }
    }

    protected Boolean waitForElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;


        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
