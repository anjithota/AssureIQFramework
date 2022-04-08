package com.Automation.Pages;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class ChangeControlIHODApproval extends ActionEngine {

//	@FindBy(xpath = "//span[text()='Change Control Login']")
//	WebElement ccLgn;
//
//	@FindBy(id = "pageTitle")
//	WebElement pageTitleCC;
//
//	@FindBy(id = "btnAdvSearch")
//	WebElement advSearchBtn;
//
//	@FindBy(xpath = "//input[@placeholder='Issue Code']")
//	WebElement issueCode;
//
//	@FindBy(id = "btnSubmitListFilter")
//	WebElement applyBtn;
//
//	@FindBy(xpath = "//span[contains(@title, 'PROV')]")
//	WebElement ICode;

	@FindBy(xpath = "//label[text()='Review']")
	WebElement decisionReview;

	@FindBy(id = "ISU_LGN_CTR_025_error")
	WebElement IHODCmtsErr;

	@FindBy(id = "ISU_LGN_CTR_025")
	WebElement IHODCmts;

	@FindBy(id = "ISU_LGN_CTR_191_error")
	WebElement assumedCtgErr;

	@FindBy(id = "select2-ISU_LGN_CTR_191-container")
	WebElement assumedCtgDD;

	@FindBy(xpath = "//ul[@id='select2-ISU_LGN_CTR_191-results']//li[contains(@id, 'select2-ISU_LGN_CTR_191')]")
	List<WebElement> listOfAssumedCtg;

	@FindBy(xpath = "//li[contains(text(),'Minor')]")
	WebElement MinorCtg;

	@FindBy(id = "ISU_LGN_CTR_026_error")
	WebElement ActionPlanProposalErr;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_026_1']")
	WebElement ActionPlanAsYes;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_026_2']")
	WebElement ActionPlanAsNo;

	@FindBy(id = "ISU_LGN_CTR_027_error")
	WebElement ProposedActionPlanErr;

	@FindBy(id = "ISU_LGN_CTR_027")
	WebElement ProposedActionPlanAdd;

	@FindBy(id = "ISU_LGN_CTR_195_error")
	WebElement DeptCmtsErr;

	@FindBy(id = "ISU_LGN_CTR_195_button")
	WebElement DeptCmtsAdd;

	@FindBy(xpath = "//span[contains(text(), 'Departments Required to Provide')]")
	WebElement OtherDepartmentCmts;

	@FindBy(id = "btnAddTask_342")
	WebElement OtherDeptAdd;

	@FindBy(xpath = "(//span[@title='<< Select >>'])[1]")
	WebElement otherDeptDD;

	@FindBy(xpath = "//ul[@role='listbox']//li[@aria-selected='false']")
	List<WebElement> listOfOtherDept;

	@FindBy(xpath = "//li[contains(text(), 'Adminstration')]")
	WebElement AdminDept;

//	@FindBy(xpath = "(//label[contains(text(), 'User')])[1]")
//	WebElement user;
//
//	@FindBy(xpath = "(//span[@title='<< Select >>'])[1]")
//	WebElement userDD;
//
//	@FindBy(xpath = "//ul[@role='listbox']//li[@aria-selected='false']")
//	List<WebElement> listOfUsers;
//
//	@FindBy(xpath = "//li[contains(text(),'Ashok')]")
//	WebElement userAshok;

	@FindBy(xpath = "//button[@onclick='fnSetValues()']")
	WebElement otherDeptSubmitBtn;

	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	@FindBy(id = "btnSubmit")
	WebElement submitBtn;
	
	@FindBy(xpath = "(//div[contains(@class, 'confirmation-message-text')])[2]")
	WebElement cngMsg;

	@FindBy(id = "cfnMsg_Next")
	WebElement done;
	
	@FindBy(xpath = "//label[text()='Drop']")
	WebElement decisionDrop;

	public void ccIHODApproval(String IHODComments, String planDesc, String RemRsn) {

//		
//		// Switch to Body frame
//		switchToBodyFrame(driver);
//
//		// Verify Captions
//		verifyCaptionContains(pageTitleCC, "Change Control Login");
//
//		// Click Advanced Search
//		click(advSearchBtn, "Advanced Search");
//
//		// Enter Unique Code
//		enterUniqueCode(driver, issueCode);
//
//		// Click Apply Button
//		click(applyBtn, "Apply Button");
//
//		// Click Issue Code
//		click(ICode, "ICode");
		
		ccMyTaskSearch.myTaskChangeControlSearch();

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify IHOD Comments Alert
		verifyCaptionContains(IHODCmtsErr, "Enter Value");

		// Enter IHOD Comments
		sendText(IHODCmts, IHODComments, "IHOD Commets");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Assumed Category Alert
		verifyCaptionContains(assumedCtgErr, "Select Value");

		// Click on Assumed Category
		click(assumedCtgDD, "Assumed Category");

		// Size of Assumed Category
		System.out.println("List of Assumed Category:- " + getSize(listOfAssumedCtg));


		// Click on Minor Category
		click(MinorCtg, "Minor");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Action Plan Alert
		verifyCaptionContains(ActionPlanProposalErr, "Select Value");

		// Click on Action Plan as Yes
		click(ActionPlanAsYes, "Yes");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Proposed Action Plan Alert
		verifyCaptionContains(ProposedActionPlanErr, "Select Value");

		// Click on Proposed Action Plan
		click(ProposedActionPlanAdd, "Action Plan Add Items");

		dnLgnInitiationForCC.dnLoginInitiationCC(planDesc);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Department Comments Alert
		verifyCaptionContains(DeptCmtsErr, "Select Value");

		// Click on Department Comments
		click(DeptCmtsAdd, "Department Required Cmts Add");

		// Switch to frame inside frame
		switchToPopupModalFrame2(driver);

		// Verify Other Department Heading
		verifyCaptionContains(OtherDepartmentCmts, "Department Required to Provide Comments");

		// Click Other Department Add Item
		jsClick(OtherDeptAdd, "Other Department Cmts Add");

		// Select Department for Other Department Comments
		jsClick(otherDeptDD, "Other Departments");

		// Get the size of Department for Other Department Comments
		System.out.println("List of Departments to Task Allocate:- " + getSize(listOfOtherDept));


		// Select Admin Department
		jsClick(AdminDept, "Administration");

//		// Click Assign To the User
//		jsClick(user, "User");
//
//		// Click User Dropdown
//		jsClick(userDD, "Other Dept Users");
//
//		// Get the size of Users for Other Department Comments
//		System.out.println("List of Users are:- " + getSize(listOfUsers));
//
//		// Print Users list in console
//		getTextList(listOfUsers);
//
//		// Select User Ashok
//		jsClick(userAshok, "Other Departments Logged by User Ashok");

		// Click Submit Button
		click(otherDeptSubmitBtn, "Submit Button");

		// Switch to Parent frame
		switchToParentFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		sendText(remarkReason, RemRsn, "Remarks/Reasons");

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		
		

		// ESign should display
		/*e_SignAvailabe();

		// Entering E_Sign Password
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnIHODPwd"), cngMsg, "Change Control Login Registration Approval",
				done);*/
	}
	
	public void ccIHODSelectiveApproval(String IHODComments) {
		ccMyTaskSearch.myTaskChangeControlSearch();

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);
		
		clearField(IHODCmts, "IHOD Commets");
		sendText(IHODCmts, IHODComments, "IHOD Commets");
		
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");
		
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		
		switchToDefaultContent(driver);

		

		
	}
	
	public void ccIHODApprovalNoActionPlan(String IHODComments) {
		ccMyTaskSearch.myTaskChangeControlSearch();

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify IHOD Comments Alert
		verifyCaptionContains(IHODCmtsErr, "Enter Value");

		// Enter IHOD Comments
		sendText(IHODCmts, IHODComments, "IHOD Commets");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Assumed Category Alert
		verifyCaptionContains(assumedCtgErr, "Select Value");

		// Click on Assumed Category
		click(assumedCtgDD, "Assumed Category");

		// Size of Assumed Category
		System.out.println("List of Assumed Category:- " + getSize(listOfAssumedCtg));


		// Click on Minor Category
		click(MinorCtg, "Minor");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Action Plan Alert
		verifyCaptionContains(ActionPlanProposalErr, "Select Value");

		// Click on Action Plan as Yes
		click(ActionPlanAsNo, "No");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		
		

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Department Comments Alert
		verifyCaptionContains(DeptCmtsErr, "Select Value");

		// Click on Department Comments
		click(DeptCmtsAdd, "Department Required Cmts Add");

		// Switch to frame inside frame
		switchToPopupModalFrame2(driver);

		// Verify Other Department Heading
		verifyCaptionContains(OtherDepartmentCmts, "Department Required to Provide Comments");

		// Click Other Department Add Item
		jsClick(OtherDeptAdd, "Other Department Cmts Add");

		// Select Department for Other Department Comments
		jsClick(otherDeptDD, "Other Departments");

		// Get the size of Department for Other Department Comments
		System.out.println("List of Departments to Task Allocate:- " + getSize(listOfOtherDept));


		// Select Admin Department
		jsClick(AdminDept, "Administration");

//		// Click Assign To the User
//		jsClick(user, "User");
//
//		// Click User Dropdown
//		jsClick(userDD, "Other Dept Users");
//
//		// Get the size of Users for Other Department Comments
//		System.out.println("List of Users are:- " + getSize(listOfUsers));
//
//		// Print Users list in console
//		getTextList(listOfUsers);
//
//		// Select User Ashok
//		jsClick(userAshok, "Other Departments Logged by User Ashok");

		// Click Submit Button
		click(otherDeptSubmitBtn, "Submit Button");

		// Switch to Parent frame
		switchToParentFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		
	}
	
	public void ccIHODApprovalNonMandatory(String IHODComments, String planDesc, String RemRsn) {

//		
//		// Switch to Body frame
//		switchToBodyFrame(driver);
//
//		// Verify Captions
//		verifyCaptionContains(pageTitleCC, "Change Control Login");
//
//		// Click Advanced Search
//		click(advSearchBtn, "Advanced Search");
//
//		// Enter Unique Code
//		enterUniqueCode(driver, issueCode);
//
//		// Click Apply Button
//		click(applyBtn, "Apply Button");
//
//		// Click Issue Code
//		click(ICode, "ICode");
		
		ccMyTaskSearch.myTaskChangeControlSearch();

		// Switch to default Page
		switchToDefaultContent(driver);

		// Switch to Body frame
		switchToBodyFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify IHOD Comments Alert
		verifyCaptionContains(IHODCmtsErr, "Enter Value");

		// Enter IHOD Comments
		sendText(IHODCmts, IHODComments, "IHOD Commets");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Assumed Category Alert
		verifyCaptionContains(assumedCtgErr, "Select Value");

		// Click on Assumed Category
		click(assumedCtgDD, "Assumed Category");

		// Size of Assumed Category
		System.out.println("List of Assumed Category:- " + getSize(listOfAssumedCtg));


		// Click on Minor Category
		click(MinorCtg, "Minor");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Action Plan Alert
		verifyCaptionContains(ActionPlanProposalErr, "Select Value");

		// Click on Action Plan as Yes
		click(ActionPlanAsYes, "Yes");

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Proposed Action Plan Alert
		verifyCaptionContains(ProposedActionPlanErr, "Select Value");

		// Click on Proposed Action Plan
		click(ProposedActionPlanAdd, "Action Plan Add Items");

		dnLgnInitiationForCC.dnLoginInitiationCCNonM(planDesc);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Verify Department Comments Alert
		verifyCaptionContains(DeptCmtsErr, "Select Value");

		// Click on Department Comments
		click(DeptCmtsAdd, "Department Required Cmts Add");

		// Switch to frame inside frame
		switchToPopupModalFrame2(driver);

		// Verify Other Department Heading
		verifyCaptionContains(OtherDepartmentCmts, "Department Required to Provide Comments");

		// Click Other Department Add Item
		jsClick(OtherDeptAdd, "Other Department Cmts Add");

		// Select Department for Other Department Comments
		jsClick(otherDeptDD, "Other Departments");

		// Get the size of Department for Other Department Comments
		System.out.println("List of Departments to Task Allocate:- " + getSize(listOfOtherDept));


		// Select Admin Department
		jsClick(AdminDept, "Administration");

//		// Click Assign To the User
//		jsClick(user, "User");
//
//		// Click User Dropdown
//		jsClick(userDD, "Other Dept Users");
//
//		// Get the size of Users for Other Department Comments
//		System.out.println("List of Users are:- " + getSize(listOfUsers));
//
//		// Print Users list in console
//		getTextList(listOfUsers);
//
//		// Select User Ashok
//		jsClick(userAshok, "Other Departments Logged by User Ashok");

		// Click Submit Button
		click(otherDeptSubmitBtn, "Submit Button");

		// Switch to Parent frame
		switchToParentFrame(driver);

		// Scroll to Review Element
		scrollToViewElement(decisionReview);

		// Click on Review Radio button
		click(decisionReview, "Review");

		// Enter Remarks/Reasons
		sendText(remarkReason, RemRsn, "Remarks/Reasons");

		// Click IHOD Submit button
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		
		

		// ESign should display
		/*e_SignAvailabe();

		// Entering E_Sign Password
		EsignCnfrm(ConfigsReader.getPropValue("CCLgnIHODPwd"), cngMsg, "Change Control Login Registration Approval",
				done);*/
	}
	
	
	
	
}
