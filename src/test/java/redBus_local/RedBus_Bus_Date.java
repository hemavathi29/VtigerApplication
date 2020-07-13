package redBus_local;

import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import POM_Class.RedBusElements;

public class RedBus_Bus_Date 
{
	@Test
	public void test() throws InterruptedException
	{
		// to handle notificatin pop up
		System.setProperty("webdriver.chrome.driver", "../SeleniumAuto/src/main/resources/DriverExe/chromedriver.exe");
		ChromeOptions c1= new ChromeOptions();
		c1.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(c1);
		driver.get("https://www.redbus.in/");

		//select from place
		driver.findElement(By.id("src")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		RedBusElements redele =  new RedBusElements(driver);
		redele.getSrcplace().click();
		//driver.findElement(By.xpath("//li[contains(text(),'Bengaluru')]")).click();

		//select to place
		driver.findElement(By.id("dest")).sendKeys("Pune");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@data-id='67159']")).click();
		//select onword date by local date

		LocalDate date= LocalDate.now();
		LocalDate onwardDate= date.plusDays(50);
		LocalDate futuredDate= date.plusDays(65);

		int day = onwardDate.getDayOfMonth();
		System.out.println("day "+day);
		Month month = onwardDate.getMonth();
		String mon = month.toString().substring(0,3);

		System.out.println(mon);
		//System.out.println("month "+month);

		//String monLower = mon.toLowerCase();
		int yr = onwardDate.getYear();
		System.out.println("year "+yr); 

		//calender date selection

		//WebElement omnthYrele = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[@class='monthTitle']"));
		WebElement omnthYrele = redele.getomnthYrele();
		String actualMonth=omnthYrele.getText();		
		//System.out.println("actual text from cal " +actualMonth);

		//sliting cal date so as compare only month
		String []monthReq=actualMonth.split(" ");
		String finalMonth=monthReq[0];

		//System.out.println("final month " +finalMonth);

		while(true)  	
		{
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[contains(@class,'next')]")).click();
			omnthYrele = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[@class='monthTitle']"));
			actualMonth=omnthYrele.getText().toLowerCase().split(" ")[0];

			System.out.println("Final month in loop = " +actualMonth) ;

			Thread.sleep(2000);

			if(actualMonth.equalsIgnoreCase(mon))
			{

				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[text()='"+day+"']")).click();
				break;
			}

		}   

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[4]/div/label")).click();

		int fdate = futuredDate.getDayOfMonth();
		String fmonth = futuredDate.getMonth().toString().substring(0,3);
		int fyr = futuredDate.getYear();


		WebElement futuromnthYrele = driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/descendant::td[@class='monthTitle']"));
		String futureactualMonth=futuromnthYrele.getText();
		String []futuremonthReq=actualMonth.split(" ");
		String futurefinalMonth=monthReq[0];

		while(true)
		{
			driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/descendant::td[contains(@class,'next')]")).click();
			futuromnthYrele = driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/descendant::td[@class='monthTitle']"));
			futureactualMonth=futuromnthYrele.getText().toLowerCase().split(" ")[0];
			if(futureactualMonth.equalsIgnoreCase(fmonth))
			{
				driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/descendant::td[text()='"+fdate+"']")).click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[contains(text(),'Search Buses')]")).click();

		Thread.sleep(1000);

		driver.close();
	}	
}
