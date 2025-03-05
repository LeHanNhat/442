package com.example.demoCse453;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacebookSignupTest {

    private WebDriver driver;
    private Random random = new Random();
    
    @BeforeEach
    public void setUp() {
        // Use WebDriverManager for driver setup
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        
        // Initialize the driver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testFacebookSignup() {
        // 1. Go to Facebook signup page
        driver.get("https://www.facebook.com/signup");
        
        // 2. Create an account with random data
        String firstName = "Test" + random.nextInt(1000);
        String lastName = "User" + random.nextInt(1000);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@testmail.com";
        String password = "TestPass" + random.nextInt(10000) + "!";
        
        // Fill in the registration form
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        
        // Confirm email
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
        
        // Set password
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
        
        // Set birthday
        new Select(driver.findElement(By.id("day"))).selectByValue("15");
        new Select(driver.findElement(By.id("month"))).selectByValue("6");
        new Select(driver.findElement(By.id("year"))).selectByValue("1990");
        
        // Select gender
        driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
        
        // Click Sign Up button
        driver.findElement(By.name("websubmit")).click();
        
        // Wait for redirect after signup
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 3. Test the next web page title
        String actualTitle = driver.getTitle();
        assertEquals("Facebook", actualTitle);
    }
    
    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
