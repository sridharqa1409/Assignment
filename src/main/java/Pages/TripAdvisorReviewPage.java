package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import TestBase.TestBase;

public class TripAdvisorReviewPage extends TestBase {
	
	@FindBy(xpath = "//span[@id='bubble_rating']")
	WebElement bubbleRating;
	
	@FindBy(xpath = "//div[@id='ratingFlag']//em")
	WebElement BubbleratingFlag;
	
	@FindBy(xpath = "//div[@id='AMENITY_RATING_BUBBLE_TEXT_qid12']")
	WebElement ServiceratingFlag;
	
	@FindBy(xpath = "//input[@id='ReviewTitle']")
	WebElement TitleOfReview;

	@FindBy(xpath = "//textarea[@name='ReviewText']")
	WebElement ReviewText;

	@FindBy(xpath = "//div[@id='trip_type_table']//div[@data-category='Business']")
	WebElement triptype;
	
	@FindBy(xpath = "//select[@name='trip_date_month_year']")
	WebElement tripMonth;
	
	@FindBy(xpath = "//div[@id='FRAUD_LABEL_FLY']")
	WebElement ReviewCheckBox;
	
	
	@FindBy(xpath = "//div[@id='SUBMIT']")
	WebElement SubmitBtn;
	
	
	
	public TripAdvisorReviewPage() {

		PageFactory.initElements(driver, this);

	}

	public WebElement MouseOverTheBubbles(String selector) throws Exception {

		Set<String> allwindow = driver.getWindowHandles();
		for (String strg : allwindow) {

			driver.switchTo().window(strg);
		}
		
		WebElement ele =driver.findElement(By.cssSelector(selector));	
		
	    Actions action2 =new Actions(driver);
	    
	    action2.moveToElement(ele).moveByOffset(32, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(32, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(32, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(32, 0).click();
	    Thread.sleep(2000);
	    action2.click().build().perform();
	   	return BubbleratingFlag;

	}

	public WebElement MouseOverToHotelServicebubbles(String selector) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		WebElement ele =driver.findElement(By.cssSelector(selector));	
		
	    Actions action2 =new Actions(driver);
	    action2.moveToElement(ele).moveByOffset(24, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(24, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(24, 0).click();
	    Thread.sleep(2000);
	    action2.moveByOffset(24, 0).click();
	    Thread.sleep(2000);
	    action2.click().build().perform();
	    return ServiceratingFlag;

	}
	
		
	public WebElement FillReviewDetails() {
		
		TitleOfReview.sendKeys("Welcome to india");
		ReviewText.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb+"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh+"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh+"
				+ "hhdddddddddddddddddddddddddddddddddddddddddddddddddddddddd+"
				+ "dddhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh+"
				+ "shhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		triptype.click();
		
		Select select =new Select(tripMonth);
		select.selectByValue("1,2020");
		
		ReviewCheckBox.click();
		SubmitBtn.click();
		
		driver.switchTo().frame("overlayRegFrame");

		WebElement ele=driver.findElement(By.xpath("//div[@id='googleSignIn']//span[@class='textContainer']"));
						
		return ele;
			
	}
	
}
