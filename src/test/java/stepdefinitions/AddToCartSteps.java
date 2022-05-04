package stepdefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.MyHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.StorePage;
import testbase.TestBase;

public class AddToCartSteps extends TestBase{
	
	static WebDriver driver;
	private StorePage storePage;
	private CartPage cartPage;
	
	
	@Given("User is on the Store Page")
	public void user_is_on_the_store_page() {
		
		driver  = MyHooks.getDriver();
		driver.get(config.getURL());
		
	}

	@When("User adds a {string} to the cart")
	public void user_adds_a_to_the_cart(String string) {
		storePage = new StorePage(driver);
		storePage.addToCart(string);
	}

	@Then("User should see {int} {string} in the cart")
	public void user_should_see_in_the_cart(int quantity, String productName) {
		cartPage = new CartPage(driver);
		Assert.assertEquals(quantity, cartPage.getProductQuantity());
		Assert.assertEquals(productName, cartPage.getProductName());
		Assert.fail();
		
	}

}
