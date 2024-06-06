package TestNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//implement ItestListener interface
public class ListenersDemo implements ITestListener {
	public void onTestStart(ITestResult result) {
		// not implemented
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("test ran succesfully");
	}

	
	public void onTestFailure(ITestResult result) {
		// not implemented
//		screenshot failure 
		System.out.println("test failed " + result.getName());
	}

	
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	
	public void onStart(ITestContext context) {
		// not implemented
	}

	
	public void onFinish(ITestContext context) {
		// not implemented
	}
}
