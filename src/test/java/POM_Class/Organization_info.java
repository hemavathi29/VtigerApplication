package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_info {

	public WebDriver driver;
	
	public Organization_info(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"row_14\"]/td[3]/a")
	private WebElement orgnametext;
	public WebElement getorgnametext() {
		return orgnametext;
	}
}
