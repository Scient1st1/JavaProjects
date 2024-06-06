package dropdowns;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

//TestNg is testing framework

public class UpdatedDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		ChromeOptions options = new ChromeOptions();//open in incognito
//		options.addArguments("--incognito");//open in incognito
//		WebDriver driver = new ChromeDriver(options); //open in incognito
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
//		checkboxes 
		//id = ctl00_mainContent_chk_SeniorCitizenDiscount, use regex
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		count the checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
//		second calendar is disabled 
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
//		radio buttons 
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		above button activates calendar
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
//isanabled not working properly, cause both times its true;
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("enabled");
			Assert.assertTrue(true);
		}else {
			System.out.println("disabled");
			Assert.assertTrue(false);
		}
		
		
		
//		updated dropdown
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i =1;
		while(i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
	}

}
