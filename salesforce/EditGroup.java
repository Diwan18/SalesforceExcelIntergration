package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditGroup extends BaseSalesforceclass{
	
	@BeforeTest
	public void getvalue() {
		datafile="EditGExcel";
	}
	
	
	@Test(dataProvider="GetValue")
	public  void EditG(String uname , String pass , String Searchbox) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		
		Actions click = new Actions(driver);
		
		WebElement workTypeGroups = driver.findElement(By.xpath("//span/p[text()='Work Type Groups']"));
		
		click.moveToElement(workTypeGroups).click().perform();
		
		Thread.sleep(5000);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Mohammad",Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By MohammadDiwan']"));
		Thread.sleep(8000);
		String text = table.getText();
		if(text.contains(Searchbox)) {
			WebElement downicon = driver.findElement(By.xpath("//table/tbody/tr/td/span/div/a"));
			
			
			Executer.executeScript("arguments[0].click();",downicon);
		}
		
		
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).clear();
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		
		WebElement groupname = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By MohammadDiwan']"));
		Executer.executeScript("arguments[0].click();",groupname);
		WebElement Description = driver.findElement(By.xpath("//slot/lightning-formatted-text[text()='Automation']"));
		String desctext = Description.getText();
		System.out.println(desctext);
		if(desctext.equalsIgnoreCase("Automation")) {
			System.out.println("Description is verified ");
			
			
		}else {
			System.out.println("Description is not matched");
		}
		
		driver.close();
	}

}
