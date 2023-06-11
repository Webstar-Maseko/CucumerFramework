package org.webstar.Factory.BrowserConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup {

    private static ThreadLocal<WebDriver> driver;
    public BrowserSetup(){
        driver = new ThreadLocal<>();
    }

    public void browserSetup(String browser){

        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            driver.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("Microsoft Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();

            driver.set(new EdgeDriver(options));

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options =  new FirefoxOptions();

            driver.set(new FirefoxDriver(options));
        }
    }
    public WebDriver getDriver(){
        System.out.println(driver.get());
        return driver.get();
    }
}
