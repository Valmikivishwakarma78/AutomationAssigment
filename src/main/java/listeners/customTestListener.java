package listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;
import utilities.CommonUtils;

public class customTestListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
/*		Date date = new Date();
		String name=date.toString().replace(" ", "_").replace(":", "_");
		String methodName = result.getMethod().getMethodName()+"_"+name;
		CommonUtils.getScreenshot(methodName, driver); */

		}
	

	@Override
	public void onTestFailure(ITestResult result) {
		Date date = new Date();
		String name=date.toString().replace(" ", "_").replace(":", "_");
		String methodName = result.getMethod().getMethodName()+"_"+name;
		CommonUtils.getScreenshot(methodName, driver);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {

	}
}
