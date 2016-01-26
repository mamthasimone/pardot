package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	WebDriver driver;
	/****************************************************************************************
	 *                            WEBELEMENTS
	 **************************************************************************************/
	By userName=By.xpath(".//*[@id='acct-tog']/span");
	By signOut= By.cssSelector("ul[id='dropmenu-account'] li:nth-child(8) a");
	/**************************************************************************************/
	public Logout(WebDriver driver){
		this.driver=driver;
	}
	//Click on User Name on the top right corner
	public void clickOnUserName(){
		WebElement name= driver.findElement(userName);
		if(name.isDisplayed())
			name.click();
		System.out.println("Clicked on User Name");
	}
	//Logout
	public void clickOnSignOut(){
		WebElement sOut=driver.findElement(signOut);
		if(sOut.isDisplayed())
			sOut.click();
		
	}
	

}
