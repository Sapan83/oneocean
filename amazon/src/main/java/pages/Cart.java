package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart extends BasePage {
	private final By cart = By.xpath("//a[@id='hlb-view-cart-announce']");
	private final By product_two_text = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold'][contains(text(),'Little Live Pets Cozy Dozy Pinki The Bear')]");
	private final By product_one_text = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold'][contains(text(),'Ty Beanie Baby March Aquamarine Birthstone Teddy')]");

	public Cart(final WebDriver driver) {
		super(driver);
	}

	public void OpenCart() {
		getElementAndClick(cart);
	}

	public void verifyItemsAdded(final String expectedProductOneText, final String expectedProductTwoText) throws Throwable {
		final String productoneactual = getElementText(product_one_text);
		final String producttwoactual = getElementText(product_two_text);

		Assert.assertEquals(productoneactual, expectedProductOneText);
		Assert.assertEquals(producttwoactual, expectedProductTwoText);
	}
}
