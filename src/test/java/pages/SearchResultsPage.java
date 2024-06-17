package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	WebDriver driver;
	WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	public String getSearchResultText() {
		WebElement resultElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='KzDlHZ']")));
		return resultElement.getText();
	}

	public boolean isResultVisible() {
		try {
			@SuppressWarnings("unused")
			WebElement resultElement = driver.findElement(By.xpath("//div[@class='KzDlHZ']"));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void filterPriceToLowest() {
		WebElement upperLimitButton = driver.findElement(By.xpath("(//select[@class='Gn+jFg'])[2]"));
		upperLimitButton.click();
		WebElement dropdownValue10k = driver.findElement(By.xpath("(//option[@value='10000'])[2]"));
		dropdownValue10k.click();

	}

	public boolean isNoResultsWarningDisplayed() {
		try {
			WebElement noResultWarning = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sorry, no results found!')]")));

			return noResultWarning.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void setStorageTo256() throws InterruptedException {
		WebElement internalStorageFilter = driver.findElement(By.xpath("//div[contains(text(),'Internal Storage')]"));
		internalStorageFilter.click();
		WebElement checkBox256GB = driver
				.findElement(By.xpath("//div[@class='ewzVkT _3DvUAf' and @title='256 GB & Above']"));
		checkBox256GB.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='YcSYyC']")));
	}

	public boolean checkStorage256(String title) {
		System.out.println(title);
		return title.contains("256");
	}

	public void openProdPage() {
		WebElement resultElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='KzDlHZ']")));

		resultElement.click();
	}

	public void switchTab() {

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
	}

	public void compareProducts() {

		WebElement compareCheckbox1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[15]/..")));
		WebElement compareCheckbox2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[16]/..")));

		compareCheckbox1.click();
		compareCheckbox2.click();

		WebElement compareButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()=\"COMPARE\"]/..")));
		compareButton.click();

	}

	public boolean isCompared() {

		try {
			WebElement compareMessage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(), 'Compare')]")));
			return compareMessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}
}
