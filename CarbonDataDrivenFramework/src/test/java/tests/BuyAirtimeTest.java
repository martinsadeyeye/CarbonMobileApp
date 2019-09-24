package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import util.TestBase;

public class BuyAirtimeTest extends TestBase {

	private static AndroidDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void buyAirtimeTest() throws InterruptedException {

		// Test Scenarios for Airtime Recharge

		// Click on Buy Airtime Menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='Buy Airtime']")).click();

		// driver.findElement(By.xpath("//android.widget.EditText[@text='e.g
		// 08031234567']")).sendKeys("08037609808");

		// Enter your phone number
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/edit_text_phone_number"))
				.sendKeys("08037609808");

		// Enter amount
		// driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).click();
		// driver.findElement(By.linkText("//android.widget.LinearLayout[@index='2']")).click();

		// Select 400
		driver.findElement(By.xpath("//android.widget.TextView[@text='400']")).click();

		// Select MTN Network
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='3']")).click();

		// click Next
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();

		// pay using Wallet
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/walletRadioButton")).click();

		// click on Confirm Payment
		driver.findElement(By.xpath("//android.widget.TextView[@text='Confirm payment']")).click();

		// click on Secure pay
		driver.findElement(By.id("com.lenddo.mobile.paylater.staging:id/button_text_secure_pay")).click();

		// Enter your PIN
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']")).sendKeys("2");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']")).sendKeys("3");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='3']")).sendKeys("4");

		// Assert that Airtime purchase was successful

		WebElement msg = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Your airtime purchase was successful!']"));

		// Click go back to Home page
		driver.findElement(By.xpath("//android.widget.Button[@text='Go back home']")).click();

		driver.findElement(By.xpath("//android.widget.Button[@text='Okay']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
