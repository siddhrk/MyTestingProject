package kiteAppTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclasses.BaseClass;
import kiteAppPomClasses.KiteHomePage;
import kiteAppPomClasses.KiteLoginPage;
import kiteAppPomClasses.KitePinPage;
import utilities.Utility1;

public class UserNameValidation extends BaseClass{
	

	 
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage home;
	@BeforeClass
	public void launchBrowser1() {
		launchBrowser();
		 login=new KiteLoginPage(driver);
		   pin=new KitePinPage(driver);
		   home=new KiteHomePage(driver);
		 
	}
@BeforeMethod 
public void loginToKiteApp() throws EncryptedDocumentException, IOException {
	login.enterUserid(Utility1.readDataFromExcel(0, 0));
	login.enterpassword(Utility1.readDataFromExcel(0, 1));
	login.clickOnLoginButton();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	
	pin.enterPin(Utility1.readDataFromExcel(0, 2));
	pin.clickOnContinueButton();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
}

  @Test
  public void validateUsername() throws EncryptedDocumentException, IOException {
	  int TCID=01;
	  String actual = home.getActualUserid();
String expected = Utility1.readDataFromExcel(0, 0);
	  
	  Assert.assertEquals(expected, actual,"actual and expected are not matching");
	  
	  Utility1.takesScreenshot(driver, TCID);
	  Reporter.log("Validated UserName", true);
  }
  
  @AfterMethod
  public void logoutFromKite() {
	  home.logout();
  }
  @AfterClass
  public void closeBrowser1() {
	  closeBrowser();
  }
  
}
