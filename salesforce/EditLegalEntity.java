package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLegalEntity extends BaseSalesforceclass {
	@BeforeTest
	public void getvalue() {
		datafile="ExcelSalesforce2";
	}
	
	
	@Test(dataProvider="GetValue")
	public  void EditLegalEntityC(String uname , String pass) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
		Actions action = new Actions(driver);
		WebElement legalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		action.moveToElement(legalEntity).click().perform();
		
		Thread.sleep(5000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Diwan",Keys.ENTER);
		
		Thread.sleep(5000);
		
		WebElement dropicon = driver.findElement(By.xpath("//table/tbody/tr/td/span/div/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dropicon);
		Thread.sleep(5000);
		 WebElement clickEdit = driver.findElement(By.xpath("//a[@title='Edit']"));
		executor.executeScript("arguments[0].click();", clickEdit);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys("Salesforce");
		Thread.sleep(5000);
		WebElement Status = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		executor.executeScript("arguments[0].click();", Status);
		
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement LegalEntityName = driver.findElement(By.xpath("//table/tbody/tr/th/span/a"));
		executor.executeScript("arguments[0].click();", LegalEntityName);
		
		WebElement CheckStatus = driver.findElement(By.xpath("//div//slot/lightning-formatted-text[text()='Active']"));
		String statusvalue = CheckStatus.getText();
		System.out.println(statusvalue);
		
		Assert.assertEquals(statusvalue, "Active");
		System.out.println("The Status is Active");
		driver.close();

	}

}
