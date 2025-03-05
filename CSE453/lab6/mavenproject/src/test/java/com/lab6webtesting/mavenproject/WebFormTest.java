package com.lab6webtesting.mavenproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

public class WebFormTest {
    private WebDriver driver;

    @Before
    public void setup() {
    	WebDriverManager.chromedriver().clearDriverCache().setup();
    	WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testWebForm() {
       
        
        System.out.println("Opening Chrome browser...");
        // II. Fill Inputs
        driver.findElement(By.id("my-text-id")).sendKeys("Test Text");
        driver.findElement(By.id("my-password")).sendKeys("password123");
        driver.findElement(By.id("my-textarea")).sendKeys("This is a text area.");

        // III. Click Return to Index Link
        driver.findElement(By.linkText("Return to index")).click();

        // IV. Test Page Title
        assertEquals("Index of Available Pages", driver.getTitle());
        

        // V. Return to Web Form
        driver.navigate().back();

        // VI. Select Dropdown Option
        Select dropdown = new Select(driver.findElement(By.id("my-select")));
        dropdown.selectByVisibleText("Two"); // Or select by value/index

        // VII. Test Checked Checkbox & Radio
        WebElement checkedCheckbox = driver.findElement(By.id("my-check-1"));
        assertTrue(checkedCheckbox.isSelected());

        WebElement checkedRadio = driver.findElement(By.id("my-radio-2"));
        assertTrue(checkedRadio.isSelected());

        // VIII. Find Default Checkbox via Relative Locator
        WebElement defaultCheckbox = driver.findElement(
            with(By.tagName("input"))
                .near(By.xpath("//label[contains(text(),'Default checkbox']"))
        );
        assertTrue(defaultCheckbox.isSelected());

        // IX. Change Color Picker
        driver.findElement(By.id("my-color")).sendKeys("#00FF00");

        // X. Set Date
        driver.findElement(By.id("my-date")).sendKeys("2023-12-25");

        // XI. Click Submit
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // XII. Test Received! Message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("message"))
        );
        assertEquals("Received!", message.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
