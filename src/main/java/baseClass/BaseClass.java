package baseClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import actionDriver.ActionClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
//Parent Class
public class BaseClass {

	public static Properties prop; 
	public static WebDriver driver;
	//@BeforeTest(alwaysRun=true)
	public void loadConfig() 
	{
		try
		{
			prop = new Properties();
			System.out.println("Super constructor invovked");
			FileInputStream fis = new FileInputStream("/MyAmazonProject/Cofiguration/config.properties");
					//System.getProperty("user.dir")+ "\\Cofiguration\\config.properties");

			//FileInputStream fis = new FileInputStream("./Qapitol-Assesment/propertiesFile/cofig.properties");
			prop.load(fis);
			System.out.println("driver: " +driver);

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();

		}
	}
	public static WebDriver launchBrowser(String browserName) {
		
		String path = System.getProperty("user.dir"); 
		System.out.print("project path = "+path);
		
		if(browserName.equalsIgnoreCase("ch")||browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff")||browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");	
			driver = new FirefoxDriver(); // interface object is type cast here and child to parent  
		}
		else if(browserName.equalsIgnoreCase("saf")||browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")||browserName.equalsIgnoreCase("InternetExplorer")) {

			System.setProperty("webdriver.ie.driver", path+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("ed")||browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",path+"\\drivers\\EdgeDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		return driver;
	
	}
	
		/*WebDriverManager.chromedriver().setup();
		String browserName= prop.getProperty("browserName"); // read config file
		if(browserName.contains("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.contains("FireFox")) {
			driver=new FirefoxDriver();
		}else if(browserName.contains("IE")) {
			driver=new InternetExplorerDriver();
		}
		
		ActionClass.WaitImplicit(10, driver);
		driver.get(prop.getProperty("url"));


	}*/
}

