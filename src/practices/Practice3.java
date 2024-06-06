package practices;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice3 {
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		handleInputs(driver);
		handleInputsAlert(driver);
		handleDropDownAndSignIn(driver);
		Thread.sleep(5000);
		handleCartItems(driver);
	}
	public static void handleInputs(WebDriver driver) {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
	}
	public static void handleInputsAlert(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.findElement(By.id("okayBtn")).click();
		
	}
	public static void handleDropDownAndSignIn(WebDriver driver) {
			WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByValue("consult");
			driver.findElement(By.id("terms")).click();
			driver.findElement(By.id("signInBtn")).click();
	}
	
	public static void handleCartItems(WebDriver driver) {
		List<WebElement> btns =  driver.findElements(By.cssSelector(".card-footer button"));
		System.out.println(btns);
		for(int i=0; i < btns.size(); i++) {
			btns.get(i).click();
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
	}
}
