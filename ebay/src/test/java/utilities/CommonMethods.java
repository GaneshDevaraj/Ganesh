package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonMethods extends BaseDriver {

	public void selectDropDown(MobileElement elementName, String option) {
		Select Elements = new Select(elementName);
		Elements.selectByVisibleText(option);
	}

	public void waitUntilElementisDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public void waitUntilXpathisDisplayed(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	@SuppressWarnings("rawtypes")
	public void swipeUpUntilElementisDisplayed(WebElement element) {
		int counter = 1;
		int starty, endy, startx;
		Dimension size = driver.manage().window().getSize();
		while (!element.isDisplayed() & counter < 5) {
			starty = (int) (size.height * 0.50);
			endy = (int) (size.height * 0.20);
			startx = size.width / 2;
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(startx, endy)).release().perform();
			if (counter > 5) {
				break;
			}
			counter++;
		}
		counter = 1;
	}

	@SuppressWarnings("rawtypes")
	public void swipeDownUntilElementisDisplayed(WebElement element) {
		int counter = 1;
		int starty, endy, startx;
		Dimension size = driver.manage().window().getSize();
		while (!element.isDisplayed()) {
			starty = (int) (size.height * 0.50);
			endy = (int) (size.height * 0.20);
			startx = size.width / 2;
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startx, endy))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(startx, starty)).release().perform();
			if (counter > 5) {
				break;
			}
			counter++;
		}
		counter = 1;

	}

}
