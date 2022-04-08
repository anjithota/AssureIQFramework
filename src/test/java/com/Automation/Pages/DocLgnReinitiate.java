package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocLgnReinitiate extends ActionEngine {
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
	@FindBy(id = "DN_LGN_CTR_001_error")
	WebElement planDescErr;

	@FindBy(id = "DN_LGN_CTR_001")
	WebElement planDesc;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	
	public void dnLoginReInitiationCC(String PlanDesc, String RemarkReason) {
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
		clearField(planDesc, "Descrption");
		sendText(planDesc, PlanDesc, "Desription");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, RemarkReason, "remarks");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	
	}

}
