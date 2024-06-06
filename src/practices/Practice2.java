package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		login(driver);
		driver.findElement(By.id("exampleCheck1")).click();
		handleDropdown(driver);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12/03/1995");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		driver.findElement(By.className("alert-success")).getText();
		System.out.println(driver.findElement(By.className("alert-success")).getText());
	}
	public static void login(WebDriver driver) {
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("testName");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("123");
	}
	public static void handleDropdown(WebDriver driver) {
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[1]")).click();
	}
}
