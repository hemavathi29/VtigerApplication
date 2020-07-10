package Compaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	
	public static WebDriver driver;
	public static String parentwindow;
	public static String childwindow;
	
	public static void Chromedriver() 
	{
		System.setProperty("webdriver.chrome.driver", "../Selenium/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void launchURL()
	{
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
	}

	public static String getUsername() throws IOException
	{
		FileInputStream fileinput = new FileInputStream("../Selenium/ChromeDriver/qwerty.properties");
		Properties propobject = new Properties();
		propobject.load(fileinput);
		
		String uname = propobject.getProperty("username");
		return uname;
	}
	
	public static String getPassword() throws IOException
	{
		FileInputStream fileinput = new FileInputStream("../Selenium/ChromeDriver/qwerty.properties");
		Properties propobject = new Properties();
		propobject.load(fileinput);	
		
		String pword = propobject.getProperty("password");
		return pword;
	}
	
	
	public void loginapp() throws IOException 
	{
		String username1=getUsername();
		String password1=getPassword();
		driver.findElement(By.name("user_name")).sendKeys(username1);
		driver.findElement(By.name("user_password")).sendKeys(password1);
		driver.findElement(By.id("submitButton")).click();
	}
	
	public static void selectbyVisibletext(WebElement element, String initator)
	{
		Select selector1 = new Select(element);
		selector1.selectByVisibleText(initator);
	}
	
	//to switch from parent to child window 
	public static void switchtochild()
	{
		Set<String> allwindow = driver.getWindowHandles();
		
		Iterator<String> iteratorObj = allwindow.iterator();
		parentwindow = iteratorObj.next();
		childwindow = iteratorObj.next();

		driver.switchTo().window(childwindow);
	}
	
	//to switch from child to parent window 
	public static void switchtoparenet()
	{
		driver.switchTo().window(parentwindow);
	}
	
	public static void implicitwati()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
