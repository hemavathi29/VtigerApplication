package redBus_local;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UrbanLadder 
{
	@Test
	public void getAllMenu() throws Throwable
	{
		System.setProperty("webdriver.gecko.driver", "../Selenium_Practice/Driver exe/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// close the pop up
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();

		//get all the items
		List<WebElement> list=	driver.findElements(By.xpath("//div[@id='topnav_wrapper']//child::span[@class='topnav_itemname']"));

		for (int i = 0; i < list.size(); i++) 
		{
			String str =list.get(i).getText();
			System.out.println("\n"+ str);
			System.out.println("-----------");
			//Hovering mouse on each element
			Actions action= new Actions(driver);
			action.moveToElement(list.get(i)).build().perform();
			Thread.sleep(1000);
			//Build the xpath to get the outer sub menu

			String outersubmenu="//div[@id='topnav_wrapper']//child::span[contains(text(),'"+str
					+"')]//parent::li//child::div[@class='taxontype']//child::a";

			//Retrieving all the outer sub menu items in a list and traversing through each one
			Thread.sleep(3000);
			List<WebElement> outersubmenuitems =driver.findElements(By.xpath(outersubmenu));
			for (int j = 0; j < outersubmenuitems.size(); j++) 
			{
				String outersubmenuitemname= outersubmenuitems.get(j).getText();
				System.out.println(outersubmenuitemname);
				System.out.println("-----------------");

				// Retrieving all the outer sub menu item in a list & traversing through each of them
				String innerSubmenu= "//div[@id='topnav_wrapper']//child::span[contains(text(),'"+str+
						"')]//parent::li//child::div[@class='taxontype']//child::a[text()='"+ outersubmenuitemname +
						"']//ancestor::li[@class='sublist_item']//ul[@class='taxonslist']//span";

				//Retrieving all the  sub menu items
				List<WebElement> innersubmenuitemname	=driver.findElements(By.xpath(innerSubmenu));
				Thread.sleep(3000);
				for (int k = 0; k <innersubmenuitemname.size() ; k++) 
				{
					String innersubmenuitemname1 =	innersubmenuitemname.get(k).getText();
					System.out.println(innersubmenuitemname1);
				}
				System.out.println();
			}
			System.out.println("-----------");
		}
	}
}
