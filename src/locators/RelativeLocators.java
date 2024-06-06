package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import static package for relative locators
//only in selenium v4 and above
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
	
//		above
		driver.findElement(with(By.tagName("label")).above(nameBox)).getText();
		
//		below
		WebElement dateOfB = driver.findElement(By.cssSelector("[for='dateofBirth']"));
//		doesnot support flex -  skips
		driver.findElement(with(By.tagName("input")).below(dateOfB)).click();
		
//		left
		WebElement checkLabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkLabel)).click();
		
//		right
		WebElement firstRadio = driver.findElement(By.id("inlineRadio1"));
		driver.findElement(with(By.tagName("label")).toRightOf(firstRadio)).getText();
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(firstRadio)).getText());
	}

}
