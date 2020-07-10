package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.Genericlib;

public class Create_Organizations 
{
	public WebDriver driver;
	public Genericlib lib = new Genericlib();
	public String expectvalue;
	
	public Create_Organizations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgnamebox;
	public WebElement getorgnamebox() {
		return orgnamebox;
	}
	
	@FindBy(id = "phone")
	private WebElement phoneno;
	public WebElement getphoneno() {
		return phoneno;
	}
	
	@FindBy(id = "email1")
	private WebElement emailid;
	public WebElement getemailid() {
		return emailid;		
	}
	
	@FindBy(xpath = "//img[@alt = 'Select']")
	private WebElement addimgMem;
	public WebElement getaddimgMem() {
		return addimgMem;
	}
	
	@FindBy(xpath = "/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")
	private WebElement save;
	public WebElement getSave() {
		return save;
	}
	
	public void naviToInfo() throws Throwable
	{
		 getorgnamebox().sendKeys(lib.getExcelFixShee("Sheet1", 0, 0) + lib.getRandomValue());
		 getphoneno().sendKeys(lib.getExcelFixShee("Sheet1", 1, 0));
		 getemailid().sendKeys(lib.getExcelFixShee("Sheet1", 2, 0));
		 
		 getaddimgMem().click();
//		 lib.switchToChild(driver);
//		 Organization_childwindow childwind = new Organization_childwindow(driver);
//		 childwind.performActionChild();
//		 
//		 getSave().click();
//		 lib.implicityWait(driver);
		 //return new Organization_info(driver);
	}	
}
