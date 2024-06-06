package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement input = driver.findElement(By.id("checkBoxOption2"));
		input.click();
		WebElement inputLabel = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label"));
		String labelText = inputLabel.getText();
		
//		get dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(labelText);
		
//		get alert input 
		WebElement alertInput = driver.findElement(By.id("name"));
		alertInput.sendKeys(labelText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		String[] firstSplit = alertText.split("share")[0].trim().split(",");
		String secondSplit = firstSplit[0].split(" ")[1].trim();
		if(alertText.contains(secondSplit)) {
			System.out.println(secondSplit);
		}
		
		
	}
	
	

}
