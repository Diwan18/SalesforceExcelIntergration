package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateClass extends BaseSalesforceclass{
	@BeforeTest
	public void getvalue() {
		datafile="ExcelSalesforce";
	}
	
	@Test(dataProvider="GetValue")	
	
	public  void CreateC(String uname , String pass) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement opportunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].click();",opportunityTab);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Mohammad");
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75,000");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    WebElement OppName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
	    
	    
	    String OpportunityName = OppName.getText();
	    System.out.println(OpportunityName);
	    
	    String ExpectingText = "Salesforce Automation by Mohammad";
	    
	    Assert.assertEquals(OpportunityName, ExpectingText);
	    System.out.println("The opportunity Name is Verified");
	    driver.close();
	}

}
