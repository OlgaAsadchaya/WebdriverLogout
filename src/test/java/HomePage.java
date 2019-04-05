
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebElement exit;
    private WebElement exitPopup;
    private WebElement enterPopup;

    public HomePage() {
        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();

        exit = driver.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        exitPopup = driver.findElement(By.className("uname"));
    }


    public void logout() {
        exitPopup.click();
        exit.click();
    }

    public boolean isEnterPopupExists() {
        SingletonBrowserClass sbc= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        final WebDriver driver = sbc.getDriver();
        enterPopup = driver.findElement(By.cssSelector("a[data-target-popup='authorize-form']"));
        return enterPopup.isDisplayed();
    }
}

