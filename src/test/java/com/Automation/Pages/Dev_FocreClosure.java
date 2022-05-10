package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class Dev_FocreClosure extends ActionEngine{

	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

@FindBy(id = "DEFC_04")
WebElement DevForceClosureAuditTrailMenu;
@FindBy(className = "popup-close-button")
WebElement AuditTrailClose;

@FindBy(className= "dateVCBtn")
WebElement DateFilter;

@FindBy(xpath="//li[text()='Last 30 Days']")
WebElement LastThirtyBtn;


public void devForceClosureAuditTrail(){
	switchToDefaultContent(driver);
	click(ProcessmanagerMenu, "Process manager");
	scrollToViewElement(DevForceClosureAuditTrailMenu);
	click(DevForceClosureAuditTrailMenu, "Deviation force closure Audit Trail");
	switchToBodyFrame(driver);
	click(AdvanceSearchButton, "Advanced sreach button");
	enterUniqueCode(driver, IssuecodeFilter);
	click(DateFilter, "Date calendar");
	click(LastThirtyBtn, "Last 30 days");
	click(ApplyButton, "Apply button");
	click(Record, "Record");
	switchToPopupModelFrame(driver);
	click(AuditTrailClose, "Close Button");
	switchToDefaultContent(driver);
}

}
