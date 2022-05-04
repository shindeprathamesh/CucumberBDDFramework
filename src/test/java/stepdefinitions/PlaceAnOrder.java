package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.MyHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;
import testbase.TestBase;

public class PlaceAnOrder extends TestBase{
	
	private WebDriver driver;
	private StorePage storePage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	
	@Given("I am a guest customer")
	public void i_am_a_guest_customer() {
	   
		driver =  MyHooks.getDriver();
		storePage = new StorePage(driver);
		driver.get(config.getURL());
		
	}

	@Given("I have a product in the cart")
	public void i_have_a_product_in_the_cart() {
		storePage.addToCart("Blue Shoes");
		
	}

	@Given("I am on the checkout page")
	public void i_am_on_the_checkout_page() {
		cartPage = new CartPage(driver);
		cartPage.checkout();
	}

	@When("I provide billing details")
	public void i_provide_billing_details(DataTable data) throws InterruptedException {
		
		checkoutPage= new CheckoutPage(driver);
		List<Map<String, String>> billingDetails = data.asMaps(String.class, String.class);
		checkoutPage.enterFirstName(billingDetails.get(0).get("firstname"));
		checkoutPage.enterLastName(billingDetails.get(0).get("lastname"));
		checkoutPage.selectCountry(billingDetails.get(0).get("country"));
		checkoutPage.enterAddress(billingDetails.get(0).get("address_line1"));
		checkoutPage.enterCity(billingDetails.get(0).get("city"));
		checkoutPage.selectState(billingDetails.get(0).get("state"));
		checkoutPage.enterZip(billingDetails.get(0).get("zip"));
		checkoutPage.enterEmail(billingDetails.get(0).get("email"));
		
		
		
	}

	@When("I place an order")
	public void i_place_an_order() {
		checkoutPage.clickOnPlaceOrder();
	}

	@Then("The order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
	   String expectedMessage = "Thank you. Your order has been received.";
	   Assert.assertEquals(expectedMessage, checkoutPage.successfulCheckout() );
	}


}
