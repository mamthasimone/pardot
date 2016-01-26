package salesforce;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Listinformation {
	WebDriver driver;
	/**************************************************************************************
	 *                              WEBELEMENTS
	 *************************************************************************************/
	By listLink = By.cssSelector("ul[id='bread-crumbs'] li:nth-child(7) a");
	By editLink = By.cssSelector("ul[class='nav nav-pills'] li:nth-child(1) a");
	
	public Listinformation(WebDriver driver){
		this.driver=driver;
	}
	//Verify the List was created successfully
	public void verifyListWasCreated(String lsname){
		WebElement validatelistwascreated=driver.findElement(By.cssSelector("div[id='content'] h1"));      
       assertEquals(lsname,validatelistwascreated.getText());
       System.out.println(lsname +" "+"list is successfully created");	
	}
	//Click Edit Button to make changes to list
	public Updatelistinfo clickOnEdit(){
		WebElement edit= driver.findElement(editLink);
		if (edit.isDisplayed())
			edit.click();
		System.out.println("Clicked on Edit");
		return new Updatelistinfo(driver);
		
	}
	//Verify that List Name was updated after Renaming 
	public void verifyListWasUpdated(String lsname){
		WebElement validatelistwascreated=driver.findElement(By.cssSelector("div[id='content'] h1"));      
       assertEquals(lsname,validatelistwascreated.getText());
       System.out.println("The list was successfully renamed to"+ " "+ lsname);
		
	}
	//Click on the link Lists
	public Segmentation clickOnListLink(){
		WebElement list= driver.findElement(listLink);
		if (list.isDisplayed())
			list.click();
		return new Segmentation(driver);
	}

}
