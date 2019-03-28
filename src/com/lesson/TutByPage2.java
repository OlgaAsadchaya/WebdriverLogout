package com.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TutByPage2 {

    @FindBy(css = "a[data-target-popup='authorize-form']")
    private WebElement enterPopup;

    private WebElement login;

    private WebElement password;

    @FindBy(css = "input.button.auth__enter")
    private WebElement enterButton;

    @FindBy(className = "uname")
    private WebElement content;

    private WebDriver driver;
    private String url = "https://tut.by";


    public TutByPage2() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void load() {
        this.driver.get(url);
    }
    public void close() {
        this.driver.close();
    }

    public void login() {
        enterPopup.click();
        login.sendKeys("seleniumtests@tut.by");
        password.sendKeys("123456789zxcvbn");
        enterButton.click();

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(content));
    }

    public String getContentValue() {
        return content.getText();
    }
}

