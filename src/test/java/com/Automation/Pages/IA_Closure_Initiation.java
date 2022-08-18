package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class IA_Closure_Initiation extends ActionEngine {

	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAuditMyTaskMenu;

	@FindBy(id = "MyTaskPrc_IA_IA_AUD_CLS_FRM_ID_01")
	WebElement AuditCloserMYTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "AUD_CLS_CTR_002_error")
	WebElement CloserCommentsError;

	@FindBy(id = "AUD_CLS_CTR_002")
	WebElement CloserComment;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;  

	public void auditClosureInitiation(String response) {
		auditClosureMyTaskNavigation();
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CloserCommentsError, "Enter Value");
		sendText(CloserComment, response, "Closer Comments");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnID"));
		// saveAlterUniqueCode(driver, DroppedIssueCode);
		switchToDefaultContent(driver);

	}

	public void auditClosureMyTaskNavigation() {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAuditMyTaskMenu);
		click(InternalAuditMyTaskMenu, "Internal Audit");
		click(AuditCloserMYTaskMenu, "AuditCloser MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void auditClosureReInitiation(String comments, String remarks) {
		auditClosureMyTaskNavigation();
		clearField(CloserComment, "Closure Comments");
		sendText(CloserComment, comments, "Colusre comments");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, remarks, "Remarks");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnID"));
		switchToDefaultContent(driver);
		

	}

}
