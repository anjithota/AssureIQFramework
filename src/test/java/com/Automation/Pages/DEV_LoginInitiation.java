package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.TimeUtil;

public class DEV_LoginInitiation extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessLogin")
	WebElement processLogin;

	@FindBy(xpath = "//label[@for='item_DEV']")
	WebElement DeviationTile;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(xpath = "(//label[normalize-space()='No'])[1]")
	WebElement reference;

	@FindBy(id = "btnSubmit")
	WebElement submit;

	@FindBy(id = "ISU_LGN_CTR_002_error")
	WebElement ReferenceError;

	@FindBy(id = "ISU_LGN_CTR_114")
	WebElement BlockElement;

	@FindBy(id = "DEV_LGN_CTF_004_error")
	WebElement InitiatingDepartmentError;

	@FindBy(id = "ISU_LGN_CTR_005_button")
	WebElement InitiatingDepartment;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement Admin;

	@FindBy(id = "btnOk")
	WebElement addButton;

	@FindBy(id = "ISU_LGN_CTR_061")
	WebElement DateofOccurance;

	@FindBy(id = "ISU_LGN_CTR_061_error")
	WebElement DateofOccuranceError;

	@FindBy(id = "ISU_LGN_CTR_115")
	WebElement DateofIdentficiation;

	@FindBy(id = "ISU_LGN_CTR_115_error")
	WebElement DateofIdentficiationError;

	@FindBy(id = "ISU_LGN_CTR_136")
	WebElement JustificationforDelay;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addMarket;

	@FindBy(id = "ISU_LGN_CTR_008_button")
	WebElement marketAddItems;

	@FindBy(id = "ISU_LGN_CTR_111_button")
	WebElement customerAddItems;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add'])[1]")
	WebElement addCustomer;

	@FindBy(id = "ISU_LGN_CTR_117_button")
	WebElement eventRelatedTo;

	@FindBy(xpath = "//table[@class='caliber-data-table']//tbody//tr")
	List<WebElement> listOfChangeRelatedTo;

	@FindBy(xpath = "//label[contains(@for, 'ISU_LGN_CTR_010')]")
	List<WebElement> allCheckBoxChangeRelated;

	@FindBy(xpath = "//*[text()=' Product']")
	WebElement productChkBox;

	@FindBy(xpath = "//*[text()=' Material']")
	WebElement materialChkBox;

	@FindBy(xpath = "//*[text()=' Equipment']")
	WebElement equipmentChkBox;

	@FindBy(id = "ISU_LGN_CTR_036_button")
	WebElement batchButton;

	@FindBy(id = "ISU_LGN_CTR_011_button")
	WebElement ProductAddItems;

	@FindBy(xpath = "//button[text()='Ok']")
	WebElement ok;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addProduct;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addBatch;

	@FindBy(id = "ISU_LGN_CTR_120_button")
	WebElement MaterialAddItems;

	@FindBy(id = "ISU_LGN_CTR_121_button")
	WebElement LotAddItems;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addEquipment;

	@FindBy(id = "ISU_LGN_CTR_038_button")
	WebElement EquipmentAddItems;

	// ISU_LGN_CTR_123

	@FindBy(id = "ISU_LGN_CTR_123")
	WebElement SystemText;

	@FindBy(id = "ISU_LGN_CTR_122")
	WebElement OtherDetailsText;

	public void devLoginInitiation(String block, String dateOfOccure, String dateOfIdentify, String justify,

			String system, String otherText) {
		click(initiate, "Intiate button");
		click(processLogin, "Process Login");

		switchToPopupModelFrame(driver);

		click(DeviationTile, "Deviation Tile");
		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		// Wait for 1sec
//		waitForPageToLoad(1000);

		// Switch to frame of the page
		switchToBodyFrame(driver);

		click(submit, "Submit Button");

		verifyCaptionContains(ReferenceError, "Select Value");
		click(reference, "Reference No");

		selectDropdownUsingVisisbleText(BlockElement, block, "block 1");

		click(submit, "Submit Button");
		verifyCaptionContains(InitiatingDepartmentError, "Select Value");

		switchToPopupModelFrame(driver);

		click(Admin, "Administration");

		// Clicking Add Button
		click(addButton, "Add Button");

		// Switch to Parent Frame
		switchToParentFrame(driver);

		click(submit, "Submit Button");
		verifyCaptionContains(DateofOccuranceError, "Select Value");
		sendText(DateofOccurance, dateOfOccure, "Date of occurance");

		click(submit, "Submit Button");
		verifyCaptionContains(DateofIdentficiationError, "Select Value");
		sendText(DateofIdentficiation, dateOfIdentify, "Date of occurance");

		sendText(JustificationforDelay, justify, "Fustificatio for delay");

		// Adding Market
		click(marketAddItems, "Market");
		switchToPopupModelFrame(driver);
		click(addMarket, "AddMarket");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Adding Customer
		click(customerAddItems, "Customer");
		switchToPopupModelFrame(driver);
		click(addCustomer, "AddCustomer");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Clicking on Change Related to Add Items
		click(eventRelatedTo, "ChangeRelatedTo");
		System.out.println("\n" + "------------------------------");

		// Get the size of Change Related To
		getSize(listOfChangeRelatedTo);
		System.out.println("\n" + "Size of Change Related To:- " + getSize(listOfChangeRelatedTo));

		// Selecting all check boxes in Change Related To
		SelectMultipleCheckbox(allCheckBoxChangeRelated, "AllCheckBoxesChangeRelated");

		click(ok, "Button");

		// Adding Product
		click(ProductAddItems, "Product");
		switchToPopupModelFrame(driver);
		TimeUtil.mediumWait();
		click(addProduct, "AddingProduct");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Adding Batch
		click(batchButton, "Batch");
		switchToPopupModelFrame(driver);
		TimeUtil.mediumWait();
		click(addBatch, "AddingProduct");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Adding Equipment
		click(EquipmentAddItems, "Equipment");
		switchToPopupModelFrame(driver);
		TimeUtil.mediumWait();
		click(addEquipment, "AddingEquipment");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		sendText(SystemText, system, "System text");
		sendText(OtherDetailsText, otherText, "other details text");
	}

}
