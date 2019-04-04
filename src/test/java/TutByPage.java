

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TutByPage {

    @FindBy(css = "a[data-target-popup='authorize-form']")
    private WebElement enterPopup;

    private WebElement login;

    private WebElement password;

    @FindBy(css = "input.button.auth__enter")
    private WebElement enterButton;

    @FindBy(className = "uname")
    private WebElement content;

    private final String url = "https://tut.by";


    public TutByPage() {
        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();
        PageFactory.initElements(driver, this);
        driver.get(url);
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
        explicitWait.until(ExpectedConditions.visibilityOf(content));
    }

    public String getContentValue() {
        return content.getText();
    }
}

