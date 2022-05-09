package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocLoginReviewSP extends ActionEngine{
	@FindBy(xpath = "//small[text()='DN']")
	WebElement DocActionplanMyTask;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnBtn;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_14']")
	WebElement ReviewBtn;

	@FindBy(id = "DN_LGN_CTR_004")
	WebElement CommentsText;

	@FindBy(id = "DN_LGN_CTR_004_error")
	WebElement CommentsError;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//label[text()='Drop']")
	WebElement decisionDrop;
	
	@FindBy(id = "MyTaskPrc_DN_DN_LGN_FRM_ID_01")
	WebElement DocLoginMenu;
	
	public void DnLgnReturn(String RemarkReason) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocActionplanMyTask);
		click(DocActionplanMyTask, "Login Menu");
		click(DocLoginMenu, "Documentation Login");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(ReturnBtn, "Return");
		//click(SubmitBtn, "Submit");
		//verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "RemarksReason");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);
		

	}
	
	public void DnLgnReview(String Comments) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocActionplanMyTask);
		click(DocActionplanMyTask, "Login Menu");
		click(DocLoginMenu, "Documentation Login");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(ReviewBtn, "Review");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(CommentsText, Comments, "Review Comments");
		click(ReviewBtn, "Review");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}
	
	

}
