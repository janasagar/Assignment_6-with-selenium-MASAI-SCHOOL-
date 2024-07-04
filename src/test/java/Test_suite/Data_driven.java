package Test_suite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Data_driven {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
	}
	@Test
	public void login() throws IOException {
		File file = new File("C:\\Users\\kkkkr\\OneDrive\\Desktop\\masai\\unit3\\sdet201\\eclipse\\Assignment6\\login_creds.xlsx");
		FileInputStream fl = new FileInputStream(file);
		
		XSSFWorkbook xsf = new XSSFWorkbook(fl);
		
		XSSFSheet sheet = xsf.getSheet("sheet1");
		String username = sheet.getRow(0).getCell(0).getStringCellValue();
		String password = sheet.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
