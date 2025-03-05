package features;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebFormStep {
	WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Given("I open the web form page")
    public void iOpenTheWebFormPage() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @When("I enter {string} in the text field")
    public void iEnterInTheTextField(String text) {
        driver.findElement(By.name("my-text")).sendKeys(text);
    }

    @When("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        driver.findElement(By.name("my-password")).sendKeys(password);
    }

    @When("I enter {string} in the textarea")
    public void iEnterInTheTextarea(String message) {
        driver.findElement(By.name("my-textarea")).sendKeys(message);
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("I navigate back to the web form page")
    public void iNavigateBackToTheWebFormPage() {
        driver.navigate().back();
    }

    @When("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String option) {
        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText(option);
    }

    @Then("the checkbox with id {string} should be selected")
    public void theCheckboxWithIdShouldBeSelected(String checkboxId) {
        Assertions.assertTrue(driver.findElement(By.id(checkboxId)).isSelected());
    }

    @Then("the radio button with id {string} should be selected")
    public void theRadioButtonWithIdShouldBeSelected(String radioId) {
        Assertions.assertTrue(driver.findElement(By.id(radioId)).isSelected());
    }

    @Then("the default checkbox below {string} should be selected")
    public void theDefaultCheckboxBelowShouldBeSelected(String checkboxId) {
        WebElement defaultCheckbox = driver.findElement(
            RelativeLocator.with(By.tagName("input")).below(By.id(checkboxId))
        );
        Assertions.assertTrue(defaultCheckbox.isSelected());
    }

    @When("I set the color picker to {string}")
    public void iSetTheColorPickerTo(String color) {
        driver.findElement(By.name("my-colors")).sendKeys(color);
    }

    @When("I set the date picker to {string}")
    public void iSetTheDatePickerTo(String date) {
        driver.findElement(By.name("my-date")).sendKeys(date);
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}