import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// setting up
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ascas\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// locate the url
		driver.get("https://admin-demo.nopcommerce.com/");
		// maximize the browser
		driver.manage().window().maximize();

		// setting up looketer
		
		
		//loging in
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		//Thread.sleep(2000);
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).sendKeys("admin");

		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		//click customer in navbar
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.xpath("//a[contains(@href,'Admin/Customer/List')]")).click();
		
		
		//creating new user
		driver.findElement(By.xpath("//a[contains(@href,'Admin/Customer/Create')]")).click();
		
		driver.findElement(By.id("Email")).sendKeys("sample@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("password123");
		driver.findElement(By.id("FirstName")).sendKeys("Juan");
		driver.findElement(By.id("LastName")).sendKeys("Dela cruz");
		//gender
		driver.findElement(By.id("Gender_Female")).click();
		//date
		driver.findElement(By.id("DateOfBirth")).sendKeys("11/17/1999");
		driver.findElement(By.id("Company")).sendKeys("ABC Company");
		//checkbox
		driver.findElement(By.id("IsTaxExempt")).click();
		
		//newsletter
		driver.findElement(By.className("k-multiselect")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Your store name')]")).click();
		
		/*
		 * //customer roles
		 * driver.findElement(By.xpath("//*[@id='k-multiselect'])[2]")).click();
		 * driver.findElement(By.xpath("//option[contains(text(),'Vendors')]")).click();
		 */
		
		//vendor
		driver.findElement(By.id("VendorId")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Vendor 1')]")).click();
		
		//Active checkbox
		driver.findElement(By.id("Active")).click();
		
		//AdminComment
		driver.findElement(By.id("AdminComment")).sendKeys("Comment admin");
		
		driver.findElement(By.name("save")).click();
		
		//Capturing the screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:/Users/ascas/Downloads/screen.png"));
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		
		driver.close();

	}

}
