package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice8 {

	public static void main(String[] args) throws InterruptedException {
		//auto suggested dropdown select and verify
		WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
    	WebElement inp = driver.findElement(By.id("autocomplete"));
    	inp.sendKeys("ind");
    	Thread.sleep(2000);
    	inp.sendKeys(Keys.DOWN, Keys.DOWN);
    	System.out.println(inp.getAttribute("value"));
   
	}

}
