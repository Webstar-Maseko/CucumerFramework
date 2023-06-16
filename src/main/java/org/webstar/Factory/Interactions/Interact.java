package org.webstar.Factory.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

            element.click();
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
    private String parentTab;
    protected void switchToNewTab(){
        try{
            parentTab = driver.getWindowHandle();
            Set<String> tabs = driver.getWindowHandles();
            Iterator<String> iterator= tabs.iterator();
            String childWindow="";
            while(iterator.hasNext()){
                childWindow = iterator.next();
            }
            driver.switchTo().window(childWindow);


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void switchToParentTab(){
        try{

            driver.switchTo().window(parentTab);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
