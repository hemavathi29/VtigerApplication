package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLib.Genericlib;

public class CreateCompaingPage 
{
	public WebDriver driver;
	Genericlib lib = new Genericlib();
	
	public CreateCompaingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campnamebox;
	public WebElement getCampNambBox() {
		return campnamebox;
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement addProdButton;
	public WebElement getaddProdButton() {
		return addProdButton;
	}
	
	@FindBy(name = "campaigntype")
	private WebElement CamptypeBox;
	public WebElement getCamptypeBox() {
		return CamptypeBox;
	}
	
	@FindBy(id = "sponsor")
	private WebElement campSponsorName;
	public WebElement getcampSponsorName() {
		return campSponsorName;
	}

	@FindBy(xpath = "//input[@class= 'crmButton small save']")
	private WebElement Savebutton;
	public WebElement getSavebutton() {
		return Savebutton;
	}
		
	public void uploadCampData() throws Throwable {
		getCampNambBox().sendKeys(lib.getExcelFixShee("Sheet2", 0, 1) + lib.getRandomValue());
		getcampSponsorName().sendKeys(lib.getExcelFixShee("Sheet2", 1, 1));
		WebElement camptype = getCamptypeBox();
		String campinit = lib.getExcelFixShee("Sheet2", 2, 1);
		Genericlib.selectbyVisibletext(camptype,campinit);
		
		getaddProdButton().click();
	}	
}
