package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class CC_ForceClosureInitiation extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;
	
	@FindBy(xpath = "//div[text()='Change Control']")
	WebElement changeControl;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;
	 
	@FindBy(id = "btnProcessClosure")
	WebElement ForceClosureButton;
	
	@FindBy(className= "dateVCBtn")
	WebElement DateFilter;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;

	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(xpath="//li[text()='Last 30 Days']")
	WebElement LastThirtyBtn;


	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	
	
	@FindBy(xpath="//a[text()='Force Closure - CC']")
	WebElement ForceClosureCCMenu;
	
	@FindBy(xpath = "//*[@class='caliber-product-qams product-icon1']")
	WebElement assureiq;

	@FindBy(xpath = "//ul[@id='QAMS_PRSMGR']/preceding-sibling::a")
	WebElement ProcessManager;
	
	@FindBy(id="QAMS_PRSMGR_PRC_FCL_CC_FRM_ID_AUDMEN")
	WebElement ForceClosureAuditTrial;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//td[text()='Initiated']")
	WebElement InitiatedActivity;


	public void forceClosureInitiation()
	{
		click(initiate, "InitiateButtton");
		click(ForceClosureButton, "force closure Button");
		TimeUtil.shortWait();
		switchToPopupModelFrame(driver);

		click(changeControl, "Change Control Tile");
		click(proceedButton, "Proceed");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advanced search");
		click(DateFilter, "Date Filter");
		TimeUtil.shortWait();
		//click(LastThirtyBtn, "Last Thirty Btn");
		jsClick(LastThirtyBtn, "Last 30 days");
		
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
	}
	
	public void forceClosureAuditTrail() {
		click(assureiq, "Assure IQ Menu");
		click(ProcessManager, "Process Manager");
		scrollToViewElement(ForceClosureCCMenu);
		click(ForceClosureCCMenu, "Force closure menu");
		click(ForceClosureAuditTrial, "Force closure Audit Trial menu");
		switchToBodyFrame(driver);

		click(AdvanceSearchButton, "Advanced Search button");


		 enterUniqueCode(driver, IssueCodeFilter);

		click(ApplyButton, "Apply button");

		click(Record, "Click on record");
		switchToPopupModelFrame(driver);
		TimeUtil.shortWait();
		scrollToViewElement(InitiatedActivity);
		verifyCaptionContains(InitiatedActivity, "Initiated");
		click(closeBtn, "Close Button");
		switchToDefaultContent(driver);
		
	}
	
	
       
	


}
