package testngebaytestdataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testutility.TestUtil;

public class Halfebaytest 

{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Suresh/Selenium Configuration/chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&UsingSSL=1&co_partnerId=2&errmsg=&src=&ru=http%3A%2F%2Fmy.ebay.com%2Fws%2FeBayISAPI.dll%3FMyEbayBeta%26MyEbay%3D%26gbh%3D1%26guest%3D1&signInUrl=https%3A%2F%2Fsignin.ebay.com%3A443%2Fws%2FeBayISAPI.dll%3FSignIn%26UsingSSL%3D1%26pUserId%3D%26co_partnerId%3D2%26siteid%3D0%26ru%3Dhttp%253A%252F%252Fmy.ebay.com%252Fws%252FeBayISAPI.dll%253FMyEbayBeta%2526MyEbay%253D%2526gbh%253D1%2526guest%253D1%26pageType%3D3984&rv4=1");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getDatafromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void registerebay(String firstname,String lastname, String emailid,String Password)
	{
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailid);
		
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(Password);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
