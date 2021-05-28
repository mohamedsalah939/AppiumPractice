import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver<AndroidElement> CapabilitiesDefine() throws MalformedURLException {

		File F = new File("src");
		File FS = new File(F, "General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SalahEmu");
		cap.setCapability(MobileCapabilityType.APP, FS.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}
}
