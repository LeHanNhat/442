package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepRegistration {
	
	WebDriver driver;
	 List<WebElement> pricelist1=new ArrayList<WebElement>();
	 List<Double> pricelist2=new ArrayList<Double>();
	@Given("User will open the chrome browser")
	public void openbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@When("Users open URL {string}")
	public void openurl(String url)
	{
		driver.get(url);
	}
	@And("Users click register")
	public void clickregister()
	{
		driver.findElement(By.xpath("//button[@class='button-1 register-button']")).click();
	}
	@Then ("Users can view Register page")
	public void test1viewregister()
	{
		String et="Register";
		assertTrue(driver.getTitle().contains("Register"));
	}
	@When ("Users enters customers info")
	public void enterinfo()
	{
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Shreya");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Banerjee");
		driver.findElement(By.xpath("//div/select[@name='DateOfBirthDay']")).click();
		driver.findElement(By.xpath("//div/select[@name='DateOfBirthMonth']")).click();
		driver.findElement(By.xpath("//div/select[@name='DateOfBirthYear']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("shreyabanerjee678@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("shreya123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("shreya123");
	}
	@When ("Users click register button")
	public void approveregister()
	{
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
	}
	@Then ("Users can view {string}")
	public void test2viewregister(String es)
	{
		
		assertTrue(driver.getPageSource().contains(es));
	}
	@When ("Users click continue")
	public void clickcontinue()
	{
		driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']")).click();
	}
	@Then ("users view page titled as {string}")
	public void test3viewregister(String es)
	{
		
		assertTrue(driver.getTitle().contains(es));
	}
	@Then ("users write prices displayed in that page those are greater than $1,000.00 in console in descending order")
	public void printprices()
	{
		pricelist1= driver.findElements(By.xpath("//span[@class='price actual-price']"));
		 for (int i = 0; i < pricelist1.size(); i++) {
			 pricelist2.add(Double.valueOf((pricelist1.get(i).getText().replaceAll(",", "").substring(1))));
			}
			Collections.sort(pricelist2);
			for (int i = pricelist2.size()-1; i >=0 ; i--) {
				if(pricelist2.get(i)>=1000.00)
				System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(pricelist2.get(i)));
			}
	}
	@Then ("user close browser")
	public void close_browser()
	{
	
		driver.close();
	}
}
