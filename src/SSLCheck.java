import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// Chromoptions sets behaviour for driver
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
//		FirefoxOptions opts = new FirefoxOptions();
//		EdgeOptions opts2 = new EdgeOptions();
		
//		add extensions to browser 
//		options.addExtensions("");
		
//		add proxy
		Proxy p = new Proxy();
		p.setHttpProxy("ipaddress:4444");//example
		options.setCapability("proxy", p);
		
		
//		add download path 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
