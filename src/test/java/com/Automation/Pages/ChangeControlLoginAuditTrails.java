package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.ActionEngine;


public class ChangeControlLoginAuditTrails extends ActionEngine{
	
	public ChangeControlLoginAuditTrails() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;
	@FindBy(xpath= "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	@FindBy(xpath= "//ul[@id='QAMS_PRSMGR_ISU_LGN_CC_FRM_ID_01']/preceding-sibling::a")
	WebElement ChangeControlLogin;
	
	@FindBy(linkText= "Audit Trail")
	WebElement ccLoginAuditTrailMenu;
	
	@FindBy(id= "btnAdvSearch")
	WebElement AdvancedSearchBtn;
	
	@FindBy(name="ISU_LGN_CTR_001") 
	WebElement IssueCodeFilter;
	
	@FindBy(className="text-ellipsis")
	WebElement ListRow;
	
	@FindBy(id= "btnSubmitListFilter")
	WebElement ApplyButton;
	public void ccLoginAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		click(ChangeControlLogin, "ChangeControlLogin");
		click(ccLoginAuditTrailMenu, "ccLoginAuditTrailMenu");
		switchToBodyFrame(driver);
		click(AdvancedSearchBtn, "Advanced Search");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(ListRow, "ListRow");
		switchToPopupModelFrame(driver);
		switchToDefaultContent(driver);
		
	}
	

}

