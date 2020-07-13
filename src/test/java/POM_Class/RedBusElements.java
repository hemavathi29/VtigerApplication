package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBusElements 
{
	public WebDriver driver;
	public RedBusElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[contains(text(),'Bengaluru')]")
	private WebElement srcplace;
	public WebElement getSrcplace() {
		return srcplace;
	}
	
	@FindBy(xpath = "//div[@id='rb-calendar_onward_cal']/descendant::td[@class='monthTitle']")
	private WebElement omnthYrele;
	public WebElement getomnthYrele() {
		return omnthYrele;
	}
	
//	@FindBy(xpath = "//div[@id='rb-calendar_onward_cal']/descendant::td[contains(@class,'next')]")
//	private WebElement 
	
}
