package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath = "//input[starts-with(@id,'quantity_')]")
	private WebElement productQuantity;

	@FindBy(xpath = "//td[@class = 'product-name']/a")
	private WebElement productName;
	
	@FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
	private WebElement proceedToCheckoutBtn;
	
	public String getProductName() {
		
		return productName.getText();
	}
	
	public int getProductQuantity() {
		
		return Integer.parseInt(productQuantity.getAttribute("value"));
	}
	
	public void checkout() {
		
		
		proceedToCheckoutBtn.click(); 
	}


}
