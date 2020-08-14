package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test (enabled = false)
	public void TC_01_Login_With_Empty_Email_And_Password() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
//		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_login_mess']")).getText(), "Vui lòng nhập Email");
//		String emailempt = driver.findElement(By.xpath("//p[@id='user_login_mess']")).getText();
//		Assert.assertEquals(emailempt,"Vui lòng nhập Email");
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='user_login_mess' and text()='Vui lòng nhập Email']")).isDisplayed());	
		
	}
	
	@Test (enabled = false)
	public void TC_02_Login_With_Invalid_Email() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='email']")).sendKeys("autotest@testcom");
		
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='user_login_mess' and text()='Email không hợp lệ']")).isDisplayed());
	}
	
	@Test (enabled = false)
	public void TC_03_Logi_With_Empty_Password() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='password']")).sendKeys("");
		
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='user_login_mess' and text()='Vui lòng nhập Mật khẩu']")).isDisplayed());
	}
	
	@Test (enabled = false)
	public void TC_04_Login_With_Wrong_Password() {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='password']")).sendKeys("123");
		
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='user_login_mess' and text()='Sai email hoặc mật khẩu']")).isDisplayed());
	}
		
	@Test (enabled = false)
	public void TC_05_Login_With_Valid_Email_And_Password() throws InterruptedException {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//li[@id='login-form']//input[@type='password']")).sendKeys("123123");
		
		driver.findElement(By.xpath("//a[@class='btn-common']//span[contains(text(),'Đăng nhập')]")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='headline-block']//h4 and text()='DINH DƯỠNG ORGANIC CHÂU ÂU']")).isDisplayed());
		Thread.sleep(3000);
		String titleHome = driver.findElement(By.xpath("//div[@class='headline-block']//h4[(text()='DINH DƯỠNG ORGANIC CHÂU ÂU')] ")).getText();
		Assert.assertEquals(titleHome,"DINH DƯỠNG ORGANIC CHÂU ÂU");
	}
	
	@Test (enabled = false)
	public void TC_06_Forgot_Password_With_Empty_Email() throws InterruptedException {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();		
		driver.findElement(By.xpath("//div[@class='form-group login-form__helper clearfix']//a")).click();
		
		driver.findElement(By.xpath("//li[@id='forget-password']//a[@class='btn-common']")).click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='forgetpass_mess' and text()='Vui lòng nhập Email']")).isDisplayed());
	}
	
	@Test (enabled = false)
	public void TC_07_Forgot_Password_With_Empty_Email() throws InterruptedException {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();		
		driver.findElement(By.xpath("//div[@class='form-group login-form__helper clearfix']//a")).click();
		
		driver.findElement(By.xpath("//li[@id='forget-password']//input[@class='input-text']")).sendKeys("autotest@testcom");
		driver.findElement(By.xpath("//li[@id='forget-password']//a[@class='btn-common']")).click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='forgetpass_mess' and text()='Email không hợp lệ']")).isDisplayed());
	}

	@Test (enabled = false)
	public void TC_08_Forgot_Password_With_NotRegisted_Email() throws InterruptedException {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();		
		driver.findElement(By.xpath("//div[@class='form-group login-form__helper clearfix']//a")).click();
		
		driver.findElement(By.xpath("//li[@id='forget-password']//input[@class='input-text']")).sendKeys("testauto@test.com");
		driver.findElement(By.xpath("//li[@id='forget-password']//a[@class='btn-common']")).click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='forgetpass_mess' and text()='Không tìm thấy tài khoản nào với email này']")).isDisplayed());
	}
	
	@Test
	public void TC_09_Forgot_Password_With_Valid_Email() throws InterruptedException {
		driver.get("https://www.vinamilk.com.vn/dinh-duong-organic/vi/");	
		driver.findElement(By.xpath("//div[@class='header__user']//span")).click();
		
		driver.findElement(By.xpath("//ul[@class='login-tabs__nav tabs__nav']//a[contains(text(),'Đăng nhập')]")).click();		
		driver.findElement(By.xpath("//div[@class='form-group login-form__helper clearfix']//a")).click();
		
		driver.findElement(By.xpath("//li[@id='forget-password']//input[@class='input-text']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//li[@id='forget-password']//a[@class='btn-common']")).click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='forgetpass_mess' and text()='Vui lòng kiểm tra email để nhận đường đẫn cập nhật mật khẩu']")).isDisplayed());
	}
	
	 @AfterClass
	 public void afterClass() {
		  driver.quit();
	 }

}
