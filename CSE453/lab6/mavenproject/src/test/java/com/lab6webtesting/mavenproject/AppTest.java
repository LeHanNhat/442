package com.lab6webtesting.mavenproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class AppTest {

	public static WebDriver driver;
	@BeforeAll
	public static void setup() {
    	WebDriverManager.chromedriver().clearDriverCache().setup();
    	driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().maximize();
    }
	
    @Test
    public void fillInputs() {

    	    
    	    
    	driver.findElement(By.id("my-text-id")).sendKeys("Test Text");
        driver.findElement(By.name("my-password")).sendKeys("password123");
        driver.findElement(By.name("my-textarea")).sendKeys("This is a text area.");

        // III. Click Return to Index Link
        driver.findElement(By.linkText("Return to index")).click();

        // IV. Test Page Title
        assertEquals("Index of Available Pages", driver.getTitle());
        

        // V. Return to Web Form
        driver.navigate().back();

        // VI. Select Dropdown Option
        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText("Two"); // Or select by value/index

        // VII. Test Checked Checkbox & Radio
        WebElement checkedCheckbox = driver.findElement(By.id("my-check-1"));
        assertTrue(checkedCheckbox.isSelected());

        WebElement checkedRadio = driver.findElement(By.id("my-radio-1"));
        assertTrue(checkedRadio.isSelected());

        // VIII. Find Default Checkbox via Relative Locator
        WebElement defaultCheckbox = driver.findElement(
           RelativeLocator.with(By.tagName("input"))
           	.below(By.id("my-check-2"))
        );
        assertTrue(defaultCheckbox.isSelected());

        // IX. Change Color Picker
        driver.findElement(By.name("my-colors")).sendKeys("#00FF00");

        // X. Set Date
        driver.findElement(By.name("my-date")).sendKeys("2023-12-25");

        // XI. Click Submit
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // XII. Test Received! Message
        
        String message =  driver.findElement(By.id("message")).getText();
        assertEquals("Received!", message);
    	    
    }
    
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
