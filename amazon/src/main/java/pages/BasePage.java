package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected final WebDriver driver;
	private final WebDriverWait wait;

	public BasePage(final WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 1000);
	}

	protected void waitForElementToAppear(final By locator) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void getElementAndClick(final By locator) {
		final WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		element.click();
	}

	protected WebElement getElement(final By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void getElementAndEnterText(final By locator, final String text) throws Throwable {
		final WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		element.sendKeys(text);
	}

	protected String getElementText(final By locator) throws Throwable {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	protected void waitForTextAppear(final By locator, final String text) throws Throwable {
		wait.until(ExpectedConditions.textToBe(locator, text));
	}

	protected void waitForVisibleElement(final WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
