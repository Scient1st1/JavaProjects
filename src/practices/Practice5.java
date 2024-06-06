package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Frames
//		frame-middle text needed
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		String frameContent = driver.findElement(By.id("content")).getText();
		System.out.println(frameContent);
	}

}
