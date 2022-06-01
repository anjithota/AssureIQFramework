package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class Dev_DN_ForceClosure_impacts  extends ActionEngine{

	@FindBy(xpath = "//span[text()=' Documentation Action Plan ']")
	WebElement DocumentationActionPlan;
	
	@FindBy(id="MyTaskPrc_DN_DN_TSK_FRM_ID_01")
	WebElement Documentationtaskallcation;
	
	@FindBy(id="btnAdvSearch")
	WebElement SearchFilter;
	
	@FindBy(name="date-range-from")
	WebElement searchcalinder;
	
	@FindBy(xpath = "//input[@name='ISU_LGN_CTR_001']")
	WebElement IssueCode;
	
	@FindBy(xpath = "//li[text()='Last 30 Days']")
	WebElement last30days;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//span[@class=\"text-ellipsis\"]")
	WebElement Record;
	
	@FindBy(id="DN_TSK_CTR_03")
	WebElement RemarksReason;
	
	@FindBy(id="DN_TSK_CTR_06_button")
	WebElement TaskAllocation;
	
	@FindBy(id="btnAddTask_3457")
	WebElement DocumantationActionPlanExecutation;
	
	@FindBy(id="task_allocation_type_5d9a42c6-71f7-47b6-9134-85030430780b_1")
	WebElement User;
	
	@FindBy(id="select2-gv3g-container")
	WebElement SelectDept;
	
	@FindBy(id="select2-gv3g-result-6pay-865")
	WebElement QaSqa;
	
	@FindBy(id="select2-rzll-container")
	WebElement SelectUser;
	
	@FindBy(id="select2-usst-results")
	WebElement User8;
	
	@FindBy(xpath = "//button[text()='Submit'][1]")
	WebElement TaskAllacationSubmitBtn;
	
	@FindBy(id="btnSubmit")
	WebElement SubmitBtn;
	
	@FindBy(id="txtESignPassword")
	WebElement E_SignPassword;
	
	
	public void Dev_DN_ForceClosure_Allcation()
	{
		
		scrollToViewElement(DocumentationActionPlan);
		click(DocumantationActionPlanExecutation, "Task Allcation");
		click(SearchFilter, "filter");
		/*
		 * click(searchcalinder, "Calender"); click(last30days, "Days");
		 */
		enterUniqueCode(driver,  IssueCode);
		click(ApplyBtn, "Apply button");
		/*
		 * click(Record, "Click Record"); sendText(RemarksReason, Test, "comments");
		 */
	}
	
}
