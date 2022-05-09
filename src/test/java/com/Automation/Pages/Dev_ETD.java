package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Dev_ETD extends ActionEngine{
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnEtd")
	WebElement ETDbutton;

	@FindBy(xpath = "//div[text()='Deviation']")
	WebElement Deviation;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;
	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(className = "toast-message")
	WebElement AlertMessage; // Atleast one duration field is required

	@FindBy(className = "toast-close-button")
	WebElement AlertClose;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id = "MyTaskMod_PRSMGR_DEV_ETD_FRM_ID_01")
	WebElement MYtaskETDSP;
	
	@FindBy(xpath = "//span[@title='Process Manager']")
	WebElement ProcessManagerMyTaskMenu;

	@FindBy(xpath = "//input[@class='form-control etd-duration']")
	WebElement MainProcessDuration;

	@FindBy(xpath = "//input[@id='EsignerDecision_2']")
	WebElement ApproveBtn;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(id="txtRemarks")
	WebElement Remark;
	
	@FindBy(xpath = "//label[text()='Approve']")
	WebElement decisionReview;
	
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessManager;
	
	@FindBy(id = "DVET_04")
	WebElement ETDAuditTrail;
	
	
	public void devEtdInitiation(String Days) {
		click(initiate, "InitiateButtton");
		click(ETDbutton, "Etd Button");
		TimeUtil.shortWait();
		switchToPopupModelFrame(driver);

		click(Deviation, "Deviation Tile");
		click(proceedButton, "Proceed");

		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced search");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		click(SubmitBtn, "Submit button");
		verifyCaptionContains(AlertMessage, "Atleast one duration field is required");
		click(AlertClose, "Close Alert");
		sendText(MainProcessDuration, Days, "Duration days");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnID"));
		switchToDefaultContent(driver);

		// E_sign.equals(obj)

	}
	
	public void devEtdReview() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process manager My Task");
		click(MYtaskETDSP, "My Task ETD menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		TimeUtil.shortWait();
//		switchToDefaultContent(driver);
//		switchToBodyFrame(driver);
		click(decisionReview, "Approve");
		//jsClick(decisionReview, "aa");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevID"));
		switchToDefaultContent(driver);

	}
	
	public void devEtdApprove() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ProcessManagerMyTaskMenu);
		click(ProcessManagerMyTaskMenu, "Process manager My Task");
		click(MYtaskETDSP, "ETD My task");
		
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(decisionReview, "Approve");
		//click(ApproveBtn, "Approve");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevApprPwd"));
		switchToDefaultContent(driver);

	}
	
	
	public void devEtdAuditTrail() {
		switchToDefaultContent(driver);//dvet
		click(ProcessManager, "Process Manager");
		
		//click(ETDMenu, "ETD menu");
		scrollToViewElement(ETDAuditTrail);
		click(ETDAuditTrail, "ETD Audit Trail");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);

	}

	

	
	

	

}
