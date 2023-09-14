package PageEvents;

import org.testng.Assert;

import PageObjects.loginPageElements;
import utils.elementFetch;

public class loginPageEvents {
	elementFetch ele=new elementFetch();
	public void Verifyloginpageload() {
		
		Assert.assertTrue(ele.getElementS("Xpath", loginPageElements.lgnbtn).size()>0,"element not found");
		
	}
	
	public void enteringcredentials() {
	ele.getElement("Xpath", loginPageElements.emailtxt).sendKeys("hafisav123@gmail.com");
	ele.getElement("Xpath", loginPageElements.psswdtxt).sendKeys("aydin123");
	ele.getElement("Xpath", loginPageElements.lgnbtn).click();
	}

}
