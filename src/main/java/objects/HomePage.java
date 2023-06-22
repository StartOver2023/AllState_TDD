package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonAction;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='mr-2']")
	WebElement getQuoteTitle;
	
	
	public  void getQuoteTitleValidation() {
		String titleString= CommonAction.getInnerHTML(getQuoteTitle);
		System.out.println(titleString);
		
		
	}
	

}
