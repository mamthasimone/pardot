package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Createnewlist {
	/**************************************************************************************
	 *                          WEBELEMENTS
	 ************************************************************************************/
	By listName= By.cssSelector("input[id=name]");
	By createList= By.cssSelector("div[class='modal-footer'] [class='btn btn-primary']");
    By cancelButton= By.cssSelector("div[class='modal-footer'] [class='btn btn-default']");
    By errorMessage= By.cssSelector("div[id='li_form_update'] div");
    /**************************************************************************************/
    WebDriver driver;
    Createnewlist create;
    Segmentation segment;
    
   public Createnewlist(WebDriver driver){
		this.driver= driver;
	}
   //Enter the List Name to Create a List
   public void enterListName(String lname){
	   WebElement listnm= driver.findElement(listName);
	   if(listnm.isDisplayed())
		   listnm.sendKeys(lname);
   }
   //Click on the Create Button to create a list
   public Listinformation clickOnCreate(){
	   WebElement clist= driver.findElement(createList);
	   if(clist.isDisplayed())
		   clist.click();
	   System.out.println("Created a new list");
	   return new Listinformation(driver);
   }
   //Click on Cancel Button in the Create List Page
   public Listinformation clickOnCancel(){
	   WebElement cancel= driver.findElement(cancelButton);
	   if(cancel.isDisplayed())
		   cancel.click();
	   System.out.println("Clicked on cancel");
	   return new Listinformation(driver);
   }
   //Verify that an error message is displayed upon entering an already existing List Name
   public void verifydisplayErrormessage(){
	   WebElement errormsg=driver.findElement(errorMessage);
			   if(errormsg.isDisplayed())
				   System.out.println("Error message displayed:"+ " "+errormsg.getText());
			   
   }
   
   
    
    
    
  
}
