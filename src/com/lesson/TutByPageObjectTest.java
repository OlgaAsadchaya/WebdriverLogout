package com.lesson;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutByPageObjectTest {
    @Test
    public void testTutByPage(){
        //Open Chrome Browser and navigate to tut.by Page
        WebDriver driver = new ChromeDriver();
        driver.get("https://tut.by");

        //Create instance of TutByPage and pass the driver
        TutByPage tutByPage = new TutByPage(driver);

        tutByPage.enterPopup.click();
        tutByPage.login.sendKeys("seleniumtests@tut.by");
        tutByPage.password.sendKeys("123456789zxcvbn");
        tutByPage.enterButton.click();

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(tutByPage.content));
        assertEquals("Selenium Test", tutByPage.content.getText());

        //Close the Browser
        driver.close();
    }
}
