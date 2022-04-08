package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocTaskAllocation extends ActionEngine {
	@FindBy(xpath="//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=75769']//span")
	WebElement DocumentationAllocationMenu;
	
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
	
	@FindBy(id= "DN_TSK_CTR_03")
	WebElement CommentsText;
	
	@FindBy(id= "DN_TSK_CTR_03_error")
	WebElement CommentsError;
	
	@FindBy(id= "DN_TSK_CTR_06_button")
	WebElement TaskAllocationButton;
	
	@FindBy(id= "DN_TSK_CTR_06_error")
	WebElement TaskAllocationError;
	
	@FindBy(xpath="//button[@class='caliber-button-primary float-right']")
	WebElement AllcationSubmit;
	
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement TaskAllocationAlert;
	
	@FindBy(xpath="//button[@class='toast-close-button']")
	WebElement TaskAllocationAlertClose;
	
	@FindBy(id="btnAddTask_3457")
	WebElement TaskAllocationPopupAddItem;
	
	@FindBy(xpath="//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement SelectDepartment;
	
	
	
	public void DnTskAllocation(String Comments, String Department) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocumentationAllocationMenu);
		click(DocumentationAllocationMenu, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(CommentsText, Comments, "Comments");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(TaskAllocationError, "Select Value");
		click(TaskAllocationButton, "Task Allocation");
		switchToPopupModalFrame2(driver);
		click(AllcationSubmit, "Allocation Submit");
		verifyCaptionContains(TaskAllocationAlert, "Select Atleast one task to allocate");
		click(TaskAllocationAlertClose, "Alert Close");
		click(TaskAllocationPopupAddItem, "AddItem Allocation");
		selectDropdownUsingVisisbleText(SelectDepartment, Department, "Department");  //Information Technology ( IT )
		click(AllcationSubmit, "Allocation Submit");
		switchToParentFrame(driver);
		click(SubmitBtn, "Submit BUtton");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
		
		
	}
	
	
	

	

}
