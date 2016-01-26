package salesforce;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Listdetails {
	WebDriver driver;
	/*************************************************************************************
	 *                     WEBELEMENTS
	 ************************************************************************************/
	By listName= By.cssSelector("div[id='content'] h1");
	By prospectFilter= By.cssSelector("input[id='listxProspect_table_filter']");
	/*********************************************************************************/
         public Listdetails(WebDriver driver){
        	 this.driver=driver;
         }
  
        //Verify that when clicked on a List Name, the List Details Page opens 
         public void verifyListDetailsPageOpen(){
	     WebElement lsName= driver.findElement(listName);
	     if(lsName.isDisplayed())
		 System.out.println("You are viewing the details for the list"+ " "+lsName.getText());
         }
        //Verify that the Prospect was added to the List
         public void verifyProspectAddedToList(String prospectname){
	     WebElement prospectFil= driver.findElement(prospectFilter);
	     if(prospectFil.isDisplayed())
		 prospectFil.sendKeys(prospectname);
	     String xpath1="//a[contains(text(),'";
	     String xpath2="')]";
	     WebElement prospect=driver.findElement(By.xpath(xpath1+prospectname+xpath2));
	     if(prospect.isDisplayed())
		 assertEquals(prospectname, prospect.getText());	 
	 
          }
         
}
