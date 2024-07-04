package Test_suite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdow {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void drdwn() throws IOException, InterruptedException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source1 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source1, new File("./SeleniumScreenshots/Screen_before.png"));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop1).build().perform();
        File source2 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source2, new File("./SeleniumScreenshots/Screen_for_dropzone1.png"));
        Thread.sleep(4000);
        action.dragAndDrop(drag, drop2).build().perform();
        File source3 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source3, new File("./SeleniumScreenshots/Screen_for_dropzone2.png"));
        Thread.sleep(4000);
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}
