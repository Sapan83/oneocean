package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {
	private final By searchbox = By.xpath("//input[@id='twotabsearchtextbox']");

	public Homepage(final WebDriver driver) {
		super(driver);
	}

	public void clickOnSearchbox() {
		getElementAndClick(searchbox);
	}

	public void enterText(final String text) throws Throwable {
		getElementAndEnterText(searchbox, text);
	}

	public void selectValueInSearch(final String value) {
		final List<WebElement> options = driver.findElements(By.xpath("//div[@id='suggestions'] /div"));

		for (final WebElement option : options) {
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}
		}
	}
}
