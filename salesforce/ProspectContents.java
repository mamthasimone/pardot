package salesforce;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProspectContents {
	WebDriver driver;
	Dashboard dash;
	Prospectinfo prospect;
	/***************************************************************************************
	 *                            WEBELEMENTS
	 *************************************************************************************/
	By prospecttitle= By.cssSelector("div[id='content'] h1");
	By listLink= By.cssSelector("ul[class='nav'] li:nth-child(2) a");
	By alertMessage= By.cssSelector("div[class='alert alert-info']");
	
	public ProspectContents(WebDriver driver){
		this.driver=driver;
	}
	
	//Verify that the Prospect Details Page Opens
	public void verifyProspectContentPageOpen(){
		WebElement prospectname=driver.findElement(prospecttitle);
		if(prospectname.isDisplayed())
			System.out.println("You are looking at the details for"+ " " + prospectname.getText());
	}
	//Click on Lists
	public Listmembership clickOnList(){
		WebElement lsLink= driver.findElement(listLink);
		if(lsLink.isDisplayed())
			lsLink.click();
		System.out.println("Clicked on List and navigating to the list memebership page");
		return new Listmembership(driver);
		
	}
	//After a Prospect was created, verify that the alert message is displayed
	public void verifyAlert(){
		WebElement alert= driver.findElement(alertMessage);
		if (alert.isDisplayed())
			assertEquals("Prospect lists saved successfully", alert.getText());
		
	}

}
