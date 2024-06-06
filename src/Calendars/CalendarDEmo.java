package Calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarDEmo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String month = "6";
		String date = "15";
		String year = "2027";
		String[] expectedList = {month,date,year};
		WebDriver driver = new ChromeDriver();;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__calendar-button")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
//		get year 
		driver.findElement(By.xpath("//button[text()='"+ year +"']")).click();
//		get month from all month
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
//		get date
		driver.findElement(By.xpath("//abbr[text()='"+ date +"']")).click();
		
//		get full text
		System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		
		List<WebElement> calendarInputs =  driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i =0 ; i<calendarInputs.size(); i++) {
			System.out.println(calendarInputs.get(i).getAttribute("value"));
			Assert.assertEquals(calendarInputs.get(i).getAttribute("value"), expectedList[i]);
		}
		
	}

}
