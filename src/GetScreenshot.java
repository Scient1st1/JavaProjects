import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils; //imported external jars from common.apache.org

public class GetScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
//		cast a screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		copy image from src object to your computer - dont place it directly on C drive choose a repo
		FileUtils.copyFile(src, new File("C:\\Users\\levan\\screenshot.png"));
	}

}
