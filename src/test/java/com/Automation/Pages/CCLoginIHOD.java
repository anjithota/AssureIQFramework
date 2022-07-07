package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class CCLoginIHOD extends ActionEngine {
	public CCLoginIHOD() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Change Control Login']")
	WebElement MytaskCCLogin;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvanceSearch;
	
	@FindBy(name= "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;
	
	@FindBy(className= "text-ellipsis")
	WebElement Record;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement FilterApplyBtn;
	
	@FindBy(id= "ISU_LGN_CTR_025")
	WebElement IHODComments;
	
	@FindBy(id= "ISU_LGN_CTR_191")
	WebElement AssumedCateory;
	
	@FindBy(xpath="//div[@class='switch-field']//label[1]")
	WebElement ActionPlanREquredYES;
	
	@FindBy(id="ISU_LGN_CTR_027")
	WebElement ActionPlanPopup;
	
	@FindBy(xpath="//span[text()='Documentation Action Plan']")
	WebElement DocActionPlanicon;
	
	@FindBy(id="btnSubmit")
	WebElement ProceedActionPopup;
	
	@FindBy(id="DN_LGN_CTR_001")
	WebElement DocPlanCescription;
	
	@FindBy(id="DN_LGN_CTR_002")
	WebElement InitiatingDepartmentPopup;
	
	@FindBy(name="MST_DEP_CTF_002")
	WebElement DeptCode;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplySearchfilter;
	
	@FindBy(id="btnOk")
	WebElement OkBtnDept;
	
	@FindBy(xpath= "//span[contains(text(),'IT')]")
	WebElement ITDepartment;
	
	@FindBy(id="DN_LGN_CTR_009_button")
	WebElement TaskAllocation;
	
	@FindBy(id="btnAddTask_3456")
	WebElement DocTaskAllocation;
	
	@FindBy(xpath="//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement Depaertmentselect;
	
	@FindBy(xpath="//button[@class='caliber-button-primary float-right']")
	WebElement AlloactionSubmit;
	
	@FindBy(id="btnLockTranasction")
	WebElement Actionplanlocbtn;
	
	@FindBy(xpath= "//button[@id='btnOk']")
	WebElement OkAction;
	
	@FindBy(id="ISU_LGN_CTR_195_button")
	WebElement OTDAllocation;
	
	@FindBy(id="btnAddTask_342")
	WebElement OtdAddInFrame;
	
	@FindBy(xpath="//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement OtdAlloactionDept;
	
	@FindBy(xpath="//button[@onClick='fnSetValues()']")
	WebElement otdSubmit;
	
	@FindBy(xpath="//input[@id='EsignerDecision_14']//lable[1")
	WebElement Reviewbtn;
	
	@FindBy(xpath = "//*[text()='Return']")
	WebElement decisionReturn;
	
	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement alertRemarkReason;
	

	@FindBy(id = "cfnMsg_Next")
	WebElement done;
	
	@FindBy(id = "txtRemarks")
	WebElement remarkReason;
	
	@FindBy(xpath = "(//div[@class='confirmation-message-text'])[2]")
	WebElement cngMessage;
	
	@FindBy(id = "btnSubmit")
	WebElement submitBtn;
	//@FindBy(xpath="/select")//task-allocation-ugp select2-hidden-accessible
	/*@FindBy(id="btnOk")
	WebElement OkActionplan;*/
	//PROV-CC-PL01-Admin-21-0063
	
	public void ccLHODRecordClick(/*String HodComments,String Doc*/) {
		switchToBodyFrame(driver);
		scrollToViewElement(MytaskCCLogin);
		click(MytaskCCLogin, "CC login");
		click(AdvanceSearch, "Search");
		sendText(IssueCodeFilter, "PROV-CC-PL01-Admin-21-0063", "filter");
		click(FilterApplyBtn, "Filter Apply");
		click(Record, "Rec");
	}
	public void ccLHODApprove(){
		//switchToBodyFrame(driver);
		sendText(IHODComments, "HodComments", "Ihod Comments");
		//selectOptionFromDropdownByName(AssumedCateory, "Major", "category");
		TimeUtil.shortWait();
		jsClick(ActionPlanREquredYES, "Action plan Radio");
		//click(ActionPlanREquredYES, "Action Paln Yes");
		click(ActionPlanPopup, "Action plan popup");
		switchToPopupModelFrame(driver);
		click(DocActionPlanicon, "Documentation Action plan icon");
		click(ProceedActionPopup, "Proceed button");
		TimeUtil.shortWait();
		switchToPopupFormFrame(driver);
		sendText(DocPlanCescription, "Docmentation", "Description");
		click(InitiatingDepartmentPopup, "Initiation Deparment");
		switchToPopupModelFrame(driver);
		click(AdvanceSearch, "Advance Search button");
		sendText(DeptCode, "IT", "IT Department");
		//click(ITDepartment, "IT Depart");
		click(ApplySearchfilter, "Initiating dept");
		TimeUtil.shortWait();
		click(ITDepartment, "IT Depart");
		click(OkBtnDept, "Ok button");
		//switchToParentFrame(driver);
		switchToParentFrame(driver);
		click(TaskAllocation, "TaskAllocation");
		switchToPopupModalFrame2(driver);
		click(DocTaskAllocation, "DocTaskAllocation Popup");
		selectOptionFromDropdownByName(Depaertmentselect, "Information Technology ( IT )", "IT Department");
		click(AlloactionSubmit, "Submit");
		switchToParentFrame(driver);
		click(Actionplanlocbtn, "Lock button");//itsworked
		switchToParentFrame(driver);
		TimeUtil.shortWait();
		/*click(OkAction,"Ok");*/
		//switchToPopupModelFrame(driver);
		
		
		jsClick(OkAction, "action ok");//both ARE IN same frame
		switchToParentFrame(driver);
		TimeUtil.shortWait();	
		/*switchToParentFrame(driver);
		TimeUtil.shortWait();*/
		
		
		//x
		TimeUtil.shortWait();
		click(OTDAllocation, "Otd");
		switchToPopupModalFrame2(driver);
		//click(ot, elementName);
		click(OtdAddInFrame, "otd add item in frame");
		selectOptionFromDropdownByName(OtdAlloactionDept, "R&D ( R&D )", "RnD dept");
		TimeUtil.shortWait();
		/////switchToParentFrame(driver);
		jsClick(otdSubmit, "Submit");
		//click(otdSubmit, "Submit");
		switchToParentFrame(driver);
		click(Reviewbtn, "reviewed");
		
	}
	
	public void ccHodReturn(String RemarkReason) {
		// Select Return Radio Button
				click(decisionReturn, "Return");

				// Enter Remark(s)/Reason(s)
				sendText(remarkReason, RemarkReason, "RemarksReasons");

				// Click Submit Button
				click(submitBtn, "Submit");

				/*// ESign should display
				e_SignAvailabe();*/

				// Confirmation Message
				EsignCnfrm(ConfigsReader.getPropValue("CCLgnFirstPwd"), cngMessage, "Transaction Returned", done);

				// Switch to Page
				switchToDefaultContent(driver);
		
		
	}
	

}
