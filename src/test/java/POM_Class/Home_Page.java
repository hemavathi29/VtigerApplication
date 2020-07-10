package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath = "//img [@src='themes/softed/images/Home.PNG']")
	private WebElement homeLink;
	public WebElement gethomeLink(){
		return homeLink;	
	}
	
	@FindBy(xpath = "//td[@class = 'tabUnSelected']/a[text() = 'Organizations']")
	private WebElement OrgLink;
	public WebElement getOrgLink() {
		return OrgLink;
	}
	
	@FindBy(xpath = "//td[@class = 'tabUnSelected']/a[text() = 'Contacts']")
	private WebElement ContactsLink;
	public WebElement getContactsLink() {
		return ContactsLink;
	}
	
	@FindBy(xpath = "//td[@class = 'tabUnSelected']/a[text() = 'More']")
	private WebElement MoreLink;
	public WebElement getMoreLink() {
		return MoreLink;
	}
	
	@FindBy(xpath = "//a[@name= 'Campaigns']")
	private WebElement CampLink;
	public WebElement getCampLink() {
		return CampLink;
	}
	
	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement adminicon;
	public WebElement getadminicon() {
		return adminicon;
	}
	
	@FindBy(xpath = "//a[text() = 'Sign Out']")
	private WebElement SignOutLink;
	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	 
	public Home_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Organization_page navigateToOrg() {
		getOrgLink().click();
		return new Organization_page(driver);
	}
	
	public void logout() 
	{
		getadminicon().click();
		getSignOutLink().click();
	}
	
	public CompaignPage navigateToMoreCompain() {
		getMoreLink().click();
		getCampLink().click();
		return new CompaignPage(driver);
	}
	
	public ContactPage navigateToContact() {
		getContactsLink().click();
		return new ContactPage(driver);
	}
}
