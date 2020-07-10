package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_page 
{
	public WebDriver driver;
	
	@FindBy(xpath = "//img[@alt = 'Create Organization...']")
	private WebElement orgCreateicon;
	public WebElement getorgCreateicon() {
		return orgCreateicon;
	}
	
	public Organization_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public Create_Organizations navigateToCreateOrg()
	{
		getorgCreateicon().click();
		return new Create_Organizations(driver);
	}
}

