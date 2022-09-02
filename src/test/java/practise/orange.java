package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orange {
	WebDriver driver;
	
	@Test(priority = 1)
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	
	@Test(priority = 2)
	public void loginFuctionality()
	{
		System.out.println("Login functionality is started");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Login functionality is Ended");
	}
	
	@Test(priority = 3)
	public void validateHomePageLogo()
	{
		boolean actualLogo=driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		
//		SoftAssert soft = new SoftAssert();
		
		Assert.assertEquals(actualLogo, false);
		
		System.out.println("validateHomePageLogo is Ended");
	System.out.println("welcome");
//	soft.assertAll();
	}
	
	@Test(priority = 4)
	public void validateHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
					//or
//		Assert.assertEquals(driver.getTitle().contains("HRM"), true);
//				//or
//		Assert.assertEquals(driver.getTitle().endsWith("HRM"), true);
//				//or
//		Assert.assertEquals(driver.getTitle().equals("OrangeHRM"), true);
//				//or
//		Assert.assertEquals(driver.getTitle().equalsIgnoreCase("OrangeHRM"), true);
//				//or
//		Assert.assertEquals(driver.getTitle().startsWith("Orange"), true);
	}	
	
	@Test(priority = 5)
	public void validateAdminPage()
	{
		driver.findElement(By.xpath("//b[text()='Admin']")).click();
	
		SoftAssert soft = new SoftAssert();

		
		soft.assertEquals(driver.getCurrentUrl().contains("admin"), true);
		System.err.println("ended");
		soft.assertAll();
		
	}
}
