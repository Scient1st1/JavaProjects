package BrowserTasks;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
//		managing other windows 
		Set<String> wind = driver.getWindowHandles(); //[parentWindowid, childId]
//		System.out.println(wind);
		Iterator<String> it = wind.iterator();
		String parentId = it.next();
		String childId = it.next(); //childwindowId
		driver.switchTo().window(childId);
		String redText = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(redText);
		String email = redText.split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
	}

}
