import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class ecomerce_Tc4 extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("test");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))");
		// if this scroll not worked we can use the following one
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + "Egypt" + "\").instance(0))"));
		driver.findElementByXPath("//*[@text='Egypt']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		/*
		 * if we want to click on first 2 items this code will not work because when we
		 * click on the first one it will be changed to item added so it will not find
		 * the second one
		 * driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		 * driver.findElementsByXPath("//*[@text='ADD TO CART']").get(1).click(); so we
		 * need to do the following
		 */
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);

		// get amount of first item
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		// remove the $ from the amount so we can convert to Int
		amount1 = amount1.substring(1);
		// convert to double
		double amount1Value = Double.parseDouble(amount1);

		// get amount of second item
		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		// remove the $ from the amount so we can convert to Int
		amount2 = amount2.substring(1);
		// convert to double
		double amount2Value = Double.parseDouble(amount2);

		// sum of 2 items
		double totalOfItems = amount1Value + amount2Value;

		// Read the total from the application to compare it with the calculated one
		String productsSum = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		productsSum = productsSum.substring(1);
		double productsSumValue = Double.parseDouble(productsSum);

		Assert.assertEquals(totalOfItems, productsSumValue);
	}

}
