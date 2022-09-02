package practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo3b {

	@BeforeClass
	public void setUp() {
		System.out.println("Before Class");// 1
	}

	@Test(priority = 1)
	public void homepage() {
		System.out.println("Home Page");// 2
	}

	@Test(priority = 2)
	public void PIMUserCreatepage() {
		System.out.println("PIMUserCreatepage");// 3
	}

	@Test(priority = 3)
	public void Searchuser() {
		System.out.println("Search PIM Use");// 4
	}

	@AfterClass
	public void tearDown() {
		System.out.println("after Class");// 5
}
}