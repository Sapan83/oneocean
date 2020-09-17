package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
	private final By searchtext = By.xpath("//span[@class='a-color-state a-text-bold']");
	private final By dropdown = By.xpath("//span[@id='a-autoid-0-announce']");
	private final By product1 = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[2]/div[1]/span[1]/div[1]/div[1]/div[2]/h2[1]/a[1]/span[1]");
	private final By product2 = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]/div[1]/span[1]/div[1]/div[1]/div[2]/h2[1]/a[1]/span[1]");
	private final By button = By.xpath("//input[@id='add-to-cart-button']");

	public ProductPage(final WebDriver driver) {
		super(driver);
	}

	public String getText() throws Throwable {
		return getElementText(searchtext);
	}

	public void selectValueInDropDown(final String value) throws InterruptedException {
		getElementAndClick(dropdown);

		final List<WebElement> options = driver.findElements(By.xpath("//ul[@class='a-nostyle a-list-link']/li"));

		for (final WebElement option : options) {
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}

		}
	}

	public void selectToysAgeRange(final String text) throws InterruptedException {
		final List<WebElement> checkbox = driver.findElements(By.xpath("//span[contains(text(),'Years') or contains(text(),'Months')]"));
		final int count = checkbox.size();

		for (int i = 0; i < count; i++) {
			final WebElement webElement1 = checkbox.get(i);
			
			waitForVisibleElement(webElement1);
			
			final String val = webElement1.getText();

			if (val.equalsIgnoreCase(text)) {
				webElement1.click();
				break;
			}
		}
	}

	public void addToCart() {
		getElementAndClick(button);
	}

	public String selectProductOne() throws Throwable {
		final WebElement webElement = getElement(product1);
		final String text = webElement.getText();
		
		webElement.click();
		return text;
	}

	public String selectProductTwo() throws Throwable {
		final WebElement webElement = getElement(product2);
		final String text = webElement.getText();
		
		webElement.click();
		return text;
	}
}
