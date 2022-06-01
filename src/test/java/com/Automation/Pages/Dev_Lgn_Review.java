package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_Lgn_Review extends ActionEngine {
	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;

	@FindBy(id = "MyTaskPrc_DEV_ISU_LGN_DEV_FRM_ID_01")
	WebElement DevLgnTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//label[@for='EsignerDecision_14']")
	WebElement ReviewDecision;
	
	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnDecision;

	@FindBy(id = "ISU_LGN_CTR_025_error")
	WebElement IHodCommentsError;

	@FindBy(id = "ISU_LGN_CTR_025")
	WebElement IHodCommentsText;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_128_2']")
	WebElement ProbablereasonRequired;

	@FindBy(id = "ISU_LGN_CTR_128_error")
	WebElement ProbablereasonRequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_105_1']")
	WebElement CorrectiveActionrequired;

	@FindBy(id = "ISU_LGN_CTR_105_error")
	WebElement CorrectiveActionrequiredError;

	@FindBy(id = "ISU_LGN_CTR_106_error")
	WebElement CorrectiveActionError;

	@FindBy(id = "ISU_LGN_CTR_106")
	WebElement CorrectiveActionButton;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_107_2']")
	WebElement PreventiveActionrequired;

	@FindBy(id = "ISU_LGN_CTR_107_error")
	WebElement PreventiveActionrequiredError;

	@FindBy(id = "ISU_LGN_CTR_134")
	WebElement ReasonsForNotPA;

	@FindBy(id = "ISU_LGN_CTR_134_error")
	WebElement ReasonsForNotPAerror;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_109_2']")
	WebElement OtherActionrequired;

	@FindBy(id = "ISU_LGN_CTR_109_error")
	WebElement OtherActionrequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_192_2']")
	WebElement ContainmentActionrequired;

	@FindBy(id = "ISU_LGN_CTR_192_error")
	WebElement ContainmentActionrequiredError;

	@FindBy(id = "ISU_LGN_CTR_195_button")
	WebElement OtherDepartmentComments;

	@FindBy(id = "ISU_LGN_CTR_195_error")
	WebElement OtherDepartmentCommentsError;
	
	@FindBy(xpath = "//button[@onclick='fnSetValues()']")
	WebElement otherDeptSubmitBtn;
	
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
	
	@FindBy(id = "btnSubmit")
	WebElement submitBtn;
	
	@FindBy(id = "txtRemarks")
	WebElement remarkReason;

	
	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_105_2']")
	WebElement CAActionPlanNo;
	
	@FindBy(id="ISU_LGN_CTR_133")
	WebElement CAResons;


	public void devIhodApproval(String hodComments, String planDesc, String reasonForPA) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(IHodCommentsError, "Enter Value");
		sendText(IHodCommentsText, hodComments, "Ihod comments");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(ProbablereasonRequiredError, "Select Value");

		click(ProbablereasonRequired, "Probable Reason Required No");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(CorrectiveActionrequiredError, "Select Value");

		click(CorrectiveActionrequired, "Corrective Action Required Yes");

		verifyCaptionContains(CorrectiveActionError, "Select Value");

		click(CorrectiveActionButton, "Corrective Action");

		dnLgnInitiationForCC.dnLoginInitiationCC(planDesc);

		scrollToViewElement(ReviewDecision);

		verifyCaptionContains(PreventiveActionrequiredError, "Select Value");

		click(PreventiveActionrequired, "Preventive Action Required No");

		scrollToViewElement(ReviewDecision);

		verifyCaptionContains(ReasonsForNotPAerror, "Enter Value");

		sendText(ReasonsForNotPA, reasonForPA, "Reason for PA not required");

		scrollToViewElement(ReviewDecision);

		verifyCaptionContains(OtherActionrequiredError, "Select Value");

		click(OtherActionrequired, "Other Action Required No");

		scrollToViewElement(ReviewDecision);

		verifyCaptionContains(ContainmentActionrequiredError, "Select Value");

		click(ContainmentActionrequired, "Containment Action Required No");

		verifyCaptionContains(OtherDepartmentCommentsError, "Select Value");
		click(OtherDepartmentComments, "Other Department Comments");
		
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
		
		scrollToViewElement(ReviewDecision);
		click(ReviewDecision, "Review");
		
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		
		switchToDefaultContent(driver);


	}
	
	public void ihodReturn(String reason) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		scrollToViewElement(ReturnDecision);
		click(ReturnDecision, "Return");
		click(submitBtn, "Submit button");
		
		
		
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		
		//verifyCaptionContains(element, "Enter Value");
		
		
		switchToDefaultContent(driver);
		
	}
	
	public void ihodAgainReview(String hodComments, String reason) {
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		clearField(IHodCommentsText, "Ihod Comments");
		sendText(IHodCommentsText, hodComments, "Hod Comments");
		scrollToViewElement(ReviewDecision);
		click(ReviewDecision, "Review");
		sendText(remarkReason, reason, "Remarks");
		click(submitBtn, "Submit button");
		
		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		
		//verifyCaptionContains(element, "Enter Value");
		
		
		switchToDefaultContent(driver);
		
	}
	
	
	public void devLgnreviewNoActionPlan(String hodComments,String reasonForCA, String reasonForPA)
	{
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		//switchToDefaultContent(driver);
		switchToTaskListFrame(driver);

		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(IHodCommentsError, "Enter Value");
		sendText(IHodCommentsText, hodComments, "Ihod comments");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(ProbablereasonRequiredError, "Select Value");

		click(ProbablereasonRequired, "Probable Reason Required No");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");

		verifyCaptionContains(CorrectiveActionrequiredError, "Select Value");
		
		click(CAActionPlanNo, "Corrective action no");
		
		sendText(CAResons, reasonForCA, "Reason for CA");

			
		scrollToViewElement(ReviewDecision);
		
		click(ReviewDecision, "Review");

		verifyCaptionContains(PreventiveActionrequiredError, "Select Value");

		click(PreventiveActionrequired, "Preventive Action Required No");

		scrollToViewElement(ReviewDecision);

		click(ReviewDecision, "Review");
		
		verifyCaptionContains(ReasonsForNotPAerror, "Enter Value");

		sendText(ReasonsForNotPA, reasonForPA, "Reason for PA not required");

		scrollToViewElement(ReviewDecision);
		
		click(ReviewDecision, "Review");

		verifyCaptionContains(OtherActionrequiredError, "Select Value");

		click(OtherActionrequired, "Other Action Required No");

		scrollToViewElement(ReviewDecision);
		
		click(ReviewDecision, "Review");

		verifyCaptionContains(ContainmentActionrequiredError, "Select Value");

		click(ContainmentActionrequired, "Containment Action Required No");

scrollToViewElement(ReviewDecision);
		
		click(ReviewDecision, "Review");
		verifyCaptionContains(OtherDepartmentCommentsError, "Select Value");
		click(OtherDepartmentComments, "Other Department Comments");
		
		switchToPopupModalFrame2(driver);

		// Verify Other Department Heading
		verifyCaptionContains(OtherDepartmentCmts, "Department Required to Provide Comments");

		// Click Other Department Add Item
		jsClick(OtherDeptAdd, "Other Department Cmts Add");

		// Select Department for Other Department Comments
		
		 jsClick(otherDeptDD, "Other Departments");
		  
		/* // Get the size of Department for Other Department Comments
		 * System.out.println("List of Departments to Task Allocate:- " +
		 * getSize(listOfOtherDept));
		 * 
		 */
		// Select Admin Department
		jsClick(AdminDept, "Administration");


		// Click Submit Button
		click(otherDeptSubmitBtn, "Submit Button");

		// Switch to Parent frame
		switchToParentFrame(driver);
		
		scrollToViewElement(ReviewDecision);
		click(ReviewDecision, "Review");
		
		click(submitBtn, "IHOD Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		


		
	}

}
