package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocLgnReinitiationSP extends ActionEngine{
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
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id = "MyTaskPrc_DN_DN_LGN_FRM_ID_01")
	WebElement DocLoginMenu;
	
	@FindBy(id = "DN_LGN_CTR_001")
	WebElement planDesc;
	
	public void docLgnReinitiate(String PlanDesc, String remarks) {
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
		scrollToViewElement(planDesc);
		sendText(planDesc, PlanDesc, "Plan Description");
		sendText(Remarks, remarks, "Remarks Reasons");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		switchToDefaultContent(driver);
	}

}
