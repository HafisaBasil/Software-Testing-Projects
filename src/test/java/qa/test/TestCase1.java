package qa.test;

import org.testng.annotations.Test;

import PageEvents.homePageEvents;
import PageEvents.loginPageEvents;
import base.BaseTest;
import utils.elementFetch;

public class TestCase1 extends BaseTest{
	elementFetch ele=new elementFetch();
	homePageEvents home=new homePageEvents();
	loginPageEvents login=new loginPageEvents();
	
	
  @Test
  public void validcredentials() {
	 home.signin();
	 login.Verifyloginpageload();
	 login.enteringcredentials();
	  
  }
}
