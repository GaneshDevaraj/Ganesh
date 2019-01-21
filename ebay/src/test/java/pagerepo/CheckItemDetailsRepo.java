package pagerepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class CheckItemDetailsRepo extends CommonMethods {

	@FindBy(xpath = "//a[contains(text(), '65-inch')]")
	private WebElement inch65TvSelectLnk;

	@FindBy(xpath = "/child::*[@class='sf-prodlist-prodTitle']")
	private WebElement productTitleTxt;

	@FindBy(xpath = "/child::*[@class='sf-prodlist-rrp']/label[2]")
	private WebElement productPriceTxt;

	@FindBy(xpath = "/child::*[@class='btn sf-prodlist-viewDetailsbtn']")
	private WebElement BtnviewDetails;

	public void GetProductDetails() {
		String searchTitle;
		String searchPrice;
		try {
			initChromeDriver("http://www.reliancedigital.in");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		searchTitle = driver2
				.findElement(By.xpath("//div[@class='sf-prodlist-prodTitle' and contains(text(),'32 inch')]"))
				.getText();
		searchPrice = driver2.findElement(By.xpath(
				"//div[@class='sf-prodlist-prodTitle' and contains(text(),'32 inch')]/Parent::div[@class='sf-prodlist-priceDescription']/child::span[@class='sf-prodlist-rrp']/label[2]"))
				.getText();
		driver2.findElement(By.xpath(inch65TvSelectLnk + ("").trim() + BtnviewDetails)).click();


		driver2.findElement(By.xpath(
				"//div[@class='sf-prodlist-prodTitle' and contains(text(),'32 inch')]/child::button[@class='btn sf-prodlist-viewDetailsbtn']"))
				.click();
		
		System.out.println(searchTitle);
		System.out.println(searchPrice);

	}
}
