import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		input and alert btn
		driver.findElement(By.id("name")).sendKeys("testName");
		driver.findElement(By.id("alertbtn")).click();
		
//		switch to alert window from browser and click ok
		String text = driver.switchTo().alert().getText(); // get alert text
		System.out.println(text);
		driver.switchTo().alert().accept();
		
//		confirm
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
