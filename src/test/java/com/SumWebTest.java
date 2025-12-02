package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SumWebTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testSum() throws InterruptedException {
        // Path Jenkins will use to access HTML
        String path = System.getProperty("user.dir") + "/src/test/resources/sum.html";
        String url = "file:///" + path.replace("\\", "/");
        driver.get(url);

        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));
        WebElement calcBtn = driver.findElement(By.id("calcBtn"));
        WebElement result = driver.findElement(By.id("result"));

        num1.sendKeys("10");
        num2.sendKeys("20");
        calcBtn.click();

        Thread.sleep(1000);

        assertEquals("Sum = 30", result.getText().trim());
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
