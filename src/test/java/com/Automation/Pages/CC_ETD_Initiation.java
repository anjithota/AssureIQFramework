package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class CC_ETD_Initiation extends ActionEngine {

	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnEtd")
	WebElement ETDbutton;

	@FindBy(xpath = "//div[text()='Change Control']")
	WebElement changeControl;

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

	@FindBy(xpath = "//input[@class='form-control etd-duration']")
	WebElement MainProcessDuration;

	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=81068']//span")
	WebElement ETDTaskMenu;

	@FindBy(xpath = "//input[@id='EsignerDecision_2']")
	WebElement ApproveBtn;

	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Extension of Target Date']")
	WebElement ETDMenu;

	@FindBy(id = "QAMS_PRSMGR_CC_ETD_FRM_ID_01_AUDMEN")
	WebElement ETDAuditTrail;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(id="txtRemarks")
	WebElement Remark;
	
	@FindBy(xpath = "//label[text()='Approve']")
	WebElement decisionReview;

	public void ccEtdInitiation(String Days) {
		click(initiate, "InitiateButtton");
		click(ETDbutton, "Etd Button");
		TimeUtil.shortWait();
		switchToPopupModelFrame(driver);

		click(changeControl, "Change Control Tile");
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
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);

		// E_sign.equals(obj)

	}

	public void ccEtdReview() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ETDTaskMenu);
		click(ETDTaskMenu, "ETD My Task");
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
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		switchToDefaultContent(driver);

	}
	
	public void ccEtdApprove() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(ETDTaskMenu);
		click(ETDTaskMenu, "ETD My Task");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssuecodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(decisionReview, "Approve");
		//click(ApproveBtn, "Approve");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));
		switchToDefaultContent(driver);

	}
	

	public void ccEtdAuditTrail() {
		switchToDefaultContent(driver);
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(ETDMenu, "ETD menu");
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
