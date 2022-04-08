package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class VerifyCCClosure extends ActionEngine {
	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=83269']//span")
	WebElement CCClosure;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvanceSearchButton;
	
	@FindBy(name="ISU_CLS_CTR_001")
	WebElement IssuecodeFilter;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(className="text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement Alert;
	
	@FindBy(xpath="//div[@class='toast-close-button']")
	WebElement AlertClose;
	public void ccClosure() {
		switchToBodyFrame(driver);
		
		scrollToViewElement(CCClosure);
		click(CCClosure, "CC closure Menu");//CC-PL01-Admin-21-0010
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0014%", "Isssue Code Filter");
		
			
		enterUniqueCodeConcat(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
		
		//verifyCaptionContains(Alert, "Some of the Action Plan(s) are in under approval .Complete the Action plan to close this item");
		//click(AlertClose, "Close Alert");//Some of the Action Plan(s) are in under approval .Complete the Action plan to close this item
		
		switchToDefaultContent(driver);
	}
	

}
