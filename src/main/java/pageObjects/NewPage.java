package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionClass;
import baseClass.BaseClass;

public class NewPage extends BaseClass{
	@FindBy(xpath = "//h1[text()=' About this item ']" )
	WebElement aboutItemSec;

	//Constructor
	public NewPage(WebDriver driver) //Con to initialise driver
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); // Initialize all objs
	}

	public String verifyIteamSec() throws InterruptedException 
	{
		Thread.sleep(3000);
		ActionClass.scrollTillElement(aboutItemSec, driver);

		//ActionClass.WaitImplicit(5, driver);
		String actual = aboutItemSec.getText();
		return actual;
	}
	public String getTitle() {
		String title =driver.getTitle();
		return title;
	}

}
