package LoginFeature;

import org.openqa.selenium.support.PageFactory;

import SearchFeature.SearchFeaturePage;
import pagerepo.LoginRepo;

public class LoginFeaturePage extends LoginRepo {
	

	boolean login_success;
	LoginRepo loginrepo;

	public LoginFeaturePage() {
		loginrepo=PageFactory.initElements(driver, LoginRepo.class);  
	} 
	
	
	
	
	public SearchFeaturePage loginCredentails(String userName,String password) {
		
		login_success=loginrepo.login(userName,password);
		return new SearchFeaturePage();
		
	}

}
