package Calendars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
//		select destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
//		calendar
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
//		select current date 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-highlight")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("enabled");
			Assert.assertTrue(false);
		}else {
			System.out.println("disabled");
			Assert.assertTrue(true);
		}
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i =1;
		while(i < 3) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		driver.findElement(By.id("btnclosepaxoption")).click();
		
//		search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
