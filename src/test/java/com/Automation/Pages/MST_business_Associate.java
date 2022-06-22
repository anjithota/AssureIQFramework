package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_business_Associate extends ActionEngine {
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}

	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;

	// Business Registration

	@FindBy(id = "BSAT_01")
	WebElement BA_Registration;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "MST_BSA_CTF_019_error")
	WebElement UniqueCodeTypeerror;

	@FindBy(xpath = "//label[@for='MST_BSA_CTF_019_2']")
	WebElement Systemgenerated;

	@FindBy(id = "MST_BSA_CTF_002_error")
	WebElement codeError;

	@FindBy(id = "MST_BSA_CTF_002")
	WebElement unicode;

	@FindBy(id = "MST_BSA_CTF_001_error")
	WebElement nameError;

	@FindBy(id = "MST_BSA_CTF_001")
	WebElement name;

	@FindBy(id = "MST_BSA_CTF_018_error")
	WebElement CategoryError;

	@FindBy(xpath = "//label[@for='MST_BSA_CTF_018_02']")
	WebElement supplier;

	@FindBy(id = "MST_BSA_CTF_007_error")
	WebElement errorPerson;

	@FindBy(id = "MST_BSA_CTF_007")
	WebElement ConcatePersonError;

	@FindBy(id = "MST_BSA_CTF_017_error")
	WebElement invalidemailformat;

	@FindBy(id = "MST_BSA_CTF_017")
	WebElement Email;

	@FindBy(id = "txtESignPassword")
	WebElement click_esing;

	@FindBy(id = "Submit_Esign")
	WebElement precced;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement BA_UniqeCode;

	@FindBy(className = "confirmation_text")
	WebElement UniqueCode;

	@FindBy(id = "cfnMsg_Next")
	WebElement donepopu;

	// Modification

	@FindBy(id = "BSAT_02")
	WebElement BA_modification;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "MST_BSA_CTF_002")
	WebElement IssueCode;

	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement Unicode;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement errorEnetr;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyBtn;

//	@FindBy(xpath = "//textarea[@id='txtRemarks']")
//	WebElement Remarks;

	// Status Changes

	@FindBy(id = "BSAT_03")
	WebElement BusinessAssociateStatusChange;

//	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
//	WebElement clickrecord;

	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement ProposedStatusError;

	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement Inactive;

	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement Active;

	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement PermanetInActive;

	@FindBy(id = "confirmationRevertYes")
	WebElement PermanetInActiveYes;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	// Audittrails

	@FindBy(id = "BSAT_04")
	WebElement auditTrails;

	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement record;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;

	public void registration_Ass(String Name, String person) {

		String s = "";

		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = test + s);
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		click(BA_Registration, "Bussiness Association registaration Menu");
		switchToBodyFrame(driver);
		click(SubmitBtn, "Submit button");

		verifyCaptionContains(UniqueCodeTypeerror, "Enter Value");
		click(Systemgenerated, "System generated Button");
		click(SubmitBtn, "click button");

		/*
		 * verifyCaptionContains(codeError, "Enter Value"); click(SubmitBtn,
		 * "click button");
		 */
		verifyCaptionContains(nameError, "Enter Value");
		sendText(name, Name, "name");
		click(SubmitBtn, "click button");

		verifyCaptionContains(CategoryError, "Select Value");
		click(supplier, "suplier");
		click(SubmitBtn, "Submit button");

		verifyCaptionContains(ConcatePersonError, "Enter Value");
		sendText(ConcatePersonError, person, " person");
		// click(SubmitBtn, "click button");

		/*
		 * sendText(Email, abcd, "enetr email"); click(SubmitBtn, "click button");
		 * verifyCaptionContains(invalidemailformat, "Enter email");
		 */

		click(SubmitBtn, "button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BA_UniqeCode);
		switchToDefaultContent(driver);

	}

	public void businessAssociateModification(String test , String remarksReason) {
		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(BA_modification);
		click(BA_modification, "BA_modification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "search");

		//click(IssueCode, "issue code");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, " apply button");
		click(record, "field");
		///enterUniqueCode(driver, UniqueCode);
		clearField(name, "Modification name");
		sendText(name, test, "Associate modification Name");
		//click(record, "field");
		click(SubmitBtn, "button");

		verifyCaptionContains(errorEnetr, "Enter Value");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "click button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BA_UniqeCode);
		switchToDefaultContent(driver);

	}

	public void businessAssociatestatusChangeInActive(String remarksReason) {

		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(BusinessAssociateStatusChange);
		click(BusinessAssociateStatusChange, "status change");
		switchToBodyFrame(driver);

		click(AdvancedSearch, "search");

		//click(IssueCode, "issue code");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, " apply button");

		click(record, "record");
		click(SubmitBtn, "button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "suplier");
		sendText(Remarks, remarksReason, "enetr name");
		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BA_UniqeCode);
		switchToDefaultContent(driver);

	}

	public void businessAssociatestatusChangeActive(String remarksReason) {

		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(BusinessAssociateStatusChange);
		click(BusinessAssociateStatusChange, "BA_status change");
		switchToBodyFrame(driver);

		click(AdvancedSearch, "search");

		//click(IssueCode, "issue code");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, " apply button");

		click(record, "record");
		click(SubmitBtn, "Submit button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active Error");
		sendText(Remarks, remarksReason, "enetr name");

		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BA_UniqeCode);
		switchToDefaultContent(driver);

	}

	public void businessAssociatestatusChangePermanetInActive(String remarksReason) {

		TimeUtil.shortWait();
		click(MasterMenu, "Master Menu");
		scrollToViewElement(BusinessAssociateStatusChange);
		click(BusinessAssociateStatusChange, "status change");
		switchToBodyFrame(driver);

		click(AdvancedSearch, "search");

		//click(IssueCode, "issue code");
		enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, " apply button");

		click(record, "record");
		click(SubmitBtn, "button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "Permanet In Active");
		click(PermanetInActiveYes, "yes");
		sendText(Remarks, remarksReason, "enetr name");

		click(SubmitBtn, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BA_UniqeCode);
		switchToDefaultContent(driver);

	}

	public void AuditTrails() {
		click(MasterMenu, "Master Menu");
		scrollToViewElement(auditTrails);
		click(auditTrails, "audit");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "search");

		//click(IssueCode, "issue code");
		enterUniqueCode(driver, IssueCode);
		click(record, "record");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);

	}

}
