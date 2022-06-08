package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class MST_Batch extends ActionEngine {
	@FindBy(xpath = "//div[@class='left-module ft-folder menu-icons active']")
	WebElement MasterMenu;

	@FindBy(id = "BATM_01")
	WebElement BatchRegistrationMenu;

	@FindBy(xpath = "//label[@for='MST_BAT_CTF_004_1]")
	WebElement BatchButton;

	@FindBy(xpath = "//label[@for='MST_BAT_CTF_004_2]")
	WebElement LotButton;

	@FindBy(id = "MST_BAT_CTF_004_error")
	WebElement TypeError;

	@FindBy(id = "MST_BAT_CTF_005")
	WebElement BatchLotID;

	@FindBy(id = "MST_BAT_CTF_005_error")
	WebElement BatchLotIDError;

	@FindBy(id = "MST_BAT_CTF_001")
	WebElement ProductButton;

	@FindBy(id = "MST_BAT_CTF_001_error")
	WebElement ProductError;

	@FindBy(id = "btnOk")
	WebElement ProductOkButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(name = "MST_PRD_CTF_002")
	WebElement ProductUcodeSearchFilter;

	// popup modal frame

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(xpath = "//input[@name='radiobtn']")
	WebElement ProductRadiobutton;

	@FindBy(className = "toast-message")
	WebElement ProductpopupError;

	@FindBy(className = "toast-close-button")
	WebElement ErrorPopupCloseButton;

	@FindBy(id = "MST_BAT_CTF_003_error")
	WebElement BatchLotSizeError;

	@FindBy(id = "MST_BAT_CTF_003")
	WebElement BatchLotSize;

	@FindBy(id = "MST_BAT_CTF_008_error")
	WebElement QualityInspectionError;

	@FindBy(id = "MST_BAT_CTF_008_error")
	WebElement QualityInspection;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "confirmation_text")
	WebElement BatchUniqeCode;

	@FindBy(id = "BATM_02")
	WebElement BatchModificationMenu;

	@FindBy(name = "MST_BAT_CTF_002")
	WebElement BatchProductSearchFilter;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//div[@id='StdRemarks_container']//div[2]//span")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksText;

	public void batchRegistrationInitiation(String batchlotId, String productUcode, String batchlotSize,
			String qualityInspection) {
		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		scrollToViewElement(BatchRegistrationMenu);

		click(BatchRegistrationMenu, "Batch Registration menu");

		switchToBodyFrame(driver);
		click(SubmitButton, "Submit button");
		verifyCaptionContains(TypeError, "Select Value");
		click(BatchButton, "Batch Type button");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(BatchLotIDError, "Enter Value");
		sendText(BatchLotID, batchlotId, "Batch Lot ID Text box");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ProductError, "Select Value");
		click(ProductButton, "Product Add item button");
		switchToPopupModelFrame(driver);
		click(ProductOkButton, "Ok button in Product popup");
		verifyCaptionContains(ProductpopupError, "Select Value");
		click(ErrorPopupCloseButton, "Error Message close button");
		click(AdvancedSearchButton, "Advanced search button");
		sendText(ProductUcodeSearchFilter, productUcode, "Product unique code");
		click(ApplyButton, "Search filter apply button");
		click(ProductRadiobutton, "Product records radio button");
		click(ProductOkButton, "Ok button");
		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(BatchLotSizeError, "Enter Value");
		sendText(BatchLotSize, batchlotSize, "Batch Lot size Text box");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(QualityInspectionError, "Enter Value");
		sendText(QualityInspection, qualityInspection, "Quality Inspection Text box");

		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, BatchUniqeCode);
		switchToDefaultContent(driver);

	}

	public void batchModificationInitiation(String qualityInspection, String remarks) {

		switchToDefaultContent(driver);
		click(MasterMenu, "Master Menu");
		click(BatchModificationMenu, "Modification menu");
		switchToBodyFrame(driver);
		click(AdvancedSearchButton, "Advanced Search Button");
		enterUniqueCode(driver, BatchProductSearchFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		clearField(QualityInspection, "QualityInspection");
		sendText(QualityInspection, qualityInspection, "Quality inspection");
		click(SubmitButton, "Submit");
		verifyCaptionContains(RemarksError, "Enter Value");
		sendText(RemarksText, remarks, "Remarks or reasons");
		click(SubmitButton, "Submit");

	}

}
