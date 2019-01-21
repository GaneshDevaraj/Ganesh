package utilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {
	public static AndroidDriver<MobileElement> driver;
	public static AndroidDriver<MobileElement> driver2;
	
	@Parameters({ "platformName" })
	@BeforeSuite(alwaysRun = true)
	public void initDriver(String platformName) throws IOException, InterruptedException {

		if (platformName.equals("android")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("platformversion", "8.0");
			capabilities.setCapability("deviceName", GetConnectedDevices.GetDevices("android").get(0));
			capabilities.setCapability("app",
					System.getProperty("user.dir") + "\\src\\test\\resources\\appfiles\\Android\\eBay.apk");
			capabilities.setCapability("appPackage", "com.ebay.mobile");
			capabilities.setCapability("AutomationName", "uiautomator2");
			capabilities.setCapability("newCommandTimeout", 0);
			capabilities.setCapability("setWebContentsDebuggingEnabled", "true");
			capabilities.setCapability("chromeBundleId", "com.android.chrome");
			capabilities.setCapability("androidPackage", "com.android.chrome");

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		}

		else if (platformName.equals("ios")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platform", "ios");
			try {
				capabilities.setCapability("udid", GetConnectedDevices.GetDevices("ios").get(0));
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			capabilities.setCapability("app", "");
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("AppiumVersion", "1.6.2");
			capabilities.setCapability("AutomationName", "");
		}

	}

	public void initChromeDriver(String url) throws IOException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformversion", "8.0");
		capabilities.setCapability("deviceName", GetConnectedDevices.GetDevices("android").get(0));
		capabilities.setCapability("AutomationName", "uiautomator2");
		capabilities.setCapability("newCommandTimeout", 0);
		capabilities.setCapability("browser", "Chrome");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver2 = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver2.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver2.get(url);

	}

}
