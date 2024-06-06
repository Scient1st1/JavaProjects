import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class jsExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
//		scroll - javascript executor
    	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver; //casting
//		scroll to 500 Y 
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
//		calculating table td sum 
		List <WebElement> tds = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i =0; i<tds.size(); i++) {
			System.out.println(Integer.parseInt(tds.get(i).getText()));
			sum += Integer.parseInt(tds.get(i).getText());
			System.out.println(sum);
			
		}
		
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		String trimmedTotal = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int total = Integer.parseInt(trimmedTotal);
		Assert.assertEquals(sum, total);
		
    }
}
