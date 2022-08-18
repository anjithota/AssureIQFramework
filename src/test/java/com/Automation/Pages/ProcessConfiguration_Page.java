package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class ProcessConfiguration_Page extends ActionEngine {
	@FindBy(id = "TPT_02")
	WebElement ProcessConfigurationModificationMenu;
	
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons']")
	WebElement QAMSConfigurationMenu;
	
	@FindBy(id = "pageTitle")
	WebElement ProcessCoinfigListPageTitle;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;
	
	@FindBy(name = "CNM_TPT_CTF_003")
	WebElement ProcesscodeFilter;
	
	@FindBy(id = "MainTitle")
	WebElement ProcessCoinfigModificationPageMainTitle;
	
	@FindBy(id = "SubTitle")
	WebElement ProcessCoinfigModificationPageSubTitle;
	
	@FindBy(id = "CNM_TPT_CTF_015")
	WebElement TaskClosureUserDropDown;
	
	@FindBy(xpath = "//i[@class='validation-error']")
	WebElement RemarksError;
	
	@FindBy(id = "txtRemarks")
	WebElement RemarksText;
	
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(className = "text-ellipsis")
	WebElement	Record;
	
	public void processConfigModification(String processCode, String taskClosureType, String remarks) {
		switchToDefaultContent(driver);
		click(QAMSConfigurationMenu, "QAMS Configuration menu");
		scrollToViewElement(ProcessConfigurationModificationMenu);
		click(ProcessConfigurationModificationMenu, "Process Configuration modification menu");
		switchToTaskListFrame(driver);
		verifyExactCaption(ProcessCoinfigListPageTitle, "Process Configuration Modification");
		click(AdvancedSearchButton, "Advanced search button");
		sendText(ProcesscodeFilter, processCode, "Process Code text filter");
		
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		
		verifyExactCaption(ProcessCoinfigModificationPageMainTitle, "Process Configuration");
		verifyExactCaption(ProcessCoinfigModificationPageSubTitle, "Modification Initiation");
		
		selectDropdownUsingVisisbleText(TaskClosureUserDropDown, taskClosureType, "Task Closure User DropDown");
		click(SubmitButton, "Submit Button");
		verifyExactCaption(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or Reason");
		click(SubmitButton, "Submit button");
	}
	
	
	
	

	

}
