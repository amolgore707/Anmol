package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider {
	@Test(dataProvider = "testData")
	public  void set(String fname, String lname ,String email) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("reg_email__")).sendKeys(email);

	}
	@DataProvider(name="testData")
	public  Object[][] testdata() {
		
		Object [][] fbdata = new Object[3][3];
				fbdata[0][0]="Amol";
				fbdata[0][1]="Gore";
				fbdata[0][2]="amol@123";
				
				fbdata[1][0]="username2";
				fbdata[1][1]="523username36";
				fbdata[1][2]="username2@123";
				
				fbdata[2][0]="username3";
				fbdata[2][1]="username3122";
				fbdata[2][2]="username3@123";
				return fbdata;
	}

}
