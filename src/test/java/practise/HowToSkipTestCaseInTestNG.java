package practise;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class HowToSkipTestCaseInTestNG {
	
	@Test(priority = 1 , groups = {"first"} )
	public void a1() {
		System.out.println("a1 method in HowToSkipTestCaseInTestNG class ");
	}
	@Test(priority = 2 , groups = {"second"} )
	public void a2() {
		System.out.println("a2 method in HowToSkipTestCaseInTestNG class ");
	}
	@Test(priority = 3 ,groups = {"third"} , dependsOnGroups = {"seconds"} )
	public void a3() {
		System.out.println("a3 method in HowToSkipTestCaseInTestNG class ");
	}
	@Ignore
	public void a4() {
		System.out.println("a4 method in HowToSkipTestCaseInTestNG class ");
	}
	@Test(priority = 5 , groups = {"third"} )
	public void a5() {
		System.out.println("a5 method in HowToSkipTestCaseInTestNG class ");
	}
	@Test(priority = 6 , groups = {"fourth"} , dependsOnGroups = {"third"})
	public void a6() {
		System.out.println("a6 method in HowToSkipTestCaseInTestNG class ");
	}
	
	@Test(priority = 7 , groups = {"fifth"} , dependsOnGroups = {"fourth"})
	public void a7() {
		System.out.println("a7 method in HowToSkipTestCaseInTestNG class ");
	}
	@Test(priority = 8 , groups = {"sixth"} , dependsOnGroups = {"fifth"} , alwaysRun = true)
	public void a8() {
		System.out.println("a8 method in HowToSkipTestCaseInTestNG class ");
	}
}
