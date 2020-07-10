package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.Genericlib;

public class Organization_childwindow 
{
	public WebDriver driver;
	Genericlib lib = new Genericlib();
	
	public Organization_childwindow(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement orgchildsearch;
	public WebElement getOrgChildSearch() {
		return orgchildsearch;		
	}
	
	@FindBy(name = "search")
	private WebElement orgchildbutton;
	public WebElement getOrgchildhButton() {
		return orgchildbutton;
	}
	
	@FindBy(xpath = "//*[@id=\"1\"]")
	private WebElement searchResult;
	public WebElement getSearchResult() {
		return searchResult;
	}
	
	public void performActionChild() throws Throwable
	{
		getOrgChildSearch().sendKeys(lib.getExcelFixShee("Sheet1", 3, 0));
		getOrgchildhButton().click();
		
		Thread.sleep(2000);
		getSearchResult().click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		lib.switchToParent(driver);	
		Thread.sleep(2000);
	}
}

