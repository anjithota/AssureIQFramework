package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;
                          
public class CCDN_ForceClosureInitiation extends ActionEngine{
	@FindBy(id = "btnCreate")
	WebElement initiate;
	
	@FindBy(xpath = "//div[text()='Documentation Action Plan']")
	WebElement DocumentationActionPlan;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;
	 
	@FindBy(id = "btnProcessClosure")
	WebElement ForceClosureButton;
	
	@FindBy(className= "dateVCBtn")
	WebElement DateFilter;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "DN_LGN_CTR_006")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath="//li[text()='Last 30 Days']")
	WebElement LastThirtyBtn;


	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	
	
	@FindBy(xpath="//a[text()='Force Closure - DN']")
	WebElement ForceClosureDNMenu;
	
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	
	@FindBy(id="QAMS_PRSMGR_PRC_FCL_DN_FRM_ID_AUDMEN")
	WebElement ForceClosureAuditTrial;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;


	public void forceClosureInitiation()
	{
		click(initiate, "InitiateButtton");
		click(ForceClosureButton, "force closure Button");
		TimeUtil.shortWait();
		switchToPopupModelFrame(driver);

		click(DocumentationActionPlan, "Change Control Tile");
		click(proceedButton, "Proceed");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced search");
		click(DateFilter, "Date Filter");
		TimeUtil.shortWait();
		//click(LastThirtyBtn, "Last Thirty Btn");
		jsClick(LastThirtyBtn, "Last 30 days");
		
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	}
	
	public void forceClosureAuditTrailDN() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		scrollToViewElement(ForceClosureDNMenu);
		click(ForceClosureDNMenu, "Force closure menu");
		click(ForceClosureAuditTrial, "Force closure Audit Trial menu");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		enterUniqueCodeConcat(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
	}
	
	
       

}
