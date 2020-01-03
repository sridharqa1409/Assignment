package Pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.TestBase;

public class TripAdvisorLocationPage extends TestBase {


	@FindBy(xpath = "//div[@class='hotels-community-content-common-ContextualCTA__currentOption--3Wd5D']//a")
	WebElement WriteReviewbtn;

	public TripAdvisorLocationPage() {

		PageFactory.initElements(driver, this);

	}

	public WebElement ClickOnReview() throws Exception {

		Set<String> allwindows = driver.getWindowHandles();
		for (String str : allwindows) {

			driver.switchTo().window(str);

			Thread.sleep(2000);
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");

		WriteReviewbtn.click();
		Thread.sleep(2000);
		return WriteReviewbtn;

	}

}
