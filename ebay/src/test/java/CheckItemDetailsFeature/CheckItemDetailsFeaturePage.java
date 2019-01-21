package CheckItemDetailsFeature;

import org.openqa.selenium.support.PageFactory;
import pagerepo.CheckItemDetailsRepo;


public class CheckItemDetailsFeaturePage extends CheckItemDetailsRepo {

	CheckItemDetailsRepo checkDetailsRepo;

	public CheckItemDetailsFeaturePage() {
		checkDetailsRepo = PageFactory.initElements(driver2, CheckItemDetailsRepo.class);
	}

	public CheckItemDetailsFeaturePage VerifyPriceDetails(String itemName) {

		GetProductDetails();
		return this;

	}

}