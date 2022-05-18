package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionClass;
import baseClass.BaseClass;

public class IndexPage extends BaseClass {


	//1st way to initialise
	//@FindBy(how = How.ID, using = "nav-hamburger-menu") // how is variable How is class using = what part
	//WebElement humBarMenu;
	
	@FindBy(xpath ="//a[@id='nav-hamburger-menu']")  // 2nd way to do
	WebElement humBarMenu;

	@FindBy(xpath= "//div[text()='TV, Appliances, Electronics']")
	WebElement tvApp;
	
	@FindBy(xpath = "//li/a[@href=\"/gp/browse.html?node=1389396031&ref_=nav_em_sbc_tvelec_television_0_2_9_2\"]")  
	WebElement television;

	@FindBy(xpath = "//span[text()='Smart Televisions']" )
	WebElement smartTel;
	
	@FindBy(xpath = "//li[@id='p_89/Samsung']//i")
	WebElement checkBox;
	
	@FindBy(xpath = "//span[@class='a-button a-button-dropdown a-button-small']" )
	WebElement dropDown;
	
	@FindBy(xpath = "//a[text()='Price: High to Low']" )
	WebElement highToLow;
	
	@FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]")
	WebElement selectItem;
	
	//Constructor
	public IndexPage(WebDriver driver)  //Con to initialise driver
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); // Initialize all objs
	}
	
	//Action Methods
	public void clickOnHumburgerBar()
	{
		//ActionClass.WaitImplicit(5, driver);
		humBarMenu.click();
	}

	public void clickOnTVMenu()
	{
		tvApp.click();
		ActionClass.scrollTillElement(tvApp, driver);
	}
	//3rd Step
	public void clickOnTelevision() {
		television.click();	
	}
	//4th
	public void clickOnSmartTel()
	{
		smartTel.click();	
	}
	//5th step click on check box
	public void tickOnCheckBox()
	{
		checkBox.click();
	}
	//6th click on filter
	public void handleDropDown() throws InterruptedException
	{
		Thread.sleep(3000);
		dropDown.click();
		ActionClass.scrollTillElement(dropDown, driver);
		///ActionClass.clickByJS(dropDown, driver);
	
	}
	//7th appply filter
	public void selectHighToLow() 
	{
		
		highToLow.click();
	}
	//click on high to low
	public void selectHighestIcon() {
		selectItem.click();
		//return new NewPage(driver);
	}
//	public String getTitle() {
//		String title =driver.getTitle();
//		return title;
//	}
}
