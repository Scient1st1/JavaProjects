package dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendsrsDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		.ui-state-highlight
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
//		select current date 
		driver.findElement(By.cssSelector(".ui-state-highlight")).click();
	}

}
