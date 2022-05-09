package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DocExecutionInitiation extends ActionEngine {
	@FindBy(xpath="//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=75775']//span")
	WebElement DocumentationExecutionMenu;
	
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
	
	@FindBy(id = "DN_EXE_CTR_03")
	WebElement ActionsTakenText;
	

	@FindBy(id = "DN_EXE_CTR_03_error")
	WebElement ActionsTakenTextError;
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;

	@FindBy(xpath = "//a[text()='Documentation Action Plan Execution']")
	WebElement DocExeMenu;
	
	@FindBy(id="QAMS_PRSMGR_DN_EXE_FRM_ID_01_AUDMEN")
	WebElement DocEXEAuditTrailMenu;
	
	
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;

	
	@FindBy(xpath = "//small[text()='DN']")
	WebElement DocActionplanMyTask;
	
	@FindBy(id = "MyTaskPrc_DN_DN_EXE_FRM_ID_01")
	WebElement DocExecutionMyTask;
	
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessManagersp;
	
	@FindBy(id = "DNEX_04")
	WebElement DocumentExeAuditTrailSP;
	

	
	public void docExeInitiationDetails(String ActionsTaken) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocumentationExecutionMenu);
		click(DocumentationExecutionMenu, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(ActionsTakenTextError, "Enter Value");
		sendText(ActionsTakenText, ActionsTaken, "Comments");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	}
	
	public void donExeAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(DocExeMenu, "Doc Task menu");
		scrollToViewElement(DocEXEAuditTrailMenu);
		click(DocEXEAuditTrailMenu, "Doc Task exe Audit Trail");
		switchToBodyFrame(driver);
		

		click(AdvanceSearchButton, "Advanced Search button");

		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Issue code");
		
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);


	
	}
	
	public void docExeInitiationDetailsSP(String ActionsTaken) {
		switchToBodyFrame(driver);
		scrollToViewElement(DocActionplanMyTask);
		click(DocActionplanMyTask, "Docmentation menu");
		click(DocExecutionMyTask, "Login Menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		//sendText(IssueCodeFilter, "CC-PL01-Admin-21-0040", "Isssue Code Filter");
		
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitBtn, "Submit");
		verifyCaptionContains(ActionsTakenTextError, "Enter Value");
		sendText(ActionsTakenText, ActionsTaken, "Comments");
		click(SubmitBtn, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);
	}
	
	public void docTaskAuditTrailSP() {
		//click(assureiq, "Assure IQ Menu");
		click(ProcessManagersp, "Process Manager");
		//click(DocLogin, "Doc Login menu");
		scrollToViewElement(DocumentExeAuditTrailSP);
		click(DocumentExeAuditTrailSP, "Doc Audit Trail");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
		
	}

	
	
}
