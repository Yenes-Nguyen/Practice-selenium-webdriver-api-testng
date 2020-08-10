package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register__And_Login {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test 
	public void TC_01_Login_With_Empty_Email_And_Password() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/san-pham/sua-bot-tre-em-organic-gold/");	
		driver.findElement(By.linkText("Đăng nhập")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
		
		//Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_login_mess']")).getText(), "Vui lòng nhập Email");
		String emailempt = driver.findElement(By.xpath("//p[@id='user_login_mess']")).getText();
		Assert.assertEquals(emailempt,"Vui lòng nhập Email");
	}
//	 @AfterClass
//	 public void afterClass() {
//		  driver.quit();
//	 }

}
