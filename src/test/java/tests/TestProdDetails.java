package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.ExcelUtils;

public class TestProdDetails extends Browser {

	@Test
	void Addtocart() throws InterruptedException, IOException {
		HomePage home = new HomePage(driver);
		SearchResultsPage resultPage = new SearchResultsPage(driver);
		List<Map<String, String>> testData = ExcelUtils.getTestData("Sheet1");
		for (Map<String, String> row : testData) {
			String item = row.get("ProductName");

			home.searchProduct(item);
			resultPage.openProdPage();
			resultPage.switchTab();
			List<WebElement> highlights = driver.findElements(By.xpath("//li[@class='_7eSDEz']"));
			Assert.assertTrue(!highlights.isEmpty());
			for (WebElement highlight : highlights) {
				System.out.println(highlight.getText());
			}
		}
	}

}
