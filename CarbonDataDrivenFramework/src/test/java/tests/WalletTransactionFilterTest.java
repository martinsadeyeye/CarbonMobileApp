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

public class WalletTransactionFilterTest extends TestBase {

	private static AndroidDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void walletTransactionFilterTest() throws InterruptedException {

		// Test scenario for Wallet Transaction Filter

		// Click on transaction Menu
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/viewWalletTransactionsButton").click();

		// Select transaction type ( spinner)
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/transactionTypeSpinner").click();

		// select Wallet
		driver.findElement(By.xpath("//android.widget.TextView[@text='Wallet']")).click();

		// select Fund transfer
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/transactionTypeSpinner").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fund transfers']")).click();

		// select Airtime
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/transactionTypeSpinner").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Airtime']")).click();

		// select Bill Payments
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/transactionTypeSpinner").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bill payments']")).click();

		// select Loan
		driver.findElementById("com.lenddo.mobile.paylater.staging:id/transactionTypeSpinner").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Loans']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
