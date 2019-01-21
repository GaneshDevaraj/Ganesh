package utilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Listener implements ITestListener, ISuiteListener {
	protected static AndroidDriver<MobileElement> driver;
	 protected static ExtentReports reports;
	 protected static ExtentTest test;
	 
	@Override
	public void onStart(ISuite arg0) {
		
		System.out.println("on start");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		
	}
	@Override
	public void onFinish(ITestContext arg0) {
		// Do Nothing
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// Do Nothing
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("on test failure");
		  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test  Failed");
		  TakesScreenshot ts = (TakesScreenshot) BaseDriver.driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileHandler.copy(src, new File(System.getProperty("user.dir")+"\\src\\test\\resources" + result.getMethod().getMethodName() + ".png"));
		   String file = test.addScreenCapture("C:\\Images" + result.getMethod().getMethodName() + ".png");
		   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is Failed", file);
		   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is Failed", result.getThrowable().getMessage());
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		  test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " Test got Skipped");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		 test = reports.startTest(result.getMethod().getMethodName());
		 test.log(LogStatus.INFO, result.getMethod().getMethodName() + " Test has Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " Test has Passed");
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("on finish");
		 // driver.close();
		  reports.endTest(test);
		  reports.flush();
		
	}

	

}
