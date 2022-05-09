package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Doc_Lgn_Approve_SP extends ActionEngine{
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
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id = "MyTaskPrc_DN_DN_LGN_FRM_ID_01")
	WebElement DocLoginMenu;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveBtn;
	
	@FindBy(id = "DN_LGN_CTR_007_error")
	WebElement ApprovalCommentsError;

	@FindBy(id = "DN_LGN_CTR_007")
	WebElement ApprovalComments;
	
	public void devLgnApprovalApprove(String Comments) {
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
		click(ApproveBtn, "Approve");
		verifyCaptionContains(ApprovalCommentsError, "Enter Value");
		sendText(ApprovalComments, Comments, "Approval Comments");
		click(ApproveBtn, "Approve");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

}
