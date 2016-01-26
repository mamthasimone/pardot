package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Updatelistinfo {
	WebDriver driver;
	/***********************************************************************************
	 *                         WEBELEMENTS
	 **********************************************************************************/
	By updateListName= By.cssSelector("div[class='controls'] [id='name']");
	By updateButton= By.cssSelector("div [class='modal-footer'] [id='save_information']");
	/**********************************************************************************/
	public Updatelistinfo(WebDriver driver){
		this.driver=driver;
	}
	//Rename List in the List Information modal window
	public void renameList(String rename){
		WebElement updateLsName= driver.findElement(updateListName);
		if(updateLsName.isDisplayed())
			updateLsName.clear();
		System.out.println("Cleared input field for list name");
		updateLsName.sendKeys(rename);
	}
	//Click on update in the List Information Modal
	public Listinformation clickOnUpdate(){
		WebElement updateBtn=driver.findElement(updateButton);
		if (updateBtn.isDisplayed())
			updateBtn.click();
		System.out.println("Clicked on Update Button");
		return new Listinformation(driver);
	}

}
