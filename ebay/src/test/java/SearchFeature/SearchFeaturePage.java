package SearchFeature;

import org.openqa.selenium.support.PageFactory;
import pagerepo.SearchRepo;

public class SearchFeaturePage extends SearchRepo {

	SearchRepo searchRepo;

	public SearchFeaturePage() {
		searchRepo=PageFactory.initElements(driver, SearchRepo.class);
	}

	public SearchFeaturePage SearchItems(String itemName) {

		searchRepo.searchItem(itemName);
		return this;

	}

}
