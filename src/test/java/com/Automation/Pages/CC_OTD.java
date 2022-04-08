package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CC_OTD extends ActionEngine {
	
	@FindBy(xpath = "//a[@href='http://10.10.3.33//QAMS510BL_OQ/BasePages/ListReport?TT=21&Fid=77794']//span")
	WebElement OtherDepartmentComments;
	
	@FindBy(id="btnAdvSearch")
	WebElement AdvanceSearchButton;
	
	@FindBy(name="ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyButton;
	
	@FindBy(className="text-ellipsis")
	WebElement Record;
	
	@FindBy(id="ISU_OTD_CTF_003")
	WebElement CommentsTextbox;
	
	@FindBy(id="btnSubmit_1")
	WebElement SubmitButton;
	
	@FindBy(id="ISU_OTD_CTF_003_error")
	WebElement CommentsError;
	
	@FindBy(id="btnSelectiveReturn")
	WebElement SelectiveReturnButton;
	
	@FindBy(xpath="//input[@class='caliber-labeled-option StageRadioButton']/following :: label[contains(text(),'Stage 2')]")
	WebElement StageTwoCheckbox; //rbl_77759_2363_2363_2
	
	@FindBy(className="toast-message")
	WebElement AlertMessage;
	
	@FindBy(className="toast-close-button")
	WebElement AlertClose;
	
	@FindBy(xpath="//span[@class='confirmation_text']")
	WebElement RetUcode;
	
	@FindBy(xpath="//a[@class='caliber-button-secondary']")
	WebElement Home;
	
	@FindBy(id = "txtRemarks")
	WebElement remarkReason;
	
	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkReasonErr;
	
	
	public void ccOTD(String Comments) {
		switchToBodyFrame(driver);
		
		scrollToViewElement(OtherDepartmentComments);
		click(OtherDepartmentComments, "CC OTD Menu");//CC-PL01-Admin-21-0010
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");
		
			
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitButton, "Submit");
		verifyCaptionContains(CommentsError, "Enter Value");
		
		sendText(CommentsTextbox, Comments, "Comments");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
		
	}
	public void ccOTDSelectiveReturn() {
		switchToBodyFrame(driver);
		
		scrollToViewElement(OtherDepartmentComments);
		click(OtherDepartmentComments, "CC OTD Menu");//CC-PL01-Admin-21-0010
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0033", "Isssue Code Filter");
		
			
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SelectiveReturnButton, "Selective Return");
		
		switchToPopupModelFrame(driver);
		
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(AlertMessage, "Select At least one stage to Return");
		
		click(AlertClose, "Alert close");
		
		click(StageTwoCheckbox, "IHod Stage");
		
		click(SubmitButton, "Submit button");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("CCLgnIHODPwd"));
		
		saveAlterUniqueCode(driver, RetUcode);
		System.out.println("ucode saved");
		
		click(Home, "home");
		
		
		switchToDefaultContent(driver);
	}
	
	public void ccOTDAgain(String Comments, String RemarkReasons) {
		switchToBodyFrame(driver);
		
		scrollToViewElement(OtherDepartmentComments);
		click(OtherDepartmentComments, "CC OTD Menu");//CC-PL01-Admin-21-0010
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");
		
		//sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");
		
			
		enterUniqueCode(driver, IssuecodeFilter);
		
		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		click(SubmitButton, "Submit");
		
		sendText(CommentsTextbox, Comments, "Comments");
		click(SubmitButton, "Submit");
		
		verifyCaptionContains(RemarkReasonErr, "Enter Value");
		sendText(remarkReason, RemarkReasons, "Remarks");
		click(SubmitButton, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		switchToDefaultContent(driver);
		
	}
	
	

}
