import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecomerce_Tc1 extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("test");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))");
		//if this scroll not worked we can use the following one
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Egypt" + "\").instance(0))"));
		driver.findElementByXPath("//*[@text='Egypt']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	
		}

}
