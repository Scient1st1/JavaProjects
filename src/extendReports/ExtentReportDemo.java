package extendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports ex;
	
	@BeforeTest
	public void config() {
		//ExtentReports, ExtentSparkReporter
		String dir = System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter exSpark = new ExtentSparkReporter(dir);
		exSpark.config().setReportName("WebAutomationREsults");
		exSpark.config().setDocumentTitle("Test Results");
		//attach sparkreporter to extendreports main class
		ex = new ExtentReports();	
		ex.attachReporter(exSpark);
		ex.setSystemInfo("TEster", "me");
	}
	
	@Test
	public void demo() {
		ExtentTest test = ex.createTest("First Test Report");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		String title = driver.getTitle();
		System.out.println(title);
//		test.addScreenCaptureFromBase64String(title);
		driver.quit();
		test.fail("something wrong");
		ex.flush();
	}
}
