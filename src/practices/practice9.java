package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice9 {
//getting shadow root 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		https://www.aldi-onlineshop.de/
//		data-testid="uc-app-container"
//		document.querySelector("#usercentrics-root").shadowRoot.querySelector(".dRvQzh .fMlgSq");
		WebDriver driver = new ChromeDriver();
    	driver.get("https://www.aldi-onlineshop.de/");
    	WebElement el = driver.findElement(By.cssSelector("#usercentrics-root"));
    	SearchContext shadowRoot = el.getShadowRoot();
    	Thread.sleep(2000);
    	WebElement actual = shadowRoot.findElement(By.cssSelector(".dRvQzh .fMlgSq"));
    	actual.click();
    	System.out.println(actual);
    	
    	
	}

}
