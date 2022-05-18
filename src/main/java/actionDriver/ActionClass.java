package actionDriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class ActionClass extends BaseClass {
	//static WebDriver driver ;

	public static void WaitImplicit(int sec, WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void waitExplicit(WebDriver driver, int sec, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wt.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public static void getTitle(WebDriver driver){
		System.out.println("Get Title : "+driver.getTitle());
	}
	public static void getURL(WebDriver driver){
		System.out.println(driver.getCurrentUrl());
	}
	public static void click (WebDriver ldriver, WebElement ele) {
		Actions obj = new Actions(driver);
		obj.moveToElement(ele).click().build().perform();
	}
	public static void scrollTillElement(WebElement ele, WebDriver driver) // javaScript
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	public static void clickByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
//	public static void isDisplayed() {
//		
//	}
	public static void findElement(WebDriver driver,WebElement ele) {
		Boolean flag= false;
		try {
			ele.isDisplayed();
			flag=true;
		}catch(Exception e) {
			flag=false;
		}finally{
			if(flag) {
				System.out.println("Ele found");
			}else {
				System.out.println("unable to locate ele");
			}

		}
	}

}
