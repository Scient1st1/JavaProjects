import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		check how many links are on page 
		List links =  driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
//		how many links in footer - limiting webdriver scope
		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls"));
		List footerLinks = footer.findElements(By.tagName("a"));
		System.out.println(footerLinks.size());
		
//		footer first column links 
		WebElement footerCol = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List columnLinks = footerCol.findElements(By.tagName("a"));
		System.out.println(columnLinks.size());
	
		
//		click every link in column and check if they are working
		for(int i = 1; i<columnLinks.size(); i++) { //opens every tab
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);		
		}
		
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> it = winds.iterator();
		while(it.hasNext()) { //reads every tab title
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
	


}
