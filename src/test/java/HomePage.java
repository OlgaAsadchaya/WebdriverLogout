

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement exit;

    @FindBy(className = "uname")
    private WebElement exitPopup;

    @FindBy(css = "a[data-target-popup='authorize-form']")
    private WebElement enterPopup;

    public HomePage() {
        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void logout() {
        exitPopup.click();
        exit.click();
    }

    public boolean isEnterPopupExists() {
        return enterPopup.isDisplayed();
    }
}

