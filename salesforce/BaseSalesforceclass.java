package salesforce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ReadExcelSheet;


public class BaseSalesforceclass {
	

	public String datafile;
	public  ChromeDriver driver;
	public ChromeOptions chromeoption;
	
	@BeforeMethod	
	public void PreCondition() {
		
		chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");		
		driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
	}
	
	@AfterMethod
	public void PostCondition() {
		
	driver.quit();
	}
	
	
	@DataProvider(name="GetValue" )
	public String[][] data() throws IOException{
		

		
		return ReadExcel.readExcel(datafile);	
		
		
	}
	
	
	
		
		
		
	

}
