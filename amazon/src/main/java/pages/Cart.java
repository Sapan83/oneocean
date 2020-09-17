package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart extends BasePage {
	private final By cart = By.xpath("//a[@id='hlb-view-cart-announce']");
    	private final By product_one = By.xpath("//div[@data-asin='B000F8EW6U']/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/ul/li[1]/span[1]/a[1]/span[1]");
	private final By product_two = By.xpath("//div[@data-asin='B07NSSGPLJ']/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/ul/li[1]/span[1]/a[1]/span[1]");
	
	public Cart(final WebDriver driver) {
		super(driver);
	}

	public void OpenCart() {
		getElementAndClick(cart);
	}

	public void verifyItemsAdded(final String expectedProductOneText, final String expectedProductTwoText) throws Throwable {
		final String actualTextFirst = getElementText(product_one);
		final String actualTextTwo = getElementText(product_two);
		
		Assert.assertEquals(actualTextFirst, expectedProductOneText);
		Assert.assertEquals(actualTextTwo , expectedProductTwoText);
	}
}
