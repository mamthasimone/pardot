package salesforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Segmentation {
	WebDriver driver;
	/***************************************************************************************
	 *                         WEBELEMENTS
	 ***************************************************************************************/
	By addListButton= By.id("listxistx_link_create");
	By filterList= By.cssSelector("input[id='listx_table_filter']");
	By segmentationTitle= By.cssSelector("div[id='content'] h1");
	/*************************************************************************************/
	Segmentation segment;
	Createnewlist create;
	
	public Segmentation(WebDriver driver){
		this.driver=driver;
	}
	//Verify that the page loaded is the Segmentation Page
	public void verifySegmentationPageOpen(){
		WebElement segmentTitle=driver.findElement(segmentationTitle);
		if(segmentTitle.isDisplayed())
			System.out.println("You are on"+" " +segmentTitle.getText()+ "page");
	}
	//Click on the Add List Button
	public Createnewlist clickOnAddListButton(){
		WebElement addList= driver.findElement(addListButton);
		if(addList.isDisplayed())
			addList.click();
		System.out.println("Clicked on add list");
		return new Createnewlist(driver);
		
	}
	//Search for List and click on it to View the selected List Details
	public Listdetails openListToViewDetails(String listname) throws InterruptedException{
		WebElement lsName=driver.findElement(filterList);
		if(lsName.isDisplayed())
			lsName.sendKeys(listname);
		System.out.println("Looking for"+ " "+ listname+ "to add Prospect");
		Thread.sleep(3000L);
		String xpath1="//a[contains(text(),'";
		String xpath2="')]";
		WebElement myList=driver.findElement(By.xpath(xpath1+listname+xpath2));
		if(myList.isDisplayed())
			myList.click();
		System.out.println("Clicked on my List" + " "+ listname);
		return new Listdetails(driver);		
		
	}
	
	

}
