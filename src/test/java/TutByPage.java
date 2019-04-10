

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TutByPage {
    final WebDriver driver = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver();

    private WebElement enterPopup;
    private WebElement login;
    private WebElement password;
    private WebElement enterButton;
    private WebElement exitPopup;

    private By enterPopupBy = By.cssSelector("a[data-target-popup='authorize-form']");
    private By loginBy = By.name("login");
    private By passwordBy = By.name("password");
    private By enterButtonBy = By.cssSelector("input.button.auth__enter");
    private By exitPopupBy = By.className("uname");

    private final String url = "https://tut.by";


    public TutByPage() {
        driver.get(url);
    }


    public void login(String user, String passwd) {
        driver.findElement(enterPopupBy).click();
        driver.findElement(loginBy).sendKeys(user);
        driver.findElement(passwordBy).sendKeys(passwd);
        driver.findElement(enterButtonBy).click();

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        WebElement exitPopup = driver.findElement(exitPopupBy);
        explicitWait.until(ExpectedConditions.visibilityOf(exitPopup));
    }

    public String getExitPopupValue() {
        return driver.findElement(exitPopupBy).getText();
    }
}

