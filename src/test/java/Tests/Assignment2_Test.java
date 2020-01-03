package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.TripAdvisorHomePage;
import Pages.TripAdvisorLocationPage;
import Pages.TripAdvisorReviewPage;
import TestBase.TestBase;

public class Assignment2_Test extends TestBase {

	TripAdvisorHomePage tripHomePage;
	TripAdvisorLocationPage tripadvisorlocationpage;
	TripAdvisorReviewPage tripAdvisorReviewPage;
	WebElement ele = null;

	@BeforeClass
	public void SetUp() {

		// initBrowserAndGotoUrl(TestData.TestData.TripadvisorUlr);
		initBrowserAndGotoUrl(TestData.TestData.TripadvisorUlr);
		tripHomePage = new TripAdvisorHomePage();
		tripadvisorlocationpage = new TripAdvisorLocationPage();
		tripAdvisorReviewPage = new TripAdvisorReviewPage();
	}

	@Test(priority=1)
	public void SearchTheLocation() throws Exception {
		
		WebElement ele=tripHomePage.LocationSearch(TestData.TestData.location);
		String Entry=ele.getText();
		System.out.println(Entry);
		Assert.assertTrue(Entry.startsWith(TestData.TestData.location));
		
	}
	
	@Test(priority=2)
	public void ClickOnReviewTest() throws Exception {
		
		WebElement ele =tripadvisorlocationpage.ClickOnReview();
		Assert.assertEquals(ele.getText(), TestData.TestData.ReviewButton);
		
	}

	@Test(priority = 3)
	public void MouseOverBubblesTest() throws Exception {

		WebElement ele = tripAdvisorReviewPage.MouseOverTheBubbles("#bubble_rating");
		System.out.println(ele.getText());
		Assert.assertEquals(ele.getText(), "Excellent");

	}

	@Test(priority = 4)
	public void HotelServiceratingTest() throws Exception {

		WebElement ele = tripAdvisorReviewPage.MouseOverToHotelServicebubbles("#qid12_bubbles");
		System.out.println(ele.getText());
		Assert.assertEquals(ele.getText(), "Excellent");

	}

	@Test(priority = 5)
	public void FillReviewDetailsTest() {

		WebElement ele = tripAdvisorReviewPage.FillReviewDetails();
        Assert.assertEquals(ele.getText(), "Continue with Google");
	}

	@AfterClass
	public void teardown() {

		
		driver.quit();
		driver=null;

	}

}
