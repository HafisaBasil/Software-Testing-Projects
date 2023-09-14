package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class elementFetch {

	
	
	public WebElement getElement(String locatortype, String locatorvalue) {
		switch(locatortype) {
		case ("Xpath"):
			return BaseTest.driver.findElement(By.xpath(locatorvalue));
		case ("CSS"):
			return BaseTest.driver.findElement(By.cssSelector(locatorvalue));
		case ("tagname"):
			return BaseTest.driver.findElement(By.tagName(locatorvalue));
		case ("ID"):
			return BaseTest.driver.findElement(By.id(locatorvalue));
		case ("classname"):
			return BaseTest.driver.findElement(By.className(locatorvalue));
		default :
		return null;
		}
	}
	

	public List<WebElement> getElementS(String locatortype, String locatorvalue) {
		switch(locatortype) {
		case ("Xpath"):
			return BaseTest.driver.findElements(By.xpath(locatorvalue));
		case ("CSS"):
			return BaseTest.driver.findElements(By.cssSelector(locatorvalue));
		case ("tagname"):
			return BaseTest.driver.findElements(By.tagName(locatorvalue));
		case ("ID"):
			return BaseTest.driver.findElements(By.id(locatorvalue));
		case ("classname"):
			return BaseTest.driver.findElements(By.className(locatorvalue));
		default :
		return null;
		}
	}
	
}
