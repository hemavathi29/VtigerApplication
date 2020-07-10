package Compaign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCompaign extends Base
{
	
	@BeforeMethod
	public void launch() throws IOException
	{
		Chromedriver();
		launchURL();
		loginapp();
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	
	@Test
	public void Compaign()
	{
		WebElement Moreoption = driver.findElement(By.xpath("//a[text() = 'More']"));
		
		Actions actObj = new Actions(driver);
		actObj.moveToElement(Moreoption).build().perform();
		
		implicitwati();
		driver.findElement(By.xpath("//a[@name = 'Campaigns']")).click();
		implicitwati();

		//click on + symbol to create new compaign
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		POM_WebElement PomObj = new POM_WebElement(driver);
	
		PomObj.getCampaignName().sendKeys("Test12");
		
		WebElement Types = PomObj.getCompaignType();
		selectbyVisibletext(Types, "Conference");
		
		WebElement Status = PomObj.getCompStatus();
		selectbyVisibletext(Status, "Planning");
		
		PomObj.getCompProdName().click();
		
		switchtochild();
		
		driver.findElement(By.xpath("//input[@id = 'search_txt']")).sendKeys("xyz1");
		driver.findElement(By.xpath("//input[@name = 'search']")).click();
		implicitwati();
		
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		switchtoparenet();
		
		System.out.println("Parnet window = " +driver.getTitle());
		PomObj.getCompSave().click();
	}
}
