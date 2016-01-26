package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class Emailslist {
	WebDriver driver;
	/**************************************************************************************
	 *                          WEBELEMENTS
	 *************************************************************************************/
	By emailstitle= By.cssSelector("div[id='content'] h1");
	By sendNewEmailButton= By.cssSelector("a[class='btn btn-warning']");
	/************************************************************************************/
	public Emailslist(WebDriver driver){
		this.driver=driver;
	}
	//Verify that the Emails Page Opens
	public void verifyEmailsListPageOpen(){
		WebElement emailtitle= driver.findElement(emailstitle);
		if (emailtitle.isDisplayed())
			assertEquals("Emails",emailtitle.getText());
		System.out.println("You are on the Emails Page");				
	}
	//Click on Send New Email
	public Basicemailinfo clickOnSendNewEmail(){
		WebElement sendNewEmailBtn= driver.findElement(sendNewEmailButton);
		if(sendNewEmailBtn.isDisplayed())
			sendNewEmailBtn.click();
		System.out.println("Clicked on send new email button");
		return new Basicemailinfo(driver);
		
	}

}
