package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
//    	print number of rows in table = 11 
//    	print number of cols in table = 3
//    	print third row data 
    	
    	WebElement table = driver.findElement(By.cssSelector(".table-display"));
    	List<WebElement> trs =  table.findElements(By.tagName("tr"));
    	List<WebElement> ths =  table.findElements(By.tagName("th"));
    	System.out.println(trs.size()); //rows
    	System.out.println(ths.size()); //cols
    	
//    	third row
    	WebElement thirdTr = table.findElement(By.cssSelector(".table-display tr:nth-child(3)"));
    	List<WebElement> thirdTrTds =  thirdTr.findElements(By.tagName("td"));
    	
    	for(int i=0; i< thirdTrTds.size(); i++) {
    		System.out.println(thirdTrTds.get(i).getText());
    	}
    	
	}

}
