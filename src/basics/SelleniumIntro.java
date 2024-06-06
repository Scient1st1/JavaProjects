package basics;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class SelleniumIntro {

	public static void main(String[] args) {
		// invoking browser
		//firefox also has driver and edge as well
//		WebDriver top most interface
		//ChromeDriver driver = new ChromeDriver();
		
		//we need chromedriver.exe to invoke it
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\levan\\Downloads\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
		//Firefox needs gecko driver Edge needs edgeDriver
		WebDriver driver1 = new EdgeDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers for selenium\\msedgedriver.exe");
		driver1.get("https://www.selenium.dev/");
		driver1.getTitle();
		System.out.println(driver1.getTitle());
		driver1.getCurrentUrl();
		System.out.println(driver1.getCurrentUrl());
		driver1.close();
		//quit closes every window, close closes only targeted;
//		driver1.quit();
	}

}
