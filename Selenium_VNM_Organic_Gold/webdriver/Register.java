package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test 
	public void TC_01_Register_With_Empty_All_Field() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='display_name']/following-sibling::div/i")).getText(), "Vui lòng nhập Họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_email']/following-sibling::div/i")).getText(), "Vui lòng nhập Email");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_phone']/following-sibling::div/i")).getText(),"Vui lòng nhập Số điện thoại");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_password']/following-sibling::div/i")).getText(),"Vui lòng nhập Mật khẩu");
	}
	
	@Test 
	public void TC_02_Register_With_Invalid_Email() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.id("display_name")).sendKeys("autotest");
		driver.findElement(By.id("user_email")).sendKeys("autotest.com");
		driver.findElement(By.id("user_phone")).sendKeys("0974682031");
		driver.findElement(By.id("user_password")).sendKeys("123123");
		driver.findElement(By.id("user_password_retype")).sendKeys("123123");
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_email']/following-sibling::div/i")).getText(), "Email không hợp lệ");
		
	}
	
	@Test 
	public void TC_03_Register_With_Invalid_PhoneNumber() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.id("display_name")).sendKeys("autotest");
		driver.findElement(By.id("user_email")).sendKeys("auto@test.com");
		driver.findElement(By.id("user_phone")).sendKeys("0974");
		driver.findElement(By.id("user_password")).sendKeys("123123");
		driver.findElement(By.id("user_password_retype")).sendKeys("123123");
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_phone']/following-sibling::div/i")).getText(), "Số điện thoại không hợp lệ");
		
	}
	
	@Test
	public void TC_04_Register_With_Password_And_RetypePassword_Not_Match() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.id("display_name")).sendKeys("autotest");
		driver.findElement(By.id("user_email")).sendKeys("auto@test.com");
		driver.findElement(By.id("user_phone")).sendKeys("0974000000");
		driver.findElement(By.id("user_password")).sendKeys("123123");
		driver.findElement(By.id("user_password_retype")).sendKeys("123");
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_password_retype']/following-sibling::div/i")).getText(), "Mật khẩu nhập lại không đúng");
		
	}
	
	@Test 
	public void TC_05_Register_With_Option_Pregnant () {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.id("display_name")).sendKeys("autotest");
		driver.findElement(By.id("user_email")).sendKeys("auto@test.com");
		driver.findElement(By.id("user_phone")).sendKeys("0974000000");
		driver.findElement(By.id("user_password")).sendKeys("123123");
		driver.findElement(By.id("user_password_retype")).sendKeys("123123");
		driver.findElement(By.xpath("//p[@class='check-box-text']/strong[contains(text(),'Đang mang thai')]")).click();
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-fetus']//i")).getText(), "Vui lòng chọn lại ngày dự sinh của Bé.");
		
	}
	
	@Test 
	public void TC_06_Register_With_Option_Pregnant_Invalid_Date () {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.id("display_name")).sendKeys("autotest");
		driver.findElement(By.id("user_email")).sendKeys("auto@test.com");
		driver.findElement(By.id("user_phone")).sendKeys("0974000000");
		driver.findElement(By.id("user_password")).sendKeys("123123");
		driver.findElement(By.id("user_password_retype")).sendKeys("123123");
		driver.findElement(By.xpath("//p[@class='check-box-text']/strong[contains(text(),'Đang mang thai')]")).click();
		
//		String Date date1 = new Date();
//		Thread.sleep(TimeUnit.SECONDS.toMillis(3));
//		
//		 long millis = System.currentTimeMillis();
//	     Date date2 = new Date(millis);
//		
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-fetus']//i")).getText(), "Vui lòng chọn lại ngày dự sinh của Bé.");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
