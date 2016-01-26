package salesforce;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Prospectinfo {
	WebDriver driver;
	/************************************************************************************
	 *                          WEBELEMENTS
	 ***********************************************************************************/
	By prospectTitle=By.cssSelector("div[id='content'] h1");
	By addProspectButton=By.cssSelector("[id='pr_link_create']");
	By prospectFilter= By.cssSelector("input[id='prospect_table_filter']");
	/************************************************************************************/
	public Prospectinfo(WebDriver driver){
		this.driver= driver;		
	}
	//Verify the Prospect Information Page Opens
	public void verifyProspectInfoPageOpen(){
		WebElement prospectpage= driver.findElement(prospectTitle);
		assertEquals("Prospects", prospectpage.getText());
		System.out.println("You are on the Prospect Page that lists the prospects created");	
	}
	//Click on Add Prospect Button
	public Createprospect clickOnAddProspect(){
		WebElement addProspect= driver.findElement(addProspectButton);
		if(addProspect.isDisplayed())
			addProspect.click();
		System.out.println("Clicked on Add Prospect");
		return new Createprospect(driver);
		
	}
	//Search for the Prospect and click on it to add to List 
	public ProspectContents clickOnProspectToAddToList(String prospectname){
		String xpath1="//a[contains(text(),'";
		String xpath2="')]";
		WebElement enterProspect= driver.findElement(prospectFilter);
		if(enterProspect.isDisplayed())
			enterProspect.sendKeys(prospectname);
		WebElement myprospect=driver.findElement(By.xpath(xpath1+prospectname+xpath2));
		if(myprospect.isDisplayed())
			myprospect.click();
		System.out.println("Clicked on my prospect" + " "+ prospectname);
		return new ProspectContents(driver);
		
	}
	
	

}
