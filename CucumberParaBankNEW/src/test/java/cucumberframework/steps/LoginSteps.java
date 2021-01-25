package cucumberframework.steps;
  
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
  
import org.openqa.selenium.Alert; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before; 
import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When;
  
  
public class LoginSteps {
  
	WebDriver driver;
	
//	Background: login
	@Before() public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe"); 
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	@Given("^user navigates to Para Bank website$")
	public void user_navigates_to_Para_Bank_website() {
		driver.get("https://parabank.parasoft.com/parabank"); 
	}
	@Given("^user enters a valid username$")
	public void user_enters_a_valid_username() {
		driver.findElement(By.name("username")).sendKeys("person2");
	}
	@Given("^user enters a valid password$")
	public void user_enters_a_valid_password() {
		driver.findElement(By.name("password")).sendKeys("person2");
	}
	@When("^clicks the Log In button$")
	public void clicks_the_Log_In_button() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}
	@Then("^user is taken to Accounts Overview page$")
	public void user_is_taken_to_Accounts_Overview_page() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement AccountsOverviewDisplay = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1[contains(text(), 'Accounts Overview')]"));
		Assert.assertEquals(true, AccountsOverviewDisplay.isDisplayed());
	}

	
//	Part One
//	Open New Account
	@Given("^user clicks on Open New Account Link$")
	public void user_clicks_on_Open_New_Account_Link() throws Throwable{
		driver.findElement(By.xpath("//a[@href ='/parabank/openaccount.htm']")).click();
	}
	@Given("^user chooses what account type they want$")
	public void user_chooses_what_account_type_they_want() {
		Select dropAccount = new Select (driver.findElement(By.id("type")));
		dropAccount.selectByVisibleText("CHECKING");
	}
	@Given("^user chooses what account to deposit money into$")
	public void user_chooses_what_account_to_deposit_money_into() throws InterruptedException {
		Select dropAmount = new Select(driver.findElement(By.id("fromAccountId")));
		System.out.println(dropAmount.toString());
		dropAmount.getFirstSelectedOption();
		TimeUnit.SECONDS.sleep(1);
	}
	@When("^clicks the Open New Account button$")
	public void clicks_the_Open_New_Account_button() {
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input")).click();
	}
	@Then("^the new account is succesfully opened$")
	public void the_new_account_is_succesfully_opened() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement AmountsOverviewDisplay = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1[contains(text(), 'Account Opened!')]"));
		Assert.assertEquals(true, AmountsOverviewDisplay.isDisplayed());
	}

	
//	Part Two
//	Transfer Fund
	@Given("^user clicks on link to Transfer Funds$")
	public void user_clicks_on_link_to_Transfer_Funds() {
		driver.findElement(By.xpath("//a[@href ='/parabank/transfer.htm']")).click();
	}
	@Given("^user enters amount and account to choose$")
	public void user_enters_amount_and_account_to_choose(DataTable values) throws InterruptedException {
		List<List<String>> valueData = values.raw();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("amount")).sendKeys(valueData.get(0).get(0));
		Select dropAccountFrom = new Select (driver.findElement(By.id("fromAccountId")));
		dropAccountFrom.selectByVisibleText(valueData.get(0).get(1));
		Select dropAccountTo = new Select (driver.findElement(By.id("toAccountId")));
		dropAccountTo.selectByVisibleText(valueData.get(0).get(2));
	}
	@When("^click the Transfer button$")
	public void click_the_Transfer_button() {
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")).click();
	}
	@Then("^the transfer should be successful$")
	public void the_transfer_should_be_successful() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement TransferOverviewDisplay = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1[contains(text(), 'Transfer Complete!')]"));
		Assert.assertEquals(true, TransferOverviewDisplay.isDisplayed());
	}

	
//	Part Three
//	Customer Care
	@Given("^user clicks on Customer Care Form button$")
	public void user_clicks_on_Customer_Care_Form_button() {
		driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[2]/li[3]/a")).click();
	}
	@Given("^user enter name$")
	public void user_enter_name() {
		driver.findElement(By.id("name")).sendKeys("Guy 1");
	}
	@Given("^user enter email$")
	public void user_enter_email() {
		driver.findElement(By.id("email")).sendKeys("guy1@gmail.com");
	}
	@Given("^user enter phone$")
	public void user_enter_phone() {
		driver.findElement(By.id("phone")).sendKeys("123-456-7243");
	}
	@Given("^user enter message$")
	public void user_enter_message() {
		driver.findElement(By.id("message")).sendKeys("Thank you for your service, I have made great profit from my savings.");
	}
	@When("^presses button to Send To Customer Care$")
	public void presses_button_to_Send_To_Customer_Care() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")).click();
	}
	@Then("^message is successfully sent$")
	public void message_is_successfully_sent() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement TransferOverviewDisplay = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1[contains(text(), 'Customer Care')]"));
		Assert.assertEquals(true, TransferOverviewDisplay.isDisplayed());
	}
 
}
 