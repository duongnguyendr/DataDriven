package com.auvenir.ui.pages.auditor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.auvenir.ui.pages.common.AbstractPage;

public class AuditorCreateToDoPage  extends AbstractPage{

	public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
		super(logger, driver);
		PageFactory.initElements(driver, this);
	}
	
	//verify date picker
	
	@FindBy(id="ui-datepicker-div") 
	private WebElement eleCalendarPopup;
	
	

	@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
	private WebElement eleToDoNameInput;

	@FindBy(xpath="//input[@id='due-date']")
	private WebElement eleDueDateInput;

	@FindBy(xpath="//div[@id='divName']/div/p[@class='auv-inputError']")
	private WebElement eleToDoNameErrorLabel;
	
	
	


	public void verifyDefaultValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		validateDisPlayedElement(eleToDoNameInput);
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");
	}
	public void verifyCssValueToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		clickAndHold(eleToDoNameInput);
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");
	}
	public void verifyCssValueWarningToDoTextBox(){
		waitForVisibleElement(eleToDoNameInput);
		waitForVisibleElement(eleDueDateInput);
		clickAndHold(eleToDoNameInput);
		clickElement(eleDueDateInput);
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgba(253, 109, 71, 0.4)");
		//waitForVisibleElement(eleToDoNameErrorLabel);
		//validateElementText(eleToDoNameErrorLabel,"Not a valid name.");
	}


	//Will be deleted after finish coding
	public void verifyAddNewToDoTask(){
		validateDisPlayedElement(eleToDoNameInput);
		validateAttributeElement(eleToDoNameInput,"placeholder","Write your first to do here");//Write your first to do here
		clickAndHold(eleToDoNameInput);
		validateCSSValueElement(eleToDoNameInput,"border","1px solid rgb(89, 155, 161)");

	}

	public void verifyInputValueToDoNameTextBox(String Value) {
		waitForVisibleElement(eleToDoNameInput);
		clearTextBox(eleToDoNameInput);
		eleToDoNameInput.sendKeys(Value);
		validateAttributeElement(eleToDoNameInput, "value", Value);
	}
	
	public void verifyCssDueDateWhenHover(){
		clickAndHold(eleDueDateInput);
		waitForVisibleElement(eleDueDateInput);
		validateCSSValueElement(eleDueDateInput,"border","1px solid rgb(89, 155, 161)");
		
	}
	
	public void verifyCalendarPopup(){
		validateDisabledElement(eleCalendarPopup);
		validateDisPlayedElement(eleCalendarPopup);
	}
	
	public void verifyEnterDueDate(String date){
		sendKeyTextBox(eleDueDateInput, date);
	}
	
	public void verifyDueDateDefault(String date){
		validateElementText(eleDueDateInput, date);
	}
	
	public void verifyDueDateChoose(Calendar cal){
		WebElement ele=getDriver().findElement(By.xpath("//td[@data-month='"+cal.get(Calendar.MONTH)+1+"'][@data-year='"+cal.get(Calendar.YEAR)+"']//a[contains(text(),'"+cal.get(Calendar.DAY_OF_MONTH)+"')]"));
		clickElement(ele);
		
	}
	
	public int getToDay(){
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public String getMonthName(){
		Calendar cal=Calendar.getInstance();
		return new SimpleDateFormat("MMMM").format(cal.getTime());
	}
	
	public String getToDate(){
		Calendar cal=Calendar.getInstance();
		return new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
	}
}
