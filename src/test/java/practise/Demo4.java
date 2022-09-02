package practise;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Demo4 {
	@Test(priority = 0)
	public void setUpandLogin() {
		System.out.println("Before method");
	}

	@Test(priority = 1 ,enabled = false)
	public void homepage() {
		System.out.println("Home Page");
	}
	@Ignore
	@Test(priority = 2)
	public void pimpage() {
		System.out.println("PIM Page");
	}

	@Test(priority = 3)
	public void searchPIMUserpage() {
		System.out.println("Search PIM User");
	}

	@Test(priority = 4)
	public void tearDown() {
		System.out.println("After method");
}
}