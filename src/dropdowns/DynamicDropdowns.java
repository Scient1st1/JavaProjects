package dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// (//a[@value='MAA'])[2] //a[@value='BLR']
//		driver.manage().window().maximize();
		
		Dimension dm = driver.manage().window().getSize();
		int maxHeight = 1080;
		int maxWidth = 1920;
		
		if(dm.height < maxHeight && dm.width < maxWidth) {
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
			driver.findElement(By.xpath("//option[@value='BLR']")).click();
			driver.findElement(By.xpath("(//option[@value='MAA'])[2]")).click();
		}else {
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			System.out.println("maximized");
		}

		//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		
//		without indexes from parent xpath to child
//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	}

}
