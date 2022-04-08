package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DocActionVerify extends ActionEngine {
	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=75754']//span")
	WebElement DocLgn;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvanceSearchButton;
	
	@FindBy(name="ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(className="text-ellipsis")
	WebElement Record;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(xpath="//div[text()='QA Decision is pending']")
	WebElement QADecitionMeassage;
	
	@FindBy(className="toast-close-button")
	WebElement AlertClose;
	
	public void DocLoginReviewTest() {
		switchToBodyFrame(driver);
		scrollToViewElement(DocLgn);
		click(DocLgn, "Doclogin");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0016", "test");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Filter");
		click(Record, "IssueCode workitem");
		//verifyAttribute(AdvanceSearchButton, attribute, expectedValue);
		verifyCaptionContains(QADecitionMeassage, "QA Decision is pending");
		
		click(AlertClose, "Alert Close button");
		switchToDefaultContent(driver);
		
		
	}
	
	

}
