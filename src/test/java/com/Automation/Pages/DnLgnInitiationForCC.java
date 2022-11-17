package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DnLgnInitiationForCC extends ActionEngine {

	@FindBy(xpath = "//div[@class='sub-page-layout-body']//div[@class='row']//div/span[@class='sub_title']")
	List<WebElement> listOfCAPlan;

	@FindBy(xpath = "//span[@class='sub_title']")
	WebElement DocumentActionPlan;

	@FindBy(id = "btnSubmit")
	WebElement proceedBtn;

	@FindBy(xpath = "//span[@class='title']")
	WebElement title;

	@FindBy(id = "btnLockTranasction")
	WebElement lockBtn;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement invalidDateMsg;

	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement closeBtn;

	@FindBy(id = "DN_LGN_CTR_001_error")
	WebElement planDescErr;

	@FindBy(id = "DN_LGN_CTR_001")
	WebElement planDesc;

	@FindBy(id = "DN_LGN_CTR_002_error")
	WebElement inChargeDeptErr;

	@FindBy(id = "DN_LGN_CTR_002")
	WebElement inChargeDept;

	@FindBy(xpath = "//span[text()=' Department']")
	WebElement dept;

	@FindBy(xpath = "//table[@id='ReportTab']//tbody//tr")
	List<WebElement> listOfDept;

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement admin;

	@FindBy(id = "btnOk")
	WebElement okBtn;

	@FindBy(id = "DN_LGN_CTR_003")
	WebElement targetDate;

	@FindBy(id = "DN_LGN_CTR_009_error")
	WebElement taskAllocationErr;

	@FindBy(id = "DN_LGN_CTR_009_button")
	WebElement taskAllocation;

	@FindBy(id = "pageTitle")
	WebElement taskAllocationTitle;

	@FindBy(id = "btnAddTask_3456")
	WebElement DnActionPlanTskAllocation;

	@FindBy(xpath = "(//span[@title='<< Select >>'])[1]")
	WebElement taskAllocationDeptDD;

	@FindBy(xpath = "//ul[@role='listbox']//li[@aria-selected='false']")
	List<WebElement> listOfTaskAlloDept;

	@FindBy(xpath = "//li[contains(text(), 'Adminstration')]")
	WebElement AdminDept;

	@FindBy(xpath = "//label[@for='DN_LGN_CTR_012_2']")
	WebElement MandatoryNo;

	@FindBy(xpath = "//button[@onclick='fnSetValues()']")
	WebElement tskAlloctionSubmitBtn;

	@FindBy(xpath = "//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement DepartmentDropdown;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "MST_DEP_CTF_002")
	WebElement DepartmentIssueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement DeptName;

	public void dnLoginInitiationCC(String PlanDesc) {

		switchToPopupModelFrame(driver);

		System.out.println("List of Proposed Corrective Action Plans are:- " + getSize(listOfCAPlan));

		// getTextList(listOfCAPlan);

		verifyCaptionContains(DocumentActionPlan, "Documentation Action Plan");

		click(DocumentActionPlan, "Documentation Action Plan");

		click(proceedBtn, "Proceed Button");

//		switchToDefaultContent(driver);

		switchToPopupFormFrame(driver);

		verifyExactCaption(title, "Documentation Action Plan Login");

		click(lockBtn, "Lock Button");

		verifyExactCaption(planDescErr, "Enter Value");

		sendText(planDesc, PlanDesc, "Plan Description");

		click(lockBtn, "Lock Button");

		verifyExactCaption(inChargeDeptErr, "Select Value");

		click(inChargeDept, "InCharge Department Add");

		switchToPopupModelFrame(driver);

		// To Select Department

		verifyExactCaption(dept, "Department");

		System.out.println("List of Departments are:- " + getSize(listOfDept));

		// getTextList(listOfDept);

		click(admin, "Admin");

		click(okBtn, "Ok button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");

		verifyCaptionContains(taskAllocationErr, "Select Value");

		click(taskAllocation, "Task Allocation to be Done By Add");

		switchToPopupModalFrame2(driver);

		verifyCaptionContains(taskAllocationTitle, "Task Allocation to be Done");

		jsClick(DnActionPlanTskAllocation, "DN Action Plan Task Allocation Add");

//		jsClick(user, "User");

		jsClick(taskAllocationDeptDD, "Assign To Dept");

		System.out.println("List of Departments to Task Allocate:- " + getSize(listOfTaskAlloDept));

		// getTextList(listOfTaskAlloDept);

		jsClick(AdminDept, "Administration");

//		jsClick(userDD, "Task Allocate to User");
//
//		System.out.println("List of Users are:- " + getSize(listOfUsers));
//
//		getTextList(listOfUsers);
//
//		jsClick(userVivek, "User Vivek");

		click(tskAlloctionSubmitBtn, "Submit Button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");

		switchToParentFrame(driver);

		click(okBtn, "Ok Button");

		switchToParentFrame(driver);
	}

	public void dnLoginInitiationCCNonM(String PlanDesc) {

		switchToPopupModelFrame(driver);

		System.out.println("List of Proposed Corrective Action Plans are:- " + getSize(listOfCAPlan));

		// getTextList(listOfCAPlan);

		verifyCaptionContains(DocumentActionPlan, "Documentation Action Plan");

		click(DocumentActionPlan, "Documentation Action Plan");

		click(proceedBtn, "Proceed Button");

//		switchToDefaultContent(driver);

		switchToPopupFormFrame(driver);

		verifyExactCaption(title, "Documentation Action Plan Login");

		click(lockBtn, "Lock Button");

		verifyExactCaption(planDescErr, "Enter Value");

		sendText(planDesc, PlanDesc, "Plan Description");

		click(MandatoryNo, "Mandatory no");

		click(lockBtn, "Lock Button");

		verifyExactCaption(inChargeDeptErr, "Select Value");

		click(inChargeDept, "InCharge Department Add");

		switchToPopupModelFrame(driver);

		// To Select Department

		verifyExactCaption(dept, "Department");

		System.out.println("List of Departments are:- " + getSize(listOfDept));

		// getTextList(listOfDept);

		click(admin, "Admin");

		click(okBtn, "Ok button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");

		verifyCaptionContains(taskAllocationErr, "Select Value");

		click(taskAllocation, "Task Allocation to be Done By Add");

		switchToPopupModalFrame2(driver);

		verifyCaptionContains(taskAllocationTitle, "Task Allocation to be Done");

		jsClick(DnActionPlanTskAllocation, "DN Action Plan Task Allocation Add");

//		jsClick(user, "User");

		jsClick(taskAllocationDeptDD, "Assign To Dept");

		System.out.println("List of Departments to Task Allocate:- " + getSize(listOfTaskAlloDept));

		// getTextList(listOfTaskAlloDept);

		jsClick(AdminDept, "Administration");


		click(tskAlloctionSubmitBtn, "Submit Button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");

		switchToParentFrame(driver);

		click(okBtn, "Ok Button");

		switchToParentFrame(driver);
	}

	public void dnLoginInitiationCC_SP(String PlanDesc, String actionPlanDepartment) {

		switchToPopupModelFrame(driver);

		System.out.println("List of Proposed Corrective Action Plans are:- " + getSize(listOfCAPlan));


		verifyCaptionContains(DocumentActionPlan, "Documentation Action Plan");

		click(DocumentActionPlan, "Documentation Action Plan");

		click(proceedBtn, "Proceed Button");


		switchToPopupFormFrame(driver);

		verifyExactCaption(title, "Documentation Action Plan Login");

		click(lockBtn, "Lock Button");
		// click(AlertVefication, "Close alert");
		// sendText(TargetDate, date, "TargetDate");
		verifyExactCaption(planDescErr, "Enter Value");

		sendText(planDesc, PlanDesc, "Plan Description");

		click(lockBtn, "Lock Button");

		verifyExactCaption(inChargeDeptErr, "Select Value");

		click(inChargeDept, "InCharge Department Add");

		switchToPopupModelFrame(driver);

		// To Select Department

		verifyExactCaption(dept, "Department");

		click(AdvancedSearch, "Advanced Search");
		click(DepartmentIssueCode, "Department IssueCode");
		sendText(DepartmentIssueCode, "ADM", "");
		click(ApplyButton, "ApplyButton");
		click(DeptName, "Department Name");

		click(okBtn, "Ok button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");
		// -----------//

		verifyCaptionContains(taskAllocationErr, "Select Value");

		click(taskAllocation, "Task Allocation to be Done By Add");

		switchToPopupModalFrame2(driver);

		verifyCaptionContains(taskAllocationTitle, "Task Allocation to be Done");

		jsClick(DnActionPlanTskAllocation, "DN Action Plan Task Allocation Add");

		selectDropdownUsingVisisbleText(DepartmentDropdown, actionPlanDepartment, "Department Dropdown");

		click(tskAlloctionSubmitBtn, "Submit Button");

		switchToParentFrame(driver);

		click(lockBtn, "Lock Button");

		switchToParentFrame(driver);

		click(okBtn, "Ok Button");

		switchToParentFrame(driver);
	}

}
