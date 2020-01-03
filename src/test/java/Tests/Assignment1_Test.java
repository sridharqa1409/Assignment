package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AmazonHomePage;
import Pages.FlipkartHomePage;
import TestBase.TestBase;

public class Assignment1_Test extends TestBase {

	AmazonHomePage amazonPage;
	FlipkartHomePage flipkartPage;
	int AmzPrice;
	int FlrtPrice;
	WebElement ele = null;

	@BeforeClass
	public void SetUp() {

		initBrowserAndGotoUrl(TestData.TestData.amazonUrl);
		amazonPage = new AmazonHomePage();
		flipkartPage = new FlipkartHomePage();

	}

	
	@Test(priority=1)
	public void SearchProductInAmazonTest() throws Exception {

		WebElement amazonPrice = amazonPage.Amazon_ClickInputBoxAndSearchEntryGetPrice(TestData.TestData.ProductName);
		String price1 = amazonPrice.getText().replaceAll("[^0-9]", "");
		System.out.println(price1);
		AmzPrice = Integer.parseInt(price1);

	}

	
	@Test(priority = 2)
	public void NavigateToFlipkart() {

		driver.get(TestData.TestData.FlipkartUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@class='_3Njdz7']//button[@class='_2AkmmA _29YdH8']"))));
		driver.findElement(By.xpath("//div[@class='_3Njdz7']//button[@class='_2AkmmA _29YdH8']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), TestData.TestData.FlipkartUrl);
		
	}

	
	@Test(priority = 3)
	public void SearchProductTestInFlipCartTest() throws Exception {
		WebElement FlipkartPrice = flipkartPage.Flipkart_ClickInputBoxAndSearchEntryGetPrice(TestData.TestData.ProductName);
		String price2 = FlipkartPrice.getText().replaceAll("[^0-9]", "");
		System.out.println(price2);
		FlrtPrice = Integer.parseInt(price2);		

	}
	
	@Test(priority=4)
	public void CompareBothPrices() {
		if (AmzPrice < FlrtPrice) {

			System.out.println("The price of product in amazon has lesser value");

		} else if (AmzPrice > FlrtPrice) {

			System.out.println("The price of product in FlipKart has lesser value");

		} else {

			System.out.println("The prices of product are same in both websites ");

		}

    }
	
	@AfterClass
	public void teardown() {
        
		driver.quit();
		driver=null;

	}

}