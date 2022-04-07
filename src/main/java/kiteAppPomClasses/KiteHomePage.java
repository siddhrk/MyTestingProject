package kiteAppPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
@FindBy(xpath="//span[@class='user-id']")private WebElement myuserid;
@FindBy(xpath="//a[@target='_self']")private WebElement logout;


public KiteHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public String getActualUserid() {
	String ActualUserid = myuserid.getText();
	return ActualUserid;
}

public void logout() {
	myuserid.click();
	logout.click();
}


}
