package com.test.swapnil.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.swapnil.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
    public static WebDriver driver;

    @Before
    public void openBrowser() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @After
    public void embedScreenshot(io.cucumber.java.Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "StepFailed");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }

}
