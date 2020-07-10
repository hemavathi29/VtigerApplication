package Compaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_WebElement extends CreateCompaign
{
	WebDriver driver;
	
	@FindBy(name = "campaignname")
	WebElement CompName;
	
	public WebElement getCampaignName()
	{
		return CompName;
	}
	
//	@FindBy(name = "campaign_no")
//	WebElement CompNo;
//	
//	public WebElement getCompaignNo()
//	{
//		return CompNo;	
//	}
	
	@FindBy(name = "campaigntype")
	WebElement CompType;
	
	public WebElement getCompaignType()
	{
		return CompType;
	}
	
	@FindBy(name = "campaignstatus")
	WebElement CompStatus;
	
	public WebElement getCompStatus()
	{
		return CompStatus;
	}
	
	@FindBy(xpath  = "/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/img")
	WebElement CompProdName;
	
	public WebElement getCompProdName()
	{
		return CompProdName;
	}

	@FindBy(xpath = "/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")
	WebElement CompSave;
	
	public WebElement getCompSave()
	{
		return CompSave;
	}
	
	
	public POM_WebElement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

