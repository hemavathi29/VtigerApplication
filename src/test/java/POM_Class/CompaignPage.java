package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignPage 
{
	public WebDriver driver;
	
	public CompaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement imgaddbutton;
	public WebElement getimgaddbutton() {
		return imgaddbutton;
	}
	
	public CreateCompaingPage navigateTocreateCompaing() {
		getimgaddbutton().click();
		return new CreateCompaingPage(driver);
	}
}
