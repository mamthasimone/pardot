package salesforce;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Testscenarios {
	WebDriver driver= new FirefoxDriver();
	Login mylogin;
	Createnewlist create;
	Dashboard dash;
	Segmentation segment;
	Listinformation ls;
	Listdetails ld;
	Updatelistinfo update;
	Prospectinfo prospect;
	ProspectContents procontent;
	Createprospect newprospect;
	Listmembership lsmember;
	Emailslist elist;
	Basicemailinfo emailinfo;
	Logout lout;
	
	
	@Before
	public void LoginToSalesforce(){
		mylogin= new Login(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://pi.pardot.com");	
		dash=mylogin.LoginWithCredentials("pardot.applicant@pardot.com", "Applicant2012");
		
	}
	
	@Test
	public void CreateList() {
		System.out.println("TEST CASE:1 Executing CREATE LIST test case");			
		dash.clickOnMarketing();
		dash.clickOnSegementation();
		segment= new Segmentation(driver);	
		create=segment.clickOnAddListButton();	
		create.enterListName("list6783342");
		ls=create.clickOnCreate();
		ls.verifyListWasCreated("list6783342");				
	}
	
	@Test
	public void verifyErrorDuplicateList() throws InterruptedException{
		System.out.println("TEST CASE:2 Verify error message is displayed when creating a list with an already existing List Name");	
		dash.clickOnMarketing();
		dash.clickOnSegementation();
		segment= new Segmentation(driver);	
		create=segment.clickOnAddListButton();		
		create.enterListName("oklahomalist");	
		create.clickOnCreate();
		create.verifydisplayErrormessage();	
		ls= create.clickOnCancel();			
	}
	
	@Test
	public void renameList() throws InterruptedException{
		System.out.println("TEST CASE:3 Create a List and Rename it. Verify that another List can be created with the original name");
		dash=new Dashboard(driver);		
		dash.clickOnMarketing();
		dash.clickOnSegementation();
		segment= new Segmentation(driver);	
		create=segment.clickOnAddListButton();		
		create=new Createnewlist(driver);
		create.enterListName("list1200");
		Listinformation ls= new Listinformation(driver);
		ls=create.clickOnCreate();		
		ls.verifyListWasCreated("list1200");
		Updatelistinfo update= new Updatelistinfo(driver);
		update=ls.clickOnEdit();	
		update.renameList("list1300");
		ls=update.clickOnUpdate();	
		ls.verifyListWasUpdated("list1300");
		segment=ls.clickOnListLink();	
		create=segment.clickOnAddListButton();	
		create.enterListName("list1200");
		ls=create.clickOnCreate();	
		ls.verifyListWasCreated("list1200");		
	}
	
	@Test
	public void createProspect() throws InterruptedException {
		System.out.println("TEST CASE 4: Create a Prospect");
		dash.clickOnProspect();		
		prospect=dash.clickOnProspectList();
		prospect.verifyProspectInfoPageOpen();
		newprospect=prospect.clickOnAddProspect();	
		newprospect.verifyCreateProspectPageOpen();
		newprospect.enterProspectEmail("prospect18@gmail.com");
		newprospect.selectProspectCampaign(13);		
		newprospect.selectProspectProfile(7);
		newprospect.enterScore("10");	
		procontent=new ProspectContents(driver);
		procontent= newprospect.clickOnCreateProspect();			
	}
	
	@Test
	public void addProspectToListAndValidate() throws InterruptedException{
		System.out.println("TEST CASE 5: Add Prospect to List and Verify that the Prospect was added successfuly to the List");
		//add Prospect to List
		dash.clickOnProspect();
		prospect=dash.clickOnProspectList();
		prospect.verifyProspectInfoPageOpen();	
		procontent=prospect.clickOnProspectToAddToList("new@gmail.com");
		procontent.verifyProspectContentPageOpen();
		lsmember=procontent.clickOnList();
		lsmember.clickOnDropDown();
		lsmember.enterNameToSelectFromDropDown("colorlist");
		procontent=lsmember.clickOnSaveList();
		procontent.verifyAlert();
		//verify if the prospect was added successfully to the list
		dash.clickOnMarketing();
		segment=dash.clickOnSegementation();
		segment.verifySegmentationPageOpen();		
		ld=segment.openListToViewDetails("colorlist");
		ld.verifyListDetailsPageOpen();
		ld.verifyProspectAddedToList("new@gmail.com");	
	}
	
	@Test	
	public void sendEmail() throws InterruptedException{
	System.out.println("TEST CASE 6: Send Text Only Email to List");
	dash=new Dashboard(driver);		
	dash.clickOnMarketing();
	elist=dash.clickOnEmail();
	elist.verifyEmailsListPageOpen();
	emailinfo=elist.clickOnSendNewEmail();
	emailinfo.verifyBasicEmailInfoOpen();
	emailinfo.enterName("myemail");
	emailinfo.clickToChooseEmailFolder();
	emailinfo.enterFolderName("Email Test");
	emailinfo.clickOnChooseSelected();
	emailinfo.clickToChooseCampaign();
	emailinfo.enterCampaignName("Kat Eagles");
	emailinfo.clickOnChooseSelected();
	emailinfo.clickOnTextOnlyRadio();
	emailinfo.clickOnSave();
	emailinfo.clickOnCancelTemplate();
	}
	
	@After	
	public void lOut() {
		System.out.println("Logging out");
		lout=new Logout(driver);
		lout.clickOnUserName();
		lout.clickOnSignOut();
		driver.quit();
	}
	
	
	
	
	

}
