package GenericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Genericlib 
{
	public static WebDriver driver;
	public static String parentwindow;
	public static String childwindow;
	
	public void chromedriver(WebDriver driver)
	{	
		System.setProperty("webdriver.chrome.driver", "../SeleniumAuto/src/main/resources/DriverExe/chromedriver.exe");
	}
	
	public String getExcelFixShee(String sheet, int row, int col) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream finp = new FileInputStream("C:\\Users\\HEMA\\Desktop\\detailsSheet.xlsx");
		Workbook wb = WorkbookFactory.create(finp);
		Sheet sht = wb.getSheet(sheet);
		Row rw = sht.getRow(row);
		Cell cw = rw.getCell(col);
		String result = cw.toString();
		return result;
	}
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public String getvaluefromProp(String key) throws IOException
	{
		FileInputStream finp = new FileInputStream("..//SeleniumAuto/src/main/resources/DriverExe/VtigerApp.property.txt");
		Properties prop = new Properties();
		prop.load(finp);
		
		String s = prop.getProperty(key);
		return s;
	}	
	
	public int getRandomValue()
	{
		Random random = new Random();
		int randomno =  random.nextInt(100);
		return randomno;
	}
	
	public static void selectbyVisibletext(WebElement element, String initator)
	{
		Select selector1 = new Select(element);
		selector1.selectByVisibleText(initator);
	}
	
	public void switchToChild(WebDriver driver)
	{
		Set<String> allwindow = driver.getWindowHandles();
			
		Iterator<String> iteratorObj = allwindow.iterator();
		parentwindow = iteratorObj.next();			
		childwindow = iteratorObj.next();
		
		driver.switchTo().window(childwindow);
	}
	
	public void switchToParent(WebDriver driver)
	{
		driver.switchTo().window(parentwindow);
	}
	
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
