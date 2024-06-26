import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;




public class FluentWaitExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("#start button")).click();

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) // Maximum wait time
				.pollingEvery(Duration.ofSeconds(3)) // Frequency of checking the condition
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("#finish h4")).isDisplayed()) {
					
					return driver.findElement(By.cssSelector("#finish h4"));
				}else {
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());
	}

}
