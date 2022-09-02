package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenTheBroserByParameter {
	WebDriver driver;
	@Parameters("Browser")
	@BeforeClass
	public void setup(String Browser )  {
		if(Browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else
		{
			System.out.println("please enter valid browser name");
		}	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/reg");

		
	}
	
	@Test(priority = 1)
	public void validateTitleOfBrowsr() {
		String actualtitle =driver.getTitle();
		Assert.assertEquals(actualtitle.contains("Facebook"), true);
	
	}
	@Test(priority = 2)
	public void validateurlOfBrowsr() {
		String actualurl =driver.getCurrentUrl();
		Assert.assertEquals(actualurl.contains("facebook"), true);
	}
	@Parameters({"fname" , "lname"})
	@Test(priority = 3)
	public void enterDetails(String fname , String lname) {
	driver.findElement(By.name("firstname")).sendKeys(fname);
	driver.findElement(By.name("lastname")).sendKeys(lname);
	}
}
		


	


