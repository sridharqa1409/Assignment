package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.TestBase;

public class TripAdvisorHomePage extends TestBase {

	@FindBy(xpath = "//span[@class='brand-global-nav-action-search-Search__label--3PRUD']")
	WebElement SearchBox1;

	@FindBy(xpath = "//div[@class='what_with_highlight']//input[@id='mainSearch']")
	WebElement MainSearch;

	@FindBy(xpath = "//div[@class='location-meta-block']//div[@class='result-title']//span")
	WebElement FirstResult;

	
	public TripAdvisorHomePage() {

		PageFactory.initElements(driver, this);

	}

	
	public WebElement LocationSearch(String location) throws Exception{
		SearchBox1.click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(MainSearch).click().sendKeys(location).sendKeys(Keys.ENTER).build().perform();
		FirstResult.click();
		System.out.println(driver.getTitle());
		return FirstResult;
	}

}
