package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo3 {
	WebDriver driver;
	@Test
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	@Test(priority=2)
	public void loginFunctionality() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test(priority=3)
	public void verifyTitle() {
String actualTitle=		driver.getTitle();
Assert.assertEquals(actualTitle,"OrangeHRM");
	}
	
	@Test(priority=4)
		public void tearDown() {
			driver.quit();
		}
	}
	


