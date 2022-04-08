package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class ChangeControlRegistration extends ActionEngine {
	String ProvUcode;
	public ChangeControlRegistration()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//label[normalize-space()='No'])[1]")
	WebElement reference;

	@FindBy(id = "select2-ISU_LGN_CTR_114-container")
	WebElement selectDropDownBlock;

	//@FindBy(xpath = "//ul[@id='select2-ISU_LGN_CTR_114-results']//li[contains(@id, 'select2-ISU_LGN_CTR_114')]")
	//List<WebElement> listOfBlock;

	@FindBy(xpath = "(//ul[@id='select2-ISU_LGN_CTR_114-results']//li)[2]")
	WebElement block1;

	@FindBy(id = "ISU_LGN_CTR_005_button")
	WebElement initiatingDepartmentAddItems;

	//@FindBy(xpath = "//table[@id='ReportTab']/tbody/tr")
	//List<WebElement> listOfInitDept;

	@FindBy(xpath = "//*[text()='R&D']")
	WebElement RandD;

	@FindBy(xpath = "//*[text()='QC']")
	WebElement QC;

	@FindBy(xpath = "//*[text()='QA']")
	WebElement QA;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement Admin;

	@FindBy(id = "ISU_LGN_CTR_008_button")
	WebElement marketAddItems;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addMarket;

	@FindBy(id = "btnOk")
	WebElement addButton;

	@FindBy(id = "ISU_LGN_CTR_111_button")
	WebElement customerAddItems;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add'])[1]")
	WebElement addCustomer;

	@FindBy(id = "ISU_LGN_CTR_010_button")
	WebElement changeRelatedTo;

	//@FindBy(xpath = "//table[@class='caliber-data-table']//tbody//tr")
	//List<WebElement> listOfChangeRelatedTo;

	@FindBy(xpath = "//label[contains(@for, 'ISU_LGN_CTR_010')]")
	List<WebElement> allCheckBoxChangeRelated;

	@FindBy(xpath = "//*[text()=' Product']")
	WebElement productChkBox;

	@FindBy(xpath = "//*[text()=' Material']")
	WebElement materialChkBox;

	@FindBy(xpath = "//*[text()=' Equipment']")
	WebElement equipmentChkBox;

	@FindBy(xpath = "//*[text()=' Document']")
	WebElement documentChkBox;

	@FindBy(xpath = "//*[text()=' Facility']")
	WebElement systemChkBox;

	@FindBy(xpath = "//*[text()=' Others']")
	WebElement othersChkBox;

	@FindBy(xpath = "//button[text()='Ok']")
	WebElement ok;

	@FindBy(id = "ISU_LGN_CTR_011_button")
	WebElement ProductAddItems;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add'])[2]")
	WebElement addProduct;

	@FindBy(id = "ISU_LGN_CTR_012_button")
	WebElement MaterialAddItems;

	@FindBy(id = "ISU_LGN_CTR_013_button")
	WebElement EquipmentAddItems;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add'])[1]")
	WebElement addEquipment;

	@FindBy(id = "ISU_LGN_CTR_014")
	WebElement document;

	@FindBy(id = "ISU_LGN_CTR_015")
	WebElement facility;

	@FindBy(id = "ISU_LGN_CTR_016")
	WebElement others;

	@FindBy(id = "ISU_LGN_CTR_017")
	WebElement stageAddItems;

	@FindBy(xpath = "//span[@class='text-ellipsis'][normalize-space()='Stage1']")
	WebElement addStage;

	@FindBy(id = "ISU_LGN_CTR_018")
	WebElement currentPractice;

	@FindBy(id = "ISU_LGN_CTR_019")
	WebElement proposedChange;

	@FindBy(id = "ISU_LGN_CTR_020")
	WebElement justificationForPC;

	@FindBy(id = "ISU_LGN_CTR_023")
	WebElement supportingData;

	@FindBy(id = "ISU_LGN_CTR_024")
	WebElement fileAttachement;

	@FindBy(id = "txtRemarks")
	WebElement remarksReasons;

	@FindBy(id = "btnSubmit")
	WebElement submit;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement IssueCode;
	
	@FindBy(id = "btnSubmit")
	WebElement AuditTrailele1;

	//@FindBy(xpath = "(//div[contains(@class, 'confirmation-message-text')])[2]")
	//WebElement cngMsg;

	@FindBy(id = "cfnMsg_Home")
	WebElement done;

	public void changeControlRegistrationDetails(String Document, String Facility, String Others,
			String CurrentPractice, String ProposedChange, String JsutificationForPS, String SupportingData,
			String RemarksReasons,String ele1val) {

		// Switch to default Page
		switchToDefaultContent(driver);

		// Wait for 1sec
		waitForPageToLoad(1000);

		// Switch to frame of the page
		switchToBodyFrame(driver);

		// Clicking Reference as No
		click(reference, "No");

		// clicking Block
		click(selectDropDownBlock, "DropDown");

		// Selecting Block1
		click(block1, "Block1");

		// clicking Initiating Department
		click(initiatingDepartmentAddItems, "InitiatingDept");

		// Switch to frame within a frame
		switchToPopupModelFrame(driver);

		// Selecting Department as Admin
		click(Admin, "Administration");

		// Clicking Add Button
		click(addButton, "Add Button");

		// Switch to Parent Frame
		switchToParentFrame(driver);

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
		click(changeRelatedTo, "ChangeRelatedTo");

		// Selecting all check boxes in Change Related To
		SelectMultipleCheckbox(allCheckBoxChangeRelated, "AllCheckBoxesChangeRelated");

		click(ok, "Button");

		// Adding Product
		click(ProductAddItems, "Product");
		switchToPopupModelFrame(driver);
		click(addProduct, "AddingProduct");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Adding Material
		click(MaterialAddItems, "Material");
		switchToPopupModelFrame(driver);
		click(addProduct, "AddingProduct");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Adding Equipment
		click(EquipmentAddItems, "Equipment");
		switchToPopupModelFrame(driver);
		click(addEquipment, "AddingEquipment");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Entering Document details
		sendText(document, Document, "Document Details");

		// Entering Facility details
		sendText(facility, Facility, "Facility Details");

		// Entering Others details
		sendText(others, Others, "Others Details");

		// Adding Stage
		click(stageAddItems, "Stage");
		switchToPopupModelFrame(driver);
		click(addStage, "AddingStage");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		// Entering Current Practice details
		sendText(currentPractice, CurrentPractice, "Current Practice Details");

		// Entering Proposed Change details
		sendText(proposedChange, ProposedChange, "Proposed Changed Details");

		// Entering Justification for Proposed Change details
		sendText(justificationForPC, JsutificationForPS, "Justification for Proposed Changed Details");

		// Entering Supporting Data details
		sendText(supportingData, SupportingData, "Supporting Data Details");

		// Enter Remark(s)/Reason
		sendText(remarksReasons, RemarksReasons, "Remark(s)Reason(s)");

		// Clicking Submit Button
		click(submit, "Submit");

		// ESign should display
		//e_SignAvailabe();

		// Entering E_Sign Password
		E_sign.e_Sign(ConfigsReader.getPropValue("EPIQCCPWD"));
		TimeUtil.shortWait();
		//click(done, "DoneButton");
		/*ProvUcode=IssueCode.getText();
		System.out.println(ProvUcode);*/
		saveUniqueCode(driver, IssueCode);
		//enterUniqueCode(driver, IssueCode);
		//verifyUniqueCode(element);
		switchToDefaultContent(driver);
		verifyExactCaption(AuditTrailele1, ele1val);
		
		
		

	}

}
