package com.Automation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class DEV_LoginInitiation extends ActionEngine {
	@FindBy(xpath = "//span[@title='Deviation']")
	WebElement DevMyTaskMenu;

	@FindBy(id = "MyTaskPrc_DEV_ISU_LGN_DEV_FRM_ID_01")
	WebElement DevLgnTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvanceSearchButton;
	
	@FindBy(name = "ISU_LGN_CTR_001")
	WebElement IssuecodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
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

	@FindBy(xpath = "//*[text()='Quality Control']")
	WebElement QualityControl;

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

	@FindBy(id = "ISU_LGN_CTR_124")
	WebElement OtherDetailsText;

	@FindBy(id = "ISU_LGN_CTR_017")
	WebElement stageAddItems;

	@FindBy(xpath = "//span[@class='text-ellipsis'][normalize-space()='Stage1']")
	WebElement addStage;
	
	@FindBy(id="ISU_LGN_CTR_102")
	WebElement EventDescription;

	@FindBy(id="ISU_LGN_CTR_189")
	WebElement IntialInvFindings;
	
	@FindBy(id="ISU_LGN_CTR_197")
	WebElement Consequences;
	
	@FindBy(id="ISU_LGN_CTR_191")
	WebElement AssumedCategory;
	
	@FindBy(id="ISU_LGN_CTR_127")
	WebElement ImmediateAction;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement IssueCode;
	
	@FindBy(xpath = "//div[@class='left-module ft-grid menu-icons'][2]")
	WebElement ProcessmanagerMenu;
	
	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_117_5']")
	WebElement OtherDetails;
	
	@FindBy(id = "txtRemarks")
	WebElement remarkReason;
	
	
	
	
	public void devLoginInitiation(String block, String dateOfOccure, String dateOfIdentify, 

			String otherText, String EventDesc, String initialInvestigation, String consequence, String assuemedCategory, String immediateAction) {
		click(initiate, "Intiate button");
		click(processLogin, "Process Login");

		switchToPopupModelFrame(driver);
 
		click(DeviationTile, "Deviation Tile");
		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);
		
		//	``````````````````````````````````````````````````	```````	 
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
		click(InitiatingDepartment, "Iniiating department");

		switchToPopupModelFrame(driver);

		click(QualityControl, "Quality control");

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

		sendText(JustificationforDelay, "justify", "Fustificatio for delay");

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
		//System.out.println("\n" + "------------------------------");

		// Get the size of Change Related To
	/*	getSize(listOfChangeRelatedTo);
		System.out.println("\n" + "Size of Change Related To:- " + getSize(listOfChangeRelatedTo));*/

		// Selecting all check boxes in Change Related To
		//SelectMultipleCheckbox(allCheckBoxChangeRelated, "AllCheckBoxesChangeRelated");
		
		
		click(OtherDetails, "other det");

		click(ok, "Button");

		// Adding Product
/*		click(ProductAddItems, "Product");
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

		sendText(SystemText, system, "System text");*/
		scrollToViewElement(OtherDetailsText);
		sendText(OtherDetailsText, otherText, "other details text");
		
		// Adding Stage
			/*	click(stageAddItems, "Stage");
				switchToPopupModelFrame(driver);
				click(addStage, "AddingStage");
				click(addButton, "AddButton");
				switchToParentFrame(driver);
				*/
		scrollToViewElement(EventDescription);
			sendText(EventDescription, EventDesc, "EventDescription");
				
				sendText(IntialInvFindings, initialInvestigation, "initial Investigation");
				
				
				
				sendText(Consequences, consequence, "Consequences");
				
				selectDropdownUsingVisisbleText(AssumedCategory, assuemedCategory, "Assumed Category");
				
				sendText(ImmediateAction, immediateAction, "ImmediateAction To be Taken");
				
				click(submit, "Submit button");
				
				E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
				
				saveUniqueCode(driver, IssueCode);
				switchToDefaultContent(driver);
		
	}
	
	public void devLoginReInitiation(String eventDesc, String Reason) {
		
		switchToBodyFrame(driver);
		click(DevMyTaskMenu, "Deviation my task menu");
		click(DevLgnTaskMenu, "Deviation Login My task menu");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(AdvanceSearchButton, "Advance Search button");

		// sendText(IssuecodeFilter, "CC-PL01-Admin-21-0013", "Isssue Code Filter");

		enterUniqueCode(driver, IssuecodeFilter);

		click(ApplyButton, "Apply Button");
		click(Record, "Workitem");
		
		clearField(EventDescription, "Event Description");
		sendText(EventDescription, eventDesc, "Event Description");
		
		SendTextUsingJSInnerText(remarkReason, Reason, "Remarks");
		click(submit, "Submit");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		//saveUniqueCode(driver, IssueCode);
		switchToDefaultContent(driver);
		
	}
	
	

}
