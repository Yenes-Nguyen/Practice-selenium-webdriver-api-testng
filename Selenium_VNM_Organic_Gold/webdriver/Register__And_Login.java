package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register__And_Login {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test 
	public void TC_01_Login_With_Empty_Email_And_Password() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/san-pham/sua-bot-tre-em-organic-gold/");	
		driver.findElement(By.linkText("Đăng nhập")).click();
		
		driver.findElement(By.className("btn-common"));
	}
//	 @AfterClass
//	 public void afterClass() {
//		  driver.quit();
//	 }

}
