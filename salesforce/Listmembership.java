package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Listmembership {
	WebDriver driver;
	/********************************************************************************
	 *                             WEBELEMENTS
	 *******************************************************************************/
	By dropDownList=By.cssSelector("a[class='chzn-single chzn-default']");
	By textBox= By.xpath("(//input[@type='text'])[2]");
	By saveList= By.cssSelector("div[class='form-actions'] [class='btn btn-primary']");
	/*******************************************************************************/
	public Listmembership(WebDriver driver){
		this.driver=driver;
	}
	//Click on the Drop down to select List for Prospect
	public void clickOnDropDown(){
		WebElement dropDown= driver.findElement(dropDownList);
		if(dropDown.isDisplayed())
		     dropDown.click();
		System.out.println("Clicked on Drop Down menu");
	}
	//Enter List Name and Press Enter
	public void enterNameToSelectFromDropDown(String name){
		WebElement txtBox=driver.findElement(textBox);
		if(txtBox.isDisplayed())
			txtBox.sendKeys(name);
		System.out.println("Entered list name"+ " " +name);
		txtBox.sendKeys(Keys.ENTER);
		System.out.println("Adding Prospect to List"+ " "+ txtBox.getText());
			
	}
	//Click on Save to add Prospect to the Selected List
	public ProspectContents clickOnSaveList(){
		WebElement saveLs= driver.findElement(saveList);
		if(saveLs.isDisplayed())
			saveLs.click();
		System.out.println("Clicked on Save Lists Button");
		return new ProspectContents(driver);
		
	}

}
