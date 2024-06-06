import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		broken link means broken url 404
//		we can call urls from java methods and check status codes 
//		'a[href*="soapui"]'
//		String url = driver.findElement(By.cssSelector("a[href*=\'brokenlink\']")).getAttribute("href");
//		HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
//		connection.setRequestMethod("HEAD");
//		connection.connect();
//		int responseCode = connection.getResponseCode();
//		System.out.println(responseCode);
		
//		iterate every link in footer and find broken ones
		List<WebElement> footerLinks =  driver.findElements(By.cssSelector(".gf-li a"));
//		soft assertion
		SoftAssert soft = new SoftAssert();
		
		for(WebElement link: footerLinks) {
			String url = link.getAttribute("href");	
			HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			soft.assertTrue(responseCode < 400, "link with text " + link.getText() + " is broken " + responseCode);
//			if(responseCode > 400) {
//				System.out.println("link with text " + link.getText() + " is broken " + responseCode);
////				hard assertion
//				Assert.assertTrue(false);
//			}
		}
		
//		report all failures
		soft.assertAll();
		
	}

}
