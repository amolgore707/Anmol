package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo7practice {

	WebDriver driver;
	
	@Test(priority=1 , groups = {"login"})
	public void setUp()				
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	
	@Test(priority=2 , groups = {"login"})
	public void loginFunctionality() {				
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	
	}
	
	@Test(priority=3 , groups = {"homePage"})
	public void validateHomePageLogo()			
	{
		boolean actualLogo =driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		Assert.assertEquals(actualLogo, true);
		
	}
	
	@Test(priority=4 ,groups =  {"homePage"})
	public void validateHomePageTitle()			
	{
		String actualTitle =driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority=5 , groups = {"pimPage"})
	public void validatePimPage() {			
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		String actualpimurl =driver.getCurrentUrl();
		Assert.assertEquals(actualpimurl.contains("pim"), true);
	}
	@Test(priority = 6 , groups = {"end"})
	public void end() {
		System.out.println("end or close the OrangeHRM");
		
	}

	
}