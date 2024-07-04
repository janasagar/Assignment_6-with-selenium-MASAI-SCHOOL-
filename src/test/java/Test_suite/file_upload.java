package Test_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class file_upload {
	WebDriver driver;
	
	@BeforeClass//it will execute first before test cases
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();//setup browser driver
		
		driver.get("https://demo.automationtesting.in/FileUpload.html");//visit the website
		
		driver.manage().window().maximize();//maximize browser
		
		Thread.sleep(4000);//hold execution for 4 seconds 
	}
	
	@Test
	public void upload() throws InterruptedException {
		WebElement uploadfile = driver.findElement(By.id("input-4"));
		uploadfile.sendKeys("C:\\Users\\kkkkr\\Downloads\\unnamed.jpg");
		Thread.sleep(4000);
		
		String file_name = driver.findElement(By.xpath("(//div[@title='unnamed.jpg'])[1]")).getText();
		Assert.assertTrue(true, "unnamed.jpg");
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
