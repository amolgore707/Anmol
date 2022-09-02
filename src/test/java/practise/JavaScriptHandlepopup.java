package practise;

import java.time.Duration;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptHandlepopup {
	WebDriver driver;
public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.firstcry.com/");
	WebElement wb = driver.findElement(By.xpath("//img[@src='https://cdn.fcglcdn.com/brainbees/images/cattemplate/sports_desktop_140122_78.jpg']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("argumemts[0].scrollIntoView(true);" , wb );
}
public static void main(String[] args) {
	JavaScriptHandlepopup obj = new JavaScriptHandlepopup();
	obj.setup();
}

}
