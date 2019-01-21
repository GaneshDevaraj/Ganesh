package pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class LoginRepo extends CommonMethods {

	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/home']")
	public WebElement hambergurmenuBar;

	@FindBy(xpath = "//*[@text='SIGN IN']")
	public WebElement signLnk;

	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/edit_text_username']")
	public WebElement userNameEdt;

	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/edit_text_password']")
	public WebElement passwordEdt;

	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/button_sign_in']")
	public WebElement signBtn;

//	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/progress_bar']")
//	public WebElement gifPrgBar;
	
	@FindBy(xpath = "//*[@class='android.widget.ProgressBar']")
	public WebElement gifPrgBar;
	
	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/button_google_deny']")
	public WebElement ignoreSavePwdBtn;

	public boolean login(String userName, String password) {
		boolean cond = false;
		hambergurmenuBar.click();
		signLnk.click();
		waitUntilElementisDisplayed(userNameEdt);
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		signBtn.click();
		if(ignoreSavePwdBtn.isDisplayed()) {
			 cond=true;
			ignoreSavePwdBtn.click();
		}
		return cond;
	}

}
