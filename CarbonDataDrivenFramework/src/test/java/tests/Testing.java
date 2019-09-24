package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.TestBase;

public class Testing extends TestBase {

	public static void main(String[] args) throws IOException {

		AndroidDriver<AndroidElement> driver = capabilities("CarbonApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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

	}

}
