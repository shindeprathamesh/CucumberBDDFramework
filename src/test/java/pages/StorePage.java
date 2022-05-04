package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	
	public WebDriver driver;
	
	public StorePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath = "//a[@title='View cart']")
	private WebElement viewCartLink;
	
	@FindBy(xpath = "//a[@aria-label='Add “Blue Shoes” to your cart']")
	private WebElement addToCartBtn;

	
	public void addToCart(String productName) {
		
		addToCartBtn.click();
		viewCartLink.click();
		
	}

}
