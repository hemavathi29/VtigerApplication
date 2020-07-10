package POM_Class;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.Genericlib;

public class CreateContactPage 
{
	public WebDriver driver;
	Genericlib lib = new Genericlib();
	
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "salutationtype")
	private WebElement surname;
	public WebElement getSurname() {
		return surname;
	}
	
	@FindBy(name = "firstname")
	private WebElement FirstName;
	public WebElement getFirstName() {
		return FirstName;
	}

	@FindBy(name = "lastname")
	private WebElement LastName;
	public WebElement getLastName() {
		return LastName;
	}
	
	@FindBy(id = "mobile")
	private WebElement MobileNo;
	public WebElement getMobileNo() {
		return MobileNo;
	}


	@FindBy(xpath = "//input[@class = 'crmButton small save']")
	private WebElement Savebutton;
	public WebElement getSavebutton() {
		return Savebutton;
	}

	public void uploadDataToContact() throws Throwable
	{
		getSurname().sendKeys(lib.getExcelFixShee("Sheet3", 0, 0));
		getFirstName().sendKeys(lib.getExcelFixShee("Sheet3", 0, 1));
		getLastName().sendKeys(lib.getExcelFixShee("Sheet3", 0, 2));
		getMobileNo().sendKeys(lib.getExcelFixShee("Sheet3", 0, 3));
		getSavebutton().click();
	}
}
