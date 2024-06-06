package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers for selenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Sibling to sibling
		//header/div/button[1]/following-sibling::button[1]
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
//		child to parent 
		//header/div/button[1]/parent::div
	
	
	
	
	}

}
