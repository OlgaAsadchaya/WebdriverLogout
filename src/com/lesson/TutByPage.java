package com.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TutByPage {

    @FindBy(css = "a[data-target-popup='authorize-form']")
    public WebElement enterPopup;

    public WebElement login;

    public WebElement password;

    @FindBy(css = "input.button.auth__enter")
    public WebElement enterButton;

    @FindBy(className = "uname")
    public WebElement content;


    public TutByPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

