package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Cart;
import pages.Homepage;
import pages.ProductPage;
import utility.HelperClass;

public class TestStepDefinition extends HelperClass {
	private String productOneText;
	private String productTwoText;

	@Given("^initialize the browser with Chrome$")
	public void initialize_the_browser_with_Chrome() throws Throwable {
		setup();
	}

	@Given("^user should navigate to www\\.amazon\\.com$")
	public void that_user_should_navigate_to_www_amazon_com() throws Throwable {
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^user enter in search \"([^\"]*)\"$")
	public void user_enter_in_search(String arg1) throws Throwable {
		final Homepage search = new Homepage(driver);
		
		search.clickOnSearchbox();
		search.enterText(arg1);
	}

	@When("^selects \"([^\"]*)\" in the list$")
	public void selects_in_the_list(String arg1) throws Throwable {
		final Homepage search = new Homepage(driver);
		
		search.selectValueInSearch(arg1);
	}

	@Then("^user must be redirected to Products Detail Page$")
	public void user_must_be_redirected_to_Products_Detail_Page() throws Throwable {
		final ProductPage productpage = new ProductPage(driver);
		final String actualtext = productpage.getText();
		final String expectedtext = "\"teddy bear\"";
		
		Assert.assertEquals(expectedtext, actualtext);
	}

	@Then("^user sorts Product according to \"([^\"]*)\"$")
	public void user_sorts_Product_according_to(String arg1) throws Throwable {
		final ProductPage productpage = new ProductPage(driver);
		
		productpage.selectValueInDropDown(arg1);
	}

	@Then("^user selects the Age range between \"([^\"]*)\"$")
	public void user_selects_the_Age_range_between(String arg1) throws Throwable {
		final ProductPage productpage = new ProductPage(driver);
		
		productpage.selectToysAgeRange(arg1);
	}

	@When("^user adds Product in his cart$")
	public void user_adds_Product_in_his_cart() throws Throwable {
		final ProductPage pp = new ProductPage(driver);
		
		productOneText = pp.selectProductOne();
		pp.addToCart();
		navigateBack();
		navigateBack();
		productTwoText = pp.selectProductTwo();
		pp.addToCart();
	}

	@Then("^user must be redirected to on Cart Page$")
	public void user_must_be_redirected_to_on_Cart_Page() throws Throwable {
		final Cart cart = new Cart(driver);
		
		cart.OpenCart();
	}

	@Then("^user must see two products in the cart$")
	public void user_must_see_two_products_in_the_cart() throws Throwable {
		final Cart cart = new Cart(driver);
		
		cart.verifyItemsAdded(productOneText, productTwoText);
		tearDown();
	}
}
