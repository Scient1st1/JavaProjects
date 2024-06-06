package practices;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class OCRWithSelenium {
    public static void main(String[] args) throws InterruptedException {
        // Set the path for the ChromeDriver
      

        // Initialize Chrome options
        ChromeOptions options = new ChromeOptions();
        // Optional: run Chrome in headless mode

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the webpage
            driver.get("https://amazon.com");

            // Wait for the page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Find the image element
            WebElement imageElement = driver.findElement(By.xpath("//div[@class='a-box']/div/div/img"));

            // Get the location and size of the image element
            Point location = imageElement.getLocation();
            int width = imageElement.getSize().getWidth();
            int height = imageElement.getSize().getHeight();

            // Take a screenshot of the entire page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenshotLocation = new File("screenshot.png");
            FileUtils.copyFile(screenshot, screenshotLocation);

            // Crop the image to the element's size
            BufferedImage fullImg = ImageIO.read(screenshot);
            BufferedImage elementScreenshot = fullImg.getSubimage(location.getX(), location.getY(), width, height);
            ImageIO.write(elementScreenshot, "png", screenshotLocation);

            // Perform OCR using Tesseract
            ITesseract instance = new Tesseract();
            instance.setDatapath("C:\\Users\\levan\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata"); // Set the path to your tessdata folder
            String result = instance.doOCR(screenshotLocation);

            // Print the result
            System.out.println("Extracted Text: " + result);         
            driver.findElement(By.id("captchacharacters")).sendKeys(result);
            driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
            
        } catch (IOException | TesseractException e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}
