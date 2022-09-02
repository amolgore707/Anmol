package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_getDataFromTables {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String data;

	public OrangeHRM_getDataFromTables(String filePath) throws IOException {
		File f = new File(filePath);
		System.out.println(f.exists());
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}

	public String getDataFromSheet(int indexNumber, int row, int cell) {
		sheet = workbook.getSheetAt(indexNumber);
		data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		OrangeHRM_getDataFromTables obj = new OrangeHRM_getDataFromTables(
				"C:\\Users\\Dell\\OneDrive\\Desktop\\TestData.xlsx");
		
		
		String uname = obj.getDataFromSheet(1, 1, 0);
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		Thread.sleep(2000);
		String pass = obj.getDataFromSheet(1, 1, 1);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);

		String fname =obj.getDataFromSheet(1, 1, 2);
		driver.findElement(By.id("firstName")).sendKeys(fname);
		Thread.sleep(2000);

		String lname =obj.getDataFromSheet(1, 1, 3);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		Thread.sleep(2000);

		String empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		Thread.sleep(2000);

		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("ohrmList_chkSelectAll")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("dialogDeleteBtn")).click();
		Thread.sleep(5000);
		
		System.out.println("add Employee completed and delete also bye getting the data from table");

		driver.quit();
		
		
		
	}

}
