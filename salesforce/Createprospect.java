package salesforce;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Createprospect {
	WebDriver driver;
	Actions action;
	/************************************************************************************
	 *                        WEBELEMENTS
	 ***********************************************************************************/
	By createProspectTitle= By.xpath(".//*[@id='pr_form_update']/form/h3");
	By email= By.cssSelector("input[id='email']");
	By campaignDropdown=By.id("campaign_id");
	By profileDropdown= By.id("profile_id");
	By createProspect= By.xpath("(//input[@type='submit'])");
	By prospectScore= By.cssSelector("input[id='score']");
	/***********************************************************************************/
	public Createprospect(WebDriver driver){
		this.driver=driver;
	}
	//Verify that the Create Prospect Page opens
	public void verifyCreateProspectPageOpen(){
		WebElement crprospect= driver.findElement(createProspectTitle);
		assertEquals("Create Prospect", crprospect.getText());
		System.out.println("You are the Create Prospect Page");
		
	}
	//Enter Prospect Email in the Create Prospect Page
	public void enterProspectEmail(String mail){		
		WebElement inputEmail=driver.findElement(email);
		if (inputEmail.isDisplayed())
		inputEmail.sendKeys(mail);
		System.out.println("Prospect email" + " "+mail+ " "+"entered");
	}
	//Select a campaign for the Prospect
	public void selectProspectCampaign(int camp){
		WebElement campaignDrop=driver.findElement(campaignDropdown);
		if(campaignDrop.isDisplayed())
			campaignDrop.click();
		System.out.println("Clicked on the drop down to select campaign for prospect");
		List <WebElement> campaign_list= campaignDrop.findElements(By.tagName("option"));
		Actions action= new Actions(driver);
		action.moveToElement(campaign_list.get(camp)).doubleClick().perform();
		String selectedOption = new Select(campaignDrop).getFirstSelectedOption().getText();
		System.out.println("You selected"+ " "+selectedOption+ " "+ "as the campaign for your prospect");
		
	}
	//Select a Profile for the Prospect
	public void selectProspectProfile(int num){
		WebElement profileDrop= driver.findElement(profileDropdown);
		if(profileDrop.isDisplayed())
			profileDrop.click();
		System.out.println("Clicked on the drop down to profile for prospect");
       List <WebElement> profile_list= profileDrop.findElements(By.tagName("option"));
        action= new Actions(driver);
		action.moveToElement(profile_list.get(num)).doubleClick().perform();	
		String profileSelected= new Select(profileDrop).getFirstSelectedOption().getText();
		System.out.println("You selected"+ " "+profileSelected+ " "+ "as the profile for your prospect");
	}
	//Enter Score for the Prospect
	public void enterScore(String score){
		WebElement scoreForProspect=driver.findElement(prospectScore);
		if(scoreForProspect.isDisplayed())
			scoreForProspect.clear();
		    scoreForProspect.sendKeys(score);
		    System.out.println("The prospect's score is" + " "+ score);
	}
	//Click on Create Prospect
	public ProspectContents clickOnCreateProspect() throws InterruptedException{
		WebElement createProspectButton= driver.findElement(createProspect);
		Actions actions = new Actions(driver);
		actions.moveToElement(createProspectButton);
		// actions.click();
		actions.perform();
		Thread.sleep(3000);
		if(createProspectButton.isDisplayed())
			createProspectButton.click();
		System.out.println("Clicked on Create Prospect Button");
		return new ProspectContents(driver);
		
	}
	
	

}
