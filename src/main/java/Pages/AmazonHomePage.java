package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class AmazonHomePage extends TestBase {

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement SearchBox;

	public AmazonHomePage() {

		PageFactory.initElements(driver, this);
	}

	public WebElement Amazon_ClickInputBoxAndSearchEntryGetPrice(String Entry) throws Exception {

		Actions action = new Actions(driver);
		action.moveToElement(SearchBox).click().sendKeys(Entry).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		WebElement ProductName = driver.findElement(By.xpath(
				"//*[@id='search']/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));

		System.out.println(ProductName.getText());
		WebElement Price = driver.findElement(By.xpath(
				"//*[@id='search']/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]"));

		return Price;

	}

}
