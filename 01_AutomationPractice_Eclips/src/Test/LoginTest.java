package Test;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import pom.BaseClass;
import pom.HomePage;
import pom.LoginPage;
public class LoginTest extends BaseClass{
	//WebDriver driver;

	

	@Test(priority = 1)
	public void checkEmptyPassword() {

		String userName = "test@gmail.com";
		String password = "";

		HomePage HP = new HomePage();
		HP.clickOnSignin();

		LoginPage LP = new LoginPage();
		LP.Login(userName, password);

		String emptyPasswordErrorMessage = LP.getErrorMessage();
		assertEquals(emptyPasswordErrorMessage, "Password is required.");

	}

	@Test(priority = 2)
	public void checkWrongPassword() {
		String userName = "test@gmail.com";
		String password = "testpassword";

		HomePage HP = new HomePage();
		HP.clickOnSignin();

		LoginPage LP = new LoginPage();
		LP.Login(userName, password);

		String wrongPasswordErrorMessage = LP.getErrorMessage();
		assertEquals(wrongPasswordErrorMessage, "Authentication failed.");

	}

	@Test(priority = 3)
	public void checkExistingEmail() throws InterruptedException {
		String email = "test@gmail.com";
		LoginPage LP = new LoginPage();
		LP.CheckExistingAccount(email);

		String existingEmailMessage = LP.getExistanceAccountErrorMessage();
		assertEquals(existingEmailMessage,
				"An account using this email address has already been registered. Please enter a valid password or request a new one.");
	}

	

}




