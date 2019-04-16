
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


class LogoutTest {
    WebDriver tutBy = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver();

    @BeforeEach
    void setUp() {
        tutBy.get("https://tut.by");
        tutBy.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        ((TakesScreenshot)tutBy).getScreenshotAs(OutputType.FILE);
    }

    @AfterEach
    void tearDown() {
        tutBy.close();
    }

    @Feature("Login")
    @Description("Verify login")
    @AllureId("ID1")
    @Test
    void login() {
        // unconditional synchronization
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).click();
        tutBy.findElement(By.name("login")).sendKeys("seleniumtests@tut.by");
        tutBy.findElement(By.name("password")).sendKeys("123456789zxcvbn");
        tutBy.findElement(By.className("auth__enter")).click();

        WebElement content = tutBy.findElement(By.className("uname"));

        // Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(tutBy, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(content));
        assertTrue(false);// simulation of fail
        //assertEquals(content.getText(), "Selenium Test");
    }

    @Feature("Logout")
    @Description("Verify logout")
    @AllureId("ID2")
    @Test
    void logout() {
        // unconditional synchronization
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).click();
        tutBy.findElement(By.name("login")).sendKeys("seleniumtests@tut.by");
        tutBy.findElement(By.name("password")).sendKeys("123456789zxcvbn");
        tutBy.findElement(By.className("auth__enter")).click();

        WebElement content = tutBy.findElement(By.className("uname"));

        // Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(tutBy, 10);
        explicitWait.pollingEvery(Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(content));
        assertEquals(content.getText(), "Selenium Test");
        tutBy.findElement(By.className("uname")).click();

        WebDriverWait explicitWait2 = new WebDriverWait(tutBy, 10);
        WebElement content2 = tutBy.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        explicitWait2.until(ExpectedConditions.visibilityOf(content2));
        assertEquals(content2.getText(), "Выйти");

        tutBy.findElement(By.xpath("//a[contains(text(),'Выйти')]")).click();
        assertTrue(tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).isDisplayed());
    }
}