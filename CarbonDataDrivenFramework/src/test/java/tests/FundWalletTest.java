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

public class FundWalletTest extends TestBase {

	private static AndroidDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void fundWalletTest() throws InterruptedException {
		
		// Fund Wallet
		driver.findElement(By.xpath("//android.widget.LinearLayout")).click();

		// fund with bank transfer
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fund with bank transfer']")).click();

		// fund with debit/ATM card
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fund with debit/ATM card']")).click();

		// Enter amount
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/walletAmountToFund").sendKeys("1000");

		// click proceed
		driver.findElement(By.xpath("//android.widget.Button[@text='proceed']")).click();

		// radio button to select Visa
		driver.findElementByClassName("android.widget.RadioButton").click();

		// click on Confirm Payment Button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Confirm payment']")).click();

		// Enter your PIN
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']")).sendKeys("2");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']")).sendKeys("3");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@index='3']")).sendKeys("4");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
