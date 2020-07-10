package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.Genericlib;

public class CreateCampChild 
{
	public WebDriver driver;
	Genericlib lib = new Genericlib();
	
	public CreateCampChild(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "search_txt")
	private WebElement campchildsearch;
	public WebElement getcampChildSearch() {
		return campchildsearch;		
	}
	
	@FindBy(name = "search")
	private WebElement campchildbutton;
	public WebElement getcampchildhButton() {
		return campchildbutton;
	}
	
	@FindBy(xpath = "//*[@id=\"1\"]")
	private WebElement searchResult;
	public WebElement getSearchResult() {
		return searchResult;
	}
	
	public void performActionChild() throws Throwable
	{
		getcampChildSearch().sendKeys(lib.getExcelFixShee("Sheet2", 3, 1));
		getcampchildhButton().click();
		
		Thread.sleep(2000);
		getSearchResult().click();
	}
}
