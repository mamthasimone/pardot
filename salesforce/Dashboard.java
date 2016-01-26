package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
	/*****************************************************************
	 *               WEBELEMENTS
	 *****************************************************************/
	By marketing= By.className("icon-magic");
	By segmentation= By.cssSelector("ul[id='dropmenu-marketing'] li:nth-child(11) a");
	By prospect= By.cssSelector("[class='icon-group']");
	By prospectList= By.cssSelector("ul[id='dropmenu-prospects'] li:nth-child(1) a");
	By emails=By.cssSelector("ul[id='dropmenu-marketing'] li:nth-child(7) a");
    By addList= By.id("listxistx_link_create");
   /*******************************************************************/
    WebDriver driver;
    Dashboard dash;
    
    
    public Dashboard(WebDriver driver){
		this.driver= driver;
	}
    
    //Click on the Marketing Menu from the Dashboard Page
    public void clickOnMarketing(){
    	WebElement marketingmenu= driver.findElement(marketing);
    	if(marketingmenu.isDisplayed())
    		marketingmenu.click();
    	System.out.println("Clicked on marketing menu");
    }
    //Click on sub-menu Segmentation
    public Segmentation clickOnSegementation(){
    	WebElement segmentationsubmenu= driver.findElement(segmentation);
    	if(segmentationsubmenu.isDisplayed())
    		segmentationsubmenu.click();
    	System.out.println("Clicked on segmentation");
    	return new Segmentation(driver);	   			
    }
    //Click on sub-menu Email
    public Emailslist clickOnEmail(){
    	WebElement email= driver.findElement(emails);
    	if(email.isDisplayed())
    		email.click();
    	return new Emailslist(driver);
    	
    }
    //Click on Prospect
    public void clickOnProspect(){
    	WebElement prospectmenu= driver.findElement(prospect);
    	if(prospectmenu.isDisplayed())
    		prospectmenu.click();
    	System.out.println("Clicked on prospect menu");	
    }
    //Click on sub-menu Prospect List
    public Prospectinfo clickOnProspectList(){
    	WebElement prospectls= driver.findElement(prospectList);
    	if(prospectls.isDisplayed())
    		prospectls.click();
    	System.out.println("Clicked on Prospect List");
    	return new Prospectinfo(driver);
    }
    
    
}
