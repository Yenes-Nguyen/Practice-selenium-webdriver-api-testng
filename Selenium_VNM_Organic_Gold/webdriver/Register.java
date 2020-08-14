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
	
	@Test (enabled = false)
	public void TC_01_Login_With_Empty_All_Field() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//form[@id='registerform']//a[@class='btn-common']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='display_name']/following-sibling::div/i")).getText(), "Vui lòng nhập Họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_email']/following-sibling::div/i")).getText(), "Vui lòng nhập Email");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_phone']/following-sibling::div/i")).getText(),"Vui lòng nhập Số điện thoại");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='user_password']/following-sibling::div/i")).getText(),"Vui lòng nhập Mật khẩu");
	}
	
	@Test 
	public void TC_02_Login_With_Invalid_Email() {
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
