import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
public class ecomerce_Tc2 extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();

		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))");
		//if this scroll not worked we can use the following one
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Egypt" + "\").instance(0))"));
		driver.findElementByXPath("//*[@text='Egypt']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals("Please enter your name", toastMessage);//Actual validation

		//name attribute for toast messages will have content
	}

}
