package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMEdge {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(priority = 1)
	public void validateHomePagetitle() {
		String actualTitle = driver.getTitle();
//		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle.contains("OrangeHRM"), true);
	}

	@Test(priority = 2)
	public void validateUrl() {
		Assert.assertEquals(driver.getCurrentUrl().contains("hrm"), true);
	}

	@Test(priority = 3)
	public void validateHomePagelogo() {
		boolean actualLogo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		Assert.assertEquals(actualLogo, true);
	}

	@Test(priority = 4)
	public void validateUserIsOnPIMPage() {
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		boolean actualPim = driver.getCurrentUrl().contains("pim");
		Assert.assertEquals(actualPim, true);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
