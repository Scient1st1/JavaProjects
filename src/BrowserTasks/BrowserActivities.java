package BrowserTasks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers for selenium\\chromedriver-win64\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://youtube.com");
		driver.navigate().back();
		driver.navigate().forward();
	

	
	}

}
