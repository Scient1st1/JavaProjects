import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
//		#nav-link-accountList
		driver.get("http://www.itvet.ge/");
//		driver.get("https://www.youtube.com/");
		Actions a = new Actions(driver);
		WebElement toggler = driver.findElement(By.cssSelector(".dropdown-toggle"));
		a.moveToElement(toggler).build().perform();
		driver.findElement(By.cssSelector(".sicon-btn")).click();
//		WebElement textBox = driver.findElement(By.xpath("//div[@id='search-input']/input"));
		WebElement textBox = driver.findElement(By.id("search"));
		System.out.println(textBox.isDisplayed());
//		input_element.send_keys(Keys.SHIFT, 'h', Keys.SHIFT, 'e', Keys.SHIFT, 'l', Keys.SHIFT, 'l', Keys.SHIFT, 'o')
		a.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
//		contextclick is right click 
		a.moveToElement(textBox).contextClick().build().perform();
	}

}
