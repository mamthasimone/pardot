package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class Basicemailinfo {
	WebDriver driver;
	/***********************************************************************************
	 *                           WEBELEMENTS
	 **********************************************************************************/
	By basicEmailInfoTitle= By.cssSelector("div[class='modal-header'] h4");
	By nameTextBox= By.cssSelector("input[id='name']");
	By chooseFolder= By.xpath("(//button[@type='button'])[1]");
	By chooseCampaign=By.xpath("(//button[@type='button'])[2]");
	By folderNameTxtBox=By.cssSelector("input[id='ember1101']");
	By campaignTxtBox= By.cssSelector("input[class='ember-view ember-text-field filter-by']");
	By folderNameDrop= By.cssSelector("span[title='Email Test']");
	By campaignDrop=By.cssSelector("h4.pull-left");
	By chooseSelected=By.id("select-asset");
	By textRadio=By.id("email_type_text_only");
	By saveButton=By.id("save_information");
	By cancelTemplate=By.cssSelector("[id='cancel_template']");
/*****************************************************************************************/	
	public Basicemailinfo(WebDriver driver){
		this.driver=driver;
	}
	
	//Verify that the modal window to enter Basic Email Information is open
	public void verifyBasicEmailInfoOpen(){
		WebElement basicEmailTitle= driver.findElement(basicEmailInfoTitle);
		if(basicEmailTitle.isDisplayed())
			assertEquals("Basic Email Information", basicEmailTitle.getText());
		System.out.println("Modal window for Basic Email Information is open");
	}
	// Enter Name
	public void enterName(String emailname){
		WebElement nametxtBox= driver.findElement(nameTextBox);
		if (nametxtBox.isDisplayed())
			nametxtBox.sendKeys(emailname);
		System.out.println("Name:"+ " "+emailname);
	}
	//Click on Choose Button to select a folder
	public void clickToChooseEmailFolder(){
		WebElement chooseFl=driver.findElement(chooseFolder);
		if(chooseFl.isDisplayed())
			chooseFl.click();
		System.out.println("Clicked on Choose to select email folder");	
	}
	//Input the Folder name to search filter and verify that the first result contains the text 
	//you entered in the search filter and click on it
	public void enterFolderName(String flname){
		WebElement enterflName=driver.findElement(folderNameTxtBox);
		if(enterflName.isDisplayed())
			enterflName.sendKeys(flname);
		System.out.println("Entered folder name:"+ " "+flname+" "+"to select from drop down");
		WebElement flNameDrop=driver.findElement(folderNameDrop);
		if(flNameDrop.isDisplayed())
			Assert.assertTrue(flNameDrop.getText().contains(flname));
			flNameDrop.click();
		
		System.out.println("Folder name selected from drop down");
		
	}
	//Click on the Choose Selected button in Basic Email Information Modal window
	public void clickOnChooseSelected(){
		WebElement chooseSelBtn=driver.findElement(chooseSelected);
		if(chooseSelBtn.isDisplayed())
			chooseSelBtn.click();
		System.out.println("Clicked on Choose Selected");
	}
	//Click on the Choose Button to select Campaign
	public void clickToChooseCampaign(){
		WebElement chooseCampgn=driver.findElement(chooseCampaign);
		if(chooseCampgn.isDisplayed())
			chooseCampgn.click();
		System.out.println("Clicked on Choose to select Campaign");	
	}
	//Input the Campaign name to search filter and verify that the first result contains the text 
	//you entered in the search filter and click on it
	public void enterCampaignName(String campname){
		WebElement entercampName=driver.findElement(campaignTxtBox);
		if(entercampName.isDisplayed())
			entercampName.sendKeys(campname);
		System.out.println("Entered campaign name:"+ " "+campname+" "+"to select from drop down");
		WebElement campNameDrop=driver.findElement(campaignDrop);
		if(campNameDrop.isDisplayed())
			Assert.assertTrue(campNameDrop.getText().contains(campname));
			campNameDrop.click();	
		System.out.println("Campaign selected from drop down");	
	}
	//Click on Text Radio Button
	public void clickOnTextOnlyRadio(){
		WebElement txtRadio=driver.findElement(textRadio);
		if(txtRadio.isDisplayed())
			txtRadio.click();
		System.out.println("Clicked on Text radio button");
	}
	//Click on Save in the Basic Email Information Modal window
	public void clickOnSave(){
		WebElement save=driver.findElement(saveButton);
		if(save.isDisplayed())
			save.click();
	}
	//Click on Cancel oh the window that opens prompting to select an Email Template
	public void clickOnCancelTemplate(){
		WebElement canceltemp=driver.findElement(cancelTemplate);
		if(canceltemp.isDisplayed())
			canceltemp.click();
		System.out.println("Clicked on Cancel from the Templates modal");
	}
	

}
