package LoginFeature;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedHashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SearchFeature.SearchFeaturePage;
import utilities.InputData;

public class LoginFeatureTest extends LoginFeaturePage {

	LoginFeaturePage loginFeaturePage;
	SearchFeaturePage searchFeaturePage;
	InputData inputData;
	LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();

	@BeforeMethod
	public void beforeTest() throws IOException, InterruptedException {
		loginFeaturePage = new LoginFeaturePage();
		searchFeaturePage = new SearchFeaturePage();
	}

	@Test
	public void loginTest() throws IOException {
		
//method call happend to get the test data input from excel and return type of it is a Map
//class name is sheet Name, Method name is row name
		
		input = InputData.exl_inputs(this.getClass().getSimpleName(),
				Thread.currentThread().getStackTrace()[1].getMethodName());

//Chaining logic is used to connect between the methods
		loginFeaturePage.loginCredentails(input.get("userName"), input.get("password"))
						.SearchItems(input.get("searchitem"));
		
		assertTrue(loginFeaturePage.login_success);
	}

}
