

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TutByPage {

    private WebElement enterPopup;
    private WebElement login;
    private WebElement password;
    private WebElement enterButton;
    private WebElement exitPopup;

    private final String url = "https://tut.by";


    public TutByPage() {
        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();
        driver.get(url);

        enterPopup = driver.findElement(By.cssSelector("a[data-target-popup='authorize-form']"));
        login = driver.findElement(By.name("login"));
        password = driver.findElement(By.name("password"));
        enterButton = driver.findElement(By.cssSelector("input.button.auth__enter"));
    }


    public void login(String user, String passwd) {
        enterPopup.click();
        login.sendKeys(user);
        password.sendKeys(passwd);
        enterButton.click();

        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        exitPopup = driver.findElement(By.className("uname"));
        explicitWait.until(ExpectedConditions.visibilityOf(exitPopup));
    }

    public String getExitPopupValue() {
        return exitPopup.getText();
    }
}

