package OrganizationTest;

import org.testng.annotations.Test;

import BasePackage.BaseClass;
import POM_Class.Create_Organizations;
//import GenericLib.Genericlib;
import POM_Class.Home_Page;
import POM_Class.Organization_childwindow;
//import POM_Class.Organization_info;
//import POM_Class.Organization_info;
import POM_Class.Organization_page;

public class CreateOrganizationTest extends BaseClass 
{
	@Test
	public void TestStart() throws Throwable
	{
		//step1
		Home_Page h1 = new Home_Page(driver);
		h1.getOrgLink().click();
		
		//Step2
		Organization_page op = new Organization_page(driver);
		op.getorgCreateicon().click();
		
		//Step3
		Create_Organizations co = new Create_Organizations(driver);
		co.naviToInfo();
		
		lib.switchToChild(driver);
		Organization_childwindow childwind = new Organization_childwindow(driver);
		childwind.performActionChild();
		
		co.getSave().click();
		Thread.sleep(2000);
		//lib.implicityWait(driver);

		System.out.println("Executed completely");
	}
}
