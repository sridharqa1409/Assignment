package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class FlipkartHomePage extends TestBase {

	@FindBy(xpath="//input[@name='q' and @title='Search for products, brands and more']")
	WebElement SearchBox;
	
	
	public FlipkartHomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
public WebElement Flipkart_ClickInputBoxAndSearchEntryGetPrice(String Entry) throws Exception {
		
		Actions action =new Actions(driver);
		action.moveToElement(SearchBox).click().sendKeys(Entry).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		WebElement ProductName=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));
		
        System.out.println(ProductName.getText());
	    WebElement Price =driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div/div/div[1]"));
			
		return Price;
	
		
	}
	
	
}
