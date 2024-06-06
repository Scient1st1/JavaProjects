package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
//	after signing in 
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers for selenium\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		tryLogin(driver);
		String passw = getPassword(driver);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("test");
		driver.findElement(By.name("inputPassword")).sendKeys(passw);
		Thread.sleep(2000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello test,");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	}
	
	public static void tryLogin(WebDriver driver) {
		driver.findElement(By.id("inputUsername")).sendKeys("testUser");
		driver.findElement(By.name("inputPassword")).sendKeys("dummyPass");
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.cssSelector("p.error")).getText();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		String[]passwordArray2 = passwordArray[1].split("'");
		String password = passwordArray2[0];
		System.out.println(password);
		return password;
		
	}
	

}
