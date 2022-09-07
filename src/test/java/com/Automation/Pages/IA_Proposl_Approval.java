package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class IA_Proposl_Approval extends ActionEngine {

	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAuditMYTaskMenu;

	@FindBy(id = "MyTaskPrc_IA_AUD_IA_LGN_FRM_ID_01")
	WebElement IAProposalMyTakMenu;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqeCode;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnDecision;

	@FindBy(id = "btnSubmit_1")
	WebElement btnSubmit;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveDecision;
	
	@FindBy(id = "AUD_LGN_CTF_031")
	WebElement ReviewComments;
	
	@FindBy(id = "AUD_LGN_CTF_031_error")
	WebElement ReviewCommentsError;
	
	public void ia_Proposal_navigation() {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAuditMYTaskMenu);
		click(InternalAuditMYTaskMenu, "Internal Audit My task menu");
		click(IAProposalMyTakMenu, "Audit Proposal my task menu");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void ia_Approe_Verification() {
		ia_Proposal_navigation();

	}

	public void ia_Approval_Return(String remarksReason) {
		ia_Proposal_navigation();
		click(ReturnDecision, "Return Decision");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, remarksReason, "Enter name");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}
	
	public void ia_Approval_Approve(String comments) {
		ia_Proposal_navigation();
		click(ApproveDecision, "Approve Decision");
		verifyCaptionContains(ReviewCommentsError, "Enter Value");
		sendText(ReviewComments, comments, "Review comments");
		click(ApproveDecision, "Approve Decision");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}
	
	
	 

}
