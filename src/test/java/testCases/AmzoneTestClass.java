package testCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.IndexPage;
import pageObjects.NewPage;

public class AmzoneTestClass extends BaseClass {
	public WebDriver driver;
	IndexPage indexPage;

	NewPage page;

	@BeforeSuite
	public void setUp() 
	{
		driver=launchBrowser("chrome");
		
	}
	@Test(priority=1)
	public void launchUrl()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		indexPage = new IndexPage(driver);

	}

	@Test(priority=2)
	public void AmazonTest() throws InterruptedException
	{
		indexPage.clickOnHumburgerBar();
		indexPage.clickOnTVMenu();
		indexPage.clickOnTelevision();
		indexPage.clickOnSmartTel();
		indexPage.tickOnCheckBox();
		indexPage.handleDropDown();
		indexPage.selectHighToLow();
		indexPage.selectHighestIcon();
	}
	
	@Test(priority=3)
	public void verifyAboutItemSec() throws InterruptedException 
	{
		page = new NewPage(driver);
		String MainWindow= driver.getWindowHandle();
		
		
//		String MainWindow2=driver.getWindowHandle();
//		System.out.println("WindId"+MainWindow +" " +MainWindow);

		Set<String> childWind= driver.getWindowHandles();
		Iterator<String> itr =childWind.iterator();
		while(itr.hasNext())			
		{
			String childwindid =itr.next();


			if(!MainWindow.equalsIgnoreCase(childwindid))			
			{ 
				System.out.println("WindID :"+childwindid);
				
				driver.switchTo().window(childwindid);
				String actual= page.verifyIteamSec();
				System.out.println("Atual Result: "+actual);


				String expected = "About this item";

				Assert.assertEquals(actual, expected);

				System.out.println("About this item section is Present ");
			}

		}
	}
	

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}



