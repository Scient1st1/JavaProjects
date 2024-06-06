package BrowserTasks;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsAndTabs {

	public static void main(String[] args) throws IOException {
//		new window and tab only work after selenium v4
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
//		open new tab
//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
//		get child window id
		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		
//		https://courses.rahulshettyacademy.com/p
		String firstCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(firstCourse);
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(firstCourse);
		
//		get the screenshot of element
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
//		get/check width and height of the elemenet 
		int height = name.getRect().getDimension().getHeight();
		int width = name.getRect().getDimension().getWidth();
		System.out.println(height);
		System.out.println(width);
	}

}
