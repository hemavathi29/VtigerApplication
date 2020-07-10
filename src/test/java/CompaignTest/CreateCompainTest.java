package CompaignTest;

import org.testng.annotations.Test;

import BasePackage.BaseClass;
import GenericLib.Genericlib;
import POM_Class.CompaignPage;
import POM_Class.CreateCampChild;
import POM_Class.CreateCompaingPage;
import POM_Class.Home_Page;

public class CreateCompainTest extends BaseClass
{
	@Test
	public void TestStart() throws Throwable
	{
		Home_Page hp = new Home_Page(driver);
		hp.navigateToMoreCompain();
		
		CompaignPage cp = new CompaignPage(driver);
		cp.navigateTocreateCompaing();
		lib.implicityWait(driver);
		
		CreateCompaingPage Ccp = new CreateCompaingPage(driver);
		Ccp.uploadCampData();
		
		Genericlib lib = new Genericlib();
		lib.switchToChild(driver);
		
		CreateCampChild Campchild = new CreateCampChild(driver);
		Campchild.performActionChild();
		
		lib.switchToParent(driver);
		Ccp.getSavebutton().click();
		
		System.out.println("Execution Done");
	}
}
