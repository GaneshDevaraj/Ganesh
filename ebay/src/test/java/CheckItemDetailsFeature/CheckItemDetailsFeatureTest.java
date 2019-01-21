package CheckItemDetailsFeature;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckItemDetailsFeatureTest {
	CheckItemDetailsFeaturePage checkItemDetailsPage;

	@BeforeMethod
	public void beforeTest() throws IOException, InterruptedException {

		checkItemDetailsPage = new CheckItemDetailsFeaturePage();

	}
	
	
	@Test
	public void ViewItemTest() throws IOException {
//		input=InputData.exl_inputs(this.getClass().getSimpleName(),
//			Thread.currentThread().getStackTrace()[1].getMethodName());
//		
		checkItemDetailsPage.GetProductDetails();
	}
}
