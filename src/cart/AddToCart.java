package cart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		String[] veggies = { "Cucumber", "Brocolli" };
		
		addItems(driver, veggies);
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
//		explicit wait 
		Duration duration = Duration.ofHours(0).plusMinutes(0).plusSeconds(5);
		WebDriverWait w = new WebDriverWait(driver, duration);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String successTxt = driver.findElement(By.className("promoInfo")).getText();
		System.out.println(successTxt);
	}

	
	
	public static void addItems(WebDriver driver, String[] veggies) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			// name needs to be trimmed to actual vegetable name
			String formatedName = name[0].trim();
//			name[0] = Broccoli
//			name[1] = 1kg
			System.out.println(name);

			List itemsNeeded = Arrays.asList(veggies);
			if (itemsNeeded.contains(formatedName)) {
//				click on cucumber's add to cart 
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == itemsNeeded.size()) {
					break;
				}
			}
		}
	}

}
