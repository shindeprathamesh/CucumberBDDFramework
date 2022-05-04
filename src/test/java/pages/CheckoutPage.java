package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage{

	
	protected WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		//wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath = "//input[@id='billing_first_name']")
	private WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='billing_last_name']")
	private WebElement txtLastName;
	
	//@FindBy(xpath = "(//span[@class='selection']/span)[1]")
	@FindBy(xpath = "//select[@id='billing_country']")
	private WebElement drpCountry;
	
	@FindBy(xpath = "//input[@id='billing_address_1']")
	private WebElement txtAddressLine1;
	
	@FindBy(xpath = "//input[@id='billing_city']")
	private WebElement txtCity;
	
	@FindBy(xpath = "//select[@id='billing_state']")
	private WebElement txtState;
	
	@FindBy(xpath = "//input[@id='billing_postcode']")
	private WebElement txtPostCode;
	
	@FindBy(xpath = "//input[@id='billing_email']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement placeOrderBtn;
	
	@FindBy(css = ".woocommerce-notice")
	private WebElement noticeText;
	
	public void enterFirstName(String firstName) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtFirstName));
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lasttName) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtLastName));
		txtLastName.clear();
		txtLastName.sendKeys(lasttName);
	}
	
	public void selectCountry(String country) {
		
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(drpCountry));
		Select select = new Select(drpCountry);
		select.selectByVisibleText(country);
		/*
		 * e.click(); By input = By.xpath("//input[@role='combobox']");
		 * driver.findElement(input).sendKeys(country);
		 */
	}
	
	public void enterAddress(String address) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtAddressLine1));
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(address);
	}
	
	public void enterCity(String city) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtCity));
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	public void selectState(String state) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtState));
		Select select = new Select(txtState);
		select.selectByVisibleText(state);
	}
	
	public void enterZip(String zipcode) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtPostCode));
		txtPostCode.clear();
		txtPostCode.sendKeys(zipcode);
	}
	
	public void enterEmail(String email) {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(txtEmail));
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void clickOnPlaceOrder() {
		//WebElement e = wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
		placeOrderBtn.click();
	}
	
	public String successfulCheckout() {
		//return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
		
		return noticeText.getText();
	}
	

}
