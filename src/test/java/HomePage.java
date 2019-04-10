
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    final WebDriver driver = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver();

    private By exitBy = By.xpath("//a[contains(text(),'Выйти')]");
    private By exitPopupBy = By.className("uname");
    private By enterPopupBy = By.cssSelector("a[data-target-popup='authorize-form']");

    public void logout() {
        driver.findElement(exitPopupBy).click();
        driver.findElement(exitBy).click();
    }

    public boolean isEnterPopupExists() {
        return driver.findElement(enterPopupBy).isDisplayed();
    }
}

