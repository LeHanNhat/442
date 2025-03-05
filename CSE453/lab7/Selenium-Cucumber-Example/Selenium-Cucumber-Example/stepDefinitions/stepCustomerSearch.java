package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepCustomerSearch {
	WebDriver driver;
	 WebElement e1;
	@Given("^Users Launch Chrome browser$")
	public void open_web_browser() 
	{
		WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver();
	}
	@When("User opens URL {string}")
	public void open_URL(String url) 
	{
		 driver.get(url);
	}
	@When("User enters Email as {string} and Password as {string}")
	public void enter_password_email(String email, String password) 
	{
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Email")).sendKeys(email);;
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
	}
	@When("^Clicks on Login$")
	public void click_login() 
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		
	}
	 @Then ("User can view Dashboard")
	 public void view_Dashboard() 
		{
			assertTrue(driver.getTitle().contains("Dashboard / nopCommerce administration"));
				
		}
	 @When ("users click on Customers menu")
	 public void clickCustomersMenu() 
		{
		 driver.findElement(By.xpath("//a[@class='nav-link']/p[contains(text( ),'Customers')]/i")).click();
		}
	 @When ("click on Customers menu item")
	 public void clickCustomersItem() 
		{
		 driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")).click();
		}
	 @When ("users enter Email {string}")
	 public void enterEmail(String email) 
		{
		 driver.findElement(By.xpath("//input[@id='SearchEmail']")).sendKeys(email);
		}
	 @When ("users enter First name {string}")
	 public void enterFirstname(String fn) 
		{
		 driver.findElement(By.xpath("//input[@id='SearchFirstName']")).sendKeys(fn);
		}
	 @When ("users enter Last name {string}")
	 public void enterLastname(String ln) 
		{
		 driver.findElement(By.xpath("//input[@id='SearchLastName']")).sendKeys(ln);
		}
	 @When ("users select Date of Birth as 9th of June")
	 public void selectDoB() 
		{
		 Select ms=new Select(driver.findElement(By.xpath("//select[@id='SearchMonthOfBirth']")));
		 ms.selectByValue("6");
		 Select ds=new Select(driver.findElement(By.xpath("//select[@id='SearchDayOfBirth']")));
		 ds.selectByValue("9");
		}
	 @When ("users click search button")
	 public void clickSearchbt() 
		{
		 driver.findElement(By.xpath("//button[@id='search-customers']")).click();
		}

@Then ("User can view {string}")
public void viewText(String emessage) 
	{
	assertTrue( driver.getPageSource().contains(emessage));
	}
@Then ("close browser")
public void closeBrowser() 
	{
	driver.close();
	}

}
