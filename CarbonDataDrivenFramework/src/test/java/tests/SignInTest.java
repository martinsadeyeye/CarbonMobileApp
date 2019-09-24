package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import util.TestBase;

public class SignInTest extends TestBase {

	private static AndroidDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void signInTest() throws InterruptedException {

		driver.findElementById("com.lenddo.mobile.paylater.staging:id/carbonUpButton").click();

		driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();

		// Test Scenario for Sign In

		// Click on Sign in Button
		driver.findElement(By.xpath("//android.widget.Button[@text='Sign In']")).click();

		// Enter your phone number
		driver.findElement(By.xpath("//android.widget.EditText[@text='Phone number']")).sendKeys("08990001101");

		// Enter your PIN
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter PIN']")).sendKeys("1234");

		// Click Sign in to login
		driver.findElement(By.xpath("//android.widget.Button[@text='Sign In']")).click();

		// driver.findElement(By.xpath("//android.widget.TextView[@text='Not right
		// now']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
