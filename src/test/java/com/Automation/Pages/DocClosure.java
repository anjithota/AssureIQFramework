package com.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class DocClosure extends ActionEngine {

	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=75780']//span")
	WebElement DocumentationClosureMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(id = "btnSubmitListFilter")
	WebElement Applypopup;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "DN_CLS_CTR_03_error")
	WebElement CommentsError;

	@FindBy(id = "DN_CLS_CTR_03")
	WebElement CommentsText;

	@FindBy(id = "DN_CLS_CTR_05_error")
	WebElement EMRequiredError;

	@FindBy(xpath = "//label[@for='DN_CLS_CTR_05_2']")
	WebElement EMRequiredNo;

	@FindBy(xpath = "//label[@for='DN_CLS_CTR_05_1']")
	WebElement EMRequiredYes;

	@FindBy(id = "DN_CLS_CTR_06")
	WebElement EMPopup;

	@FindBy(id = "DN_CLS_CTR_06_error")
	WebElement EMPopupError;

	@FindBy(id = "btnOk")
	WebElement OkButton;

	@FindBy(xpath = "//span[@class='error emsh-reftask-error']")
	WebElement RefTaskError;

	@FindBy(xpath = "//div[@class='caliber-control-group col-sm-4 haserror']//div[@class='py-2']//div//button[@type='button'][normalize-space()='Add Items']")
	WebElement RefTask;

	@FindBy(name = "UniqueCode")
	WebElement UcodeFilter;

	@FindBy(xpath = "//thead/tr[1]/th[2]/input[1]")
	WebElement Descriptionfilter;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement AddRecord;

	@FindBy(className = "caliber-button-primary")
	WebElement AddButton;

	@FindBy(xpath = "//div[@class='caliber-control-group col-sm-4 emsh-toForm haserror']//div[@class='py-2']//div//button[@type='button'][normalize-space()='Add Items']")
	WebElement FormPopup;

	@FindBy(xpath = "//span[@class='error emsh-toForm-error']")
	WebElement FormError;

	@FindBy(className = "text-ellipsis")
	WebElement FormRadioButton;

	@FindBy(xpath = "//span[@class='error emsh-toGroup-error']")
	WebElement AssignToError;

	@FindBy(xpath = "//div[@class='caliber-control-group col-sm-4 emsh-toGroup haserror']//div[@class='py-2']//div//button[@type='button'][normalize-space()='Add Items']")
	WebElement AssignToPopup;

	@FindBy(xpath = "//span[@class='error emsh-description-error']")
	WebElement DecsriptionError;

	@FindBy(xpath = "//textarea[@class='caliber-textarea form-control emsh-description']")
	WebElement Decsription;

	@FindBy(xpath = "//span[@class='error emsh-startdate-error']")
	WebElement StartDateError;

	@FindBy(xpath = "//input[@class='dateVCText form-control emsh-inp-startdate']")
	WebElement StartDate;

	@FindBy(xpath = "//span[@class='error emsh-duration-error']")
	WebElement DurationError;

	@FindBy(xpath = "//input[@class='form-control emsh-duration']")
	WebElement Duration;

	@FindBy(xpath = "//span[@class='error emsh-typeId-error']")
	WebElement TypeError;

	@FindBy(xpath = "//label[contains(text(),'Single')]")
	WebElement TypeNo;

	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Documentation Action Plan Closure']")
	WebElement DocClsMenu;

	@FindBy(id = "QAMS_PRSMGR_DN_CLS_FRM_ID_01_AUDMEN")
	WebElement DocClsAuditTrailMenu;// QAMS_PRSMGR_DN_CLS_FRM_ID_01_AUDMEN

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;

	@FindBy(id = "txtESignPassword")
	WebElement psaawordtext;

	public void docClsInitiation(String Comments) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocumentationClosureMenu);
		click(DocumentationClosureMenu, "CLosure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssueCodeFilter);
	//	sendText(IssueCodeFilter, "%63", "Isssue Code Filter");
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(CommentsText, Comments, "Comments");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(CommentsError, "Select Value");
		click(EMRequiredNo, "No");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	}

	public void docClsInitiationEM(String Comments, String RefID, String FormId, String DeptId, String Description,
			String duration) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocumentationClosureMenu);
		click(DocumentationClosureMenu, "CLosure Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		//sendText(IssueCodeFilter, "%63", "Isssue Code Filter");
		// sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040%", "Isssue Code Filter");
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		sendText(CommentsText, Comments, "Comments");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(CommentsError, "Select Value");
		click(EMRequiredYes, "Yes");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(EMPopupError, "Select Value");
		click(EMPopup, "EM plan Popup");
		switchToPopupModelFrame(driver);
		// switchToPopupFormFrame(driver);
		click(OkButton, "Ok button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(RefTaskError, "Select Value");
		click(RefTask, "Reference Task");
		switchToPopupModelFrame(driver);
		click(AdvanceSearchButton, "Advanced Search");
		sendText(UcodeFilter, RefID, "Ref Code");// CC-PL01-Admin-22-0007-DN-0001/W3/1
		// scrollToViewElement(Applypopup);
		WebElement Applybtn = driver
				.findElement(By.xpath("//button[@class='caliber-button-primary caliber-button-sm']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Applybtn);
		Applybtn.click();
		// click(ApplyButton, "Apply button");
		click(AddRecord, "Add Record");
		TimeUtil.shortWait();
		click(OkButton, "Add Button");
		TimeUtil.mediumWait();
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		driver.switchTo().frame("bodyFrame").switchTo().frame("PopupModalFrame");
		TimeUtil.shortWait();
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);

		verifyCaptionContains(FormError, "Select Value");
		click(FormPopup, "Form popup");
		// switchToPopupModelFrame(driver);
		switchToPopupModelFrame(driver);
		click(AdvanceSearchButton, "Advanced Search");
		sendText(UcodeFilter, FormId, "Ref Code");// DN_EM_TSK_FRM_ID_01
		click(Applypopup, "Apply button");
		click(FormRadioButton, "Form Popup Radio button");
		click(OkButton, "Ok Button");

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		driver.switchTo().frame("bodyFrame").switchTo().frame("PopupModalFrame");
		TimeUtil.shortWait();
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(AssignToError, "Select Value");
		click(AssignToPopup, "Assign To popup");
		switchToPopupModelFrame(driver);
		click(AdvanceSearchButton, "Advanced Search");
		sendText(UcodeFilter, DeptId, "Dept Code");// IT
		click(Applypopup, "Apply button");
		click(FormRadioButton, "Form Popup Radio button");
		click(OkButton, "Ok Button");

		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		driver.switchTo().frame("bodyFrame").switchTo().frame("PopupModalFrame");
		TimeUtil.shortWait();
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(DecsriptionError, "Enter Value");
		sendText(Decsription, Description, "Description EM plan");
		switchToParentFrame(driver);
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(DecsriptionError, "Select Value");// 20/01/22
		sendText(StartDate, "16 Feb 2022", "Start Date EM plan");

		switchToParentFrame(driver);
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(DurationError, "Enter Value");
		sendText(Duration, duration, "Start Date EM plan");

		switchToParentFrame(driver);
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		verifyCaptionContains(TypeError, "Select Value");
		click(TypeNo, "Type no");

		switchToParentFrame(driver);
		click(OkButton, "Ok Button");
		switchToPopupFormFrame(driver);
		 E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));

		/*switchToDefaultContent(driver);
		TimeUtil.shortWait();*/
		/*
		 * driver.switchTo().frame("bodyFrame").switchTo().frame("PopupModalFrame");
		 * TimeUtil.shortWait();
		 */
		// driver.findElement(By.className("close")).click();

		//sendText(psaawordtext, ConfigsReader.getPropValue("CCLgnQAPwd"), "password");
//		TimeUtil.shortWait();
		// E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));
		/*
		 * switchToDefaultContent(driver); switchToBodyFrame(driver); click(SubmitBtn,
		 * "Submit"); E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));
		 * switchToDefaultContent(driver);
		 */
		 switchToDefaultContent(driver); 
		 switchToBodyFrame(driver);
		 click(SubmitBtn,"Submit");
		 E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnQAPwd"));
		 switchToDefaultContent(driver);
		 
	}

	public void donClsAuditTrail() {
		switchToDefaultContent(driver);
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocClsMenu, "Doc closure menu");
		scrollToViewElement(DocClsAuditTrailMenu);
		click(DocClsAuditTrailMenu, "Doc closure Audit Trail");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);

		// sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040%", "Issue code");
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		//click(SubmitBtn, "Submit");

	}

}
  