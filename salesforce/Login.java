package salesforce;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;
	Createnewlist create;
	/****************************************************************************************
	 *                               WEBELEMENTS
	 **************************************************************************************/
	By usrname = By.id("email_address");
    By password = By.id("password");
    By loginbutton = By.cssSelector("input[class='btn btn-primary']");
	
	public Login(WebDriver driver){
		this.driver= driver;
	}
	
	//Login 
	public Dashboard LoginWithCredentials(String uname,String pwd){
		driver.findElement(usrname).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
		WebElement validateusername= driver.findElement(By.xpath(".//*[@id='acct-tog']/span"));
		assertEquals(uname, validateusername.getText());
		return new Dashboard(driver);
	}

}
