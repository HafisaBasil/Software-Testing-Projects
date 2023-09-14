package PageEvents;

import PageObjects.homePageElements;
import utils.elementFetch;

public class homePageEvents {
	
	elementFetch ele=new elementFetch();
	
	public void signin() {
		ele.getElement("Xpath", homePageElements.Signinbtn).click();
	}

}
