package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo3a {
	@Test(priority = 1)
	public void loginFunctionality() {
		Assert.assertEquals("login", "login");
	}

	@Test(dependsOnMethods = { "loginFunctionality"},priority=-100)
	public void homeFunctionality() {
		System.out.println("home functionality");
	}

	@Test(priority = 1)
	public void pimFunctionality() {
		System.out.println("PIM functionality");
	}

	@Test(priority = 1)
	public void logoutFunctionality() {
		System.out.println("Log out functionality");
}
}