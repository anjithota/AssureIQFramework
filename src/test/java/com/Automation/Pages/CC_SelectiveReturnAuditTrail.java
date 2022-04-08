package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class CC_SelectiveReturnAuditTrail extends ActionEngine {
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	
	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/li[8]")
	WebElement CCSelectiveReturnMenu;
	
	@FindBy(id = "QAMS_PRSMGR_PRC_RET_CC_FRM_ID_AUDMEN")
	WebElement CCSelectiveReturnAuditTrailMenu;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "PRC_RET_CTF_001")
	WebElement UniqueCodeFilter;
	
	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	public void ccClsReturnAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(CCSelectiveReturnMenu, "CC Selective Return Menu");
		click(CCSelectiveReturnAuditTrailMenu, "CC Selective Return Audit Trail Menu");
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced Search button");
		TimeUtil.shortWait();

		enterAlterUniqueCode(driver, UniqueCodeFilter);
		//TimeUtil.mediumWait();


//		click(ApplyButton, "Apply button");
		

		click(Record, "Click on record");
		
		switchToPopupModelFrame(driver);
		
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
	}

}
