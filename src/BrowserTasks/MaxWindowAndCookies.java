package BrowserTasks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWindowAndCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
//		maximize
		driver.manage().window().maximize();
//		delete cookies 
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("testCookie");
//		add cookie
		driver.manage().addCookie(null);
//		get desired page 
		driver.get("https://google.com");
	}

}
