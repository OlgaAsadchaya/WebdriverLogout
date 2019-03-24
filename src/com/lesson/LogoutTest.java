package com.lesson;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

class LogoutTest {
    WebDriver tutBy;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        tutBy = new ChromeDriver();
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
        assertEquals(content.getText(), "Selenium Test");
        tutBy.findElement(By.className("uname")).click();

        WebDriverWait explicitWait2 = new WebDriverWait(tutBy, 10);
        WebElement content2 = tutBy.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        explicitWait2.until(ExpectedConditions.visibilityOf(content2));
        assertEquals(content2.getText(), "Выйти");

        tutBy.findElement(By.xpath("//a[contains(text(),'Выйти')]")).click();
        assertTrue(tutBy.findElement(By.cssSelector("a[data-target-popup='authorize-form']")).isDisplayed());

    }

    private static class FileUtils {
        public static void copyFile(File scrFile, File file) {
        }
    }
}