package practices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		switch beween windows 
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		WebElement a = driver.findElement(By.cssSelector(".example a"));
		a.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		String childWinText = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(childWinText);
		driver.switchTo().window(parentId);
		String parentWinText = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(parentWinText);
	}

}
