package ContactTest;

import org.testng.annotations.Test;

import BasePackage.BaseClass;
import POM_Class.ContactPage;
import POM_Class.CreateContactPage;
import POM_Class.Home_Page;

public class CreateContactTest extends BaseClass
{
	@Test
	public void TestStart() throws Throwable
	{
		Home_Page hp = new Home_Page(driver);
		hp.navigateToContact();
		
		ContactPage cp = new ContactPage(driver);
		cp.createContactPage();
		
		CreateContactPage CCP = new CreateContactPage(driver);
		CCP.uploadDataToContact();
	}
}
