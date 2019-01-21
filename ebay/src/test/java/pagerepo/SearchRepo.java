package pagerepo;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonMethods;

public class SearchRepo extends CommonMethods {

	@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/search_box']")
	private WebElement searchEdt;

	
	public void searchItem(String itemName) {
		searchEdt.sendKeys(itemName + "\n");
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swipeUpUntilElementisDisplayed(driver.findElement(By.xpath("//*[@text='www.reliancedigital.in/']")));
		driver.findElement(By.xpath("//*[@text='www.reliancedigital.in/']")).click();
		try {
			initChromeDriver("www.reliancedigital.in");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		Set<String> contextnames = driver.getContextHandles();
//		for (String contextName : contextnames) {
//			System.out.println(contextName);
//		}

	}
}
