package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import GenericLib.Genericlib;
import POM_Class.Home_Page;
import POM_Class.Vtiger_Commercial_Open;

public class BaseClass 
{
	public WebDriver driver;
	public Genericlib lib;
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("------------LAUNCHING BROWSER----------------------");
		lib = new Genericlib();
		lib.chromedriver(driver);
		driver = new ChromeDriver();
		lib.maximizewindow(driver);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		lib = new Genericlib();
		String url = lib.getvaluefromProp("url");
		String uname = lib.getvaluefromProp("username");
		String pass = lib.getvaluefromProp("password");
		
		driver.get(url);
		Vtiger_Commercial_Open Open = new Vtiger_Commercial_Open(driver);
		Open.login(uname, pass);
		System.out.println("------------------------LOGIN-----------------------");
	}
	
	@AfterMethod
	public void configAM()
	{
		Home_Page h1 = new Home_Page(driver);
		h1.logout();
		System.out.println("---------------------LOGOUT-------------------------");
	}

	
	@AfterClass
	public void configAC()
	{
		System.out.println("-------------------CLOSE BROWSER-----------------------");
		driver.close();
	}	
}
