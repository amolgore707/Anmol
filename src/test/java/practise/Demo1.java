package practise;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Demo1 {
	
	@BeforeClass 
	public void First() {
		System.err.println("Before class");
	}
	@Test(priority = 1 , groups = "low")
	public void setup() {
		System.out.println("BeforeMethod print ");
	}
	@Test(priority = 2 , groups = "low1")
	public void login() {
	Assert.assertEquals(true, false);	}
	
	@Test(priority = 3 , groups = "medium")
	public void search() {
		System.out.println("Search");
	}
	
	@Test(priority = 4 , groups = "high"  )
	public void pim() {
		System.out.println("pim");
	}
	@Test(priority = 5 , groups = "superhigh" ,invocationCount = 5 )
	public void addEmploye() {
		System.out.println("addEmploye");
	}
	@AfterClass
	public void End() {
		System.out.println("AfterMethid print");
	}

	
}