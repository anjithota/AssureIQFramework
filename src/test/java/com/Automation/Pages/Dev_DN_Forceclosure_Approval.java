package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Dev_DN_Forceclosure_Approval extends ActionEngine {
	@FindBy(xpath = "//span[text()=' Process Manager ']")
	WebElement processmanagerMytask;

	@FindBy(id = "MyTaskMod_PRSMGR_PRC_FCL_DN_FRM_ID")
	WebElement ForceclosureDNmyTask;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement ForceClosureIssueCode;

	@FindBy(id = "btnSubmitListFilter")
	WebElement Applybtn;

	@FindBy(className = "text-ellipsis")
	WebElement clickrecord;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement Approvebtn;

	@FindBy(id = "btnSubmit")
	WebElement Submitbtn;

	@FindBy(xpath = "//label[@for='EsignerDecision_4']")
	WebElement Dropbtn;

	@FindBy(id = "txtRemarks")
	WebElement RemarkReasons;
	
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons active']")
	WebElement icons;
	
	@FindBy(id="DNFC_04")
	WebElement ForceClosureAdit;
	
	@FindBy(className = "text-ellipsis")
	WebElement ClickRecord;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement ClosePopUp;

	public void devDNfroceclosureApprove() {
		switchToBodyFrame(driver);
		scrollToViewElement(processmanagerMytask);
		click(processmanagerMytask, "process manager Menu");
		scrollToViewElement(ForceclosureDNmyTask);
		click(ForceclosureDNmyTask, "force closure my task");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Searchbtn");
		enterUniqueCode(driver, ForceClosureIssueCode);
		click(Applybtn, "Apply");
		click(clickrecord, "record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Approvebtn, "approve btn");
		click(Submitbtn, "Submit btn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}
    
	public void devDNforceClosuredrop(String remarks) {
		switchToBodyFrame(driver);
		scrollToViewElement(processmanagerMytask);
		click(processmanagerMytask, "process manager Menu");
		scrollToViewElement(ForceclosureDNmyTask);
		click(ForceclosureDNmyTask, "force closure my task");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Searchbtn");
		enterUniqueCode(driver, ForceClosureIssueCode);
		click(Applybtn, "Apply");
		clearField(clickrecord, "record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(Dropbtn, "Drop btn");
		sendText(RemarkReasons, remarks, "remarks reasons");
		click(Submitbtn, "submit btn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		switchToDefaultContent(driver);

	}
	
	public void devDNForceClosureAditTrails()
	{
		click(icons, "click menu");
		scrollToViewElement(ForceClosureAdit);
		click(ForceClosureAdit, "Click audit");
		switchToBodyFrame(driver);
		click(ClickRecord, "Click Record");
		click(ClosePopUp, "CloseBox");
		switchToDefaultContent(driver);
	}
	
	
}
