package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties property;

	public TestBase() {
		property = new Properties();

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/Config/Property.properties");
			try {
				property.load(file);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	// Launching Browser and navigating to URL
	public static void initBrowserAndGotoUrl(String URL) {

		String BrwserName = property.getProperty("BrowserName");

		if (BrwserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get(URL);
	}

}
