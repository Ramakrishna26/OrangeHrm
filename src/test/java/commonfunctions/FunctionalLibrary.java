package commonfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utils.PropertyFileUtil;

public class FunctionalLibrary 
{
	public static WebDriver openBrowser(WebDriver driver) throws Exception
	{
		if (PropertyFileUtil.getValueforKey("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		if (PropertyFileUtil.getValueforKey("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "common jar files/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		if (PropertyFileUtil.getValueforKey("Browser").equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "common jar files/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public static void closeApp(WebDriver driver)
	{
		driver.close();
	}
	public static void openApplication(WebDriver driver) throws Exception
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(PropertyFileUtil.getValueforKey("url"));
	}
	
	public static void clickAction(WebDriver driver, String Locator_value, String Locator_type)
	{
		if (Locator_type.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(Locator_value)).click();
		}
		if (Locator_type.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(Locator_value)).click();
		}
	}
	
	public static void typeAction(WebDriver driver, String Locator_value, String Locator_type, String data)
	{
		if (Locator_type.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(Locator_value)).clear();
			driver.findElement(By.id(Locator_value)).sendKeys(data);
		}
		if (Locator_type.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(Locator_value)).clear();
			driver.findElement(By.id(Locator_value)).sendKeys(data);
		}
	}

}
