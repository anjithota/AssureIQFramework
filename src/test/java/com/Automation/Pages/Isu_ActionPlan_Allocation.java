package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

import lombok.experimental.FieldNameConstants;

public class Isu_ActionPlan_Allocation extends ActionEngine {

	@FindBy(xpath = "//small[text()='QRM']")
	WebElement QRMActionPlanMytask;
	
	@FindBy(id = "MyTaskPrc_QRM_QRM_TSK_FRM_ID_01")
	WebElement QRMTaskAllocationMyTask; 
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;
	
	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement QRMIssueCodeFilter; 
	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(id = "QRM_TSK_CTR_03")
	WebElement QRMComments;
	
	@FindBy(id = "QRM_TSK_CTR_03_error")
	WebElement QRMCommentsError;
	
	@FindBy(id = "QRM_TSK_CTR_06_button")
	WebElement QrmTaskAllocationButton;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;
	
	public void qrmTaskAllocation(String comments) {
		
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(QRMActionPlanMytask);
		click(QRMActionPlanMytask, "QRM action plan My task");
		click(QRMTaskAllocationMyTask, "QARM action plan allocation menu");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, QRMIssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(QRMCommentsError, "Enter Value");
		sendText(QRMComments, comments, "QRM comments");
		click(SubmitButton, "Submit");
		
	}
	
	


}
