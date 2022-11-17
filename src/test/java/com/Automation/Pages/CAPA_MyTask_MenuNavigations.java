package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class CAPA_MyTask_MenuNavigations extends ActionEngine {

	@FindBy(xpath = "//small[text()='CAPA']")
	WebElement CAPAMyTaskMenu;

	@FindBy(id = "MyTaskPrc_CAPA_ISU_CAP_LGN_FRM_ID_01")
	WebElement CAPALoginMyTaskMenu;

	@FindBy(id = "MyTaskPrc_CAPA_ISU_CAP_OTD_FRM_01")
	WebElement CAPAOTDMyTaskMenu;

	@FindBy(id = "MyTaskPrc_CAPA_ISU_CAP_QAD_FRM_01")
	WebElement CAPAQADMyTaskMenu;

	@FindBy(id = "MyTaskPrc_CAPA_ISU_CAP_CLS_FRM_ID_02")
	WebElement CAPAClosureMyTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	// CAPA Audit Trail Elements
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;

	@FindBy(id = "CAPL_04")
	WebElement CAPALoginAuditTrailMenu;

	@FindBy(id = "CACL_04")
	WebElement CAPAClosureAuditTrailMenu;

	@FindBy(id = "CAP0_04")
	WebElement CAPAOTDAuditTrailMenu;

	@FindBy(id = "CAQD_04")
	WebElement CAPAQDDAuditTrailMenu;

	@FindBy(xpath = "//div[text()='Registration']")
	WebElement Revision0;

	@FindBy(xpath = "//div[text()='Modification']")
	WebElement Revision1;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceed;

	@FindBy(xpath = "//span[@class='popup-close-button']")
    WebElement ClosePop;
	
	@FindBy(xpath = "//div[@class='event-div']")
    WebElement Events;
	
	public void capaLoginMytaskNavigation_SP() {

		switchToBodyFrame(driver);
		scrollToViewElement(CAPAMyTaskMenu);
		click(CAPAMyTaskMenu, "CAPA My Task Menu");
		click(CAPALoginMyTaskMenu, "CAPA Login My Task Menu");
		switchToTaskListFrame(driver);
		capaMytaskSearchRecord();
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void capaOTDMytaskNavigation_SP() {

		switchToBodyFrame(driver);
		scrollToViewElement(CAPAMyTaskMenu);
		click(CAPAMyTaskMenu, "CAPA My Task Menu");
		click(CAPAOTDMyTaskMenu, "CAPA Other Department Comments My Task Menu");
		switchToTaskListFrame(driver);
		capaMytaskSearchRecord();
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void capaQADMytaskNavigation_SP() {

		switchToBodyFrame(driver);
		scrollToViewElement(CAPAMyTaskMenu);
		click(CAPAMyTaskMenu, "CAPA My Task Menu");
		click(CAPAQADMyTaskMenu, "CAPA QA Decision My Task Menu");
		switchToTaskListFrame(driver);
		capaMytaskSearchRecord();
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
	}

	public void capaClosureMytaskNavigation_SP() {

		switchToBodyFrame(driver);
		scrollToViewElement(CAPAMyTaskMenu);
		click(CAPAMyTaskMenu, "CAPA My Task Menu");
		click(CAPAClosureMyTaskMenu, "CAPA Closure My Task Menu");
		switchToTaskListFrame(driver);
		capaMytaskSearchRecord();
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
	}

	public void capaMytaskSearchRecord() {
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");

	}

	
	//-----------------Audit Trails-------------------------------
	
	
	public void capaLoginAuditTrailNavigation_SP() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(CAPALoginAuditTrailMenu);
		click(CAPALoginAuditTrailMenu, "CAPA Login Audit Trail Menu");
		switchToBodyFrame(driver);
		capaMytaskSearchRecord();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(ClosePop, "Close button");
		switchToDefaultContent(driver);
	}

	public void capaOTDAuditTrailNavigation_SP() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(CAPAOTDAuditTrailMenu);
		click(CAPAOTDAuditTrailMenu, "CAPA OTD Audit Trail Menu");
		switchToBodyFrame(driver);
		capaMytaskSearchRecord();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(ClosePop, "Close button");
		switchToDefaultContent(driver);
	}

	public void capaQADAuditTrailNavigation_SP() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(CAPAQDDAuditTrailMenu);
		click(CAPAQDDAuditTrailMenu, "CAPA QA Decision Audit Trail Menu");
		switchToBodyFrame(driver);
		capaMytaskSearchRecord();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(ClosePop, "Close button");
		switchToDefaultContent(driver);
	}

	public void capaClosureAuditTrailNavigation_SP() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(CAPAClosureAuditTrailMenu);
		click(CAPAClosureAuditTrailMenu, "CAPA Closure Audit Trail Menu");
		switchToBodyFrame(driver);
		capaMytaskSearchRecord();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(ClosePop, "Close button");
		switchToDefaultContent(driver);
	}
	
	public void capaLoginRevisionAuditTrailNavigation_SP() {
		switchToDefaultContent(driver);
		click(ProcessmanagerMenu, "ProcessmanagerMenu");
		scrollToViewElement(CAPALoginAuditTrailMenu);
		click(CAPALoginAuditTrailMenu, "CAPA Login Audit Trail Menu");
		switchToBodyFrame(driver);
		capaMytaskSearchRecord();
		switchToPopupModelFrame(driver);
		click(Revision0, "Revision");
		click(proceed, "Proceed BUtton"); 
		scrollToViewElement(Events);
		click(ClosePop, "Close button");
		switchToDefaultContent(driver);
	}


}
