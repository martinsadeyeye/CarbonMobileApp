package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {

		//System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\MARTINS\\eclipse-workspace\\CarbonDataDrivenFramework\\global.properties");

		Properties prop = new Properties();
		prop.load(fis);
		prop.get(appName);

		AndroidDriver<AndroidElement> driver;

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apk");
		File app = new File(appDir, appName);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		String device = (String) prop.get("device");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;

	}

}
