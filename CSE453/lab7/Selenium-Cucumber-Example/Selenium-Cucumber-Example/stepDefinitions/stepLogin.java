package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepLogin {
	WebDriver driver;
	@Given("User Launch Chrome browser")
	public void openbrowser()
	{
		WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver();
	}
	@When("Users open {string}")
	public void openwebsite(String url )
	{
		driver.get(url);
	}
	@When("Users enters Email as {string} and Password as {string}")
	public void login(String email, String password)
	{
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys(password);
		
	}
	@When ("Click on Login")
	public void clicklogin()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then ("Page title should be {string}")
	public void test1pageTitle(String et)
	{
		String at=driver.getTitle();
		assertEquals(et,at);
	}
	@When ("Users click on Log out")
	public void clicklogout()
	{
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
	}
	@Then ("Page Title should be {string}")
	public void test2pagetitle(String epagetitle)
	{
		String apagetitle=driver.getTitle();
		assertEquals(epagetitle,apagetitle);
	}
	@Then ("Close Browser")
	public void closebrowse()
	{
		driver.close();
	}

}
