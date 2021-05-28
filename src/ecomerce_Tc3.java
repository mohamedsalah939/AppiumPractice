import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class ecomerce_Tc3 extends Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("test");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))");
		/*
		 * if this scroll not worked we can use the following one //
		 * driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new //
		 * UiSelector().scrollable(true).instance(0)).scrollIntoView(new //
		 * UiSelector().textMatches(\"" + "Egypt" + "\").instance(0))"));
		 */
		driver.findElementByXPath("//*[@text='Egypt']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		/*
		 * scroll by navigating to the parent then scroll and select the child // we do
		 * this because if we used normal scroll may be it will not show the whole //
		 * card so we cannot click on add cart
		 */
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();

		for (int i = 0; i < count; i++) {
			String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i)
					.getText();

			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	}

}
