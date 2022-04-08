package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocLoginReview extends ActionEngine {

	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=75754']//span")
	WebElement DocLoginMenu;

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

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;
	
	@FindBy(xpath = "//label[text()='Drop']")
	WebElement decisionDrop;
	
	

	public void DnLgnReturn(String RemarkReason) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocLoginMenu);
		click(DocLoginMenu, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(ReturnBtn, "Return");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "RemarksReason");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

	}

	public void DnLgnReview(String Comments) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocLoginMenu);
		click(DocLoginMenu, "Login Menu");
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
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

	}

	public void DnLgnAgainReview(String Comments) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocLoginMenu);
		click(DocLoginMenu, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		clearField(CommentsText, "comments");
		sendText(CommentsText, Comments, "Review Comments");
		click(ReviewBtn, "Review");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

	}
	
	public void DnLgnDrop(String RemarkReason) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocLoginMenu);
		click(DocLoginMenu, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(decisionDrop, "Drop");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "RemarksReason");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	}

}
