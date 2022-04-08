package com.Automation.spPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class CC_LoginInitiation extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;
	
	@FindBy(id = "btnProcessLogin")
	WebElement processLogin;
	
	@FindBy(xpath = "//label[@for='item_CC']")
	WebElement changeControl;
	
	@FindBy(id = "btnSubmit")
	WebElement proceedButton;
	
	@FindBy(id = "btnSubmit_1")
	WebElement submit;
	
	@FindBy(id = "ISU_LGN_CTR_002_error")
	WebElement ReferenceError;
	
	@FindBy(xpath="//label[@for='ISU_LGN_CTR_002_2']")
	WebElement ReferenceNo;
	
	@FindBy(id="ISU_LGN_CTR_114")
	WebElement BlockDropdown;
	
	@FindBy(id="DEV_LGN_CTF_004_error")
	WebElement InitiatingDepartmentError;
	
	@FindBy(id="ISU_LGN_CTR_005_button")
	WebElement InitiatingDepartment;
	
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
	
	@FindBy(id = "ISU_LGN_CTR_010_error")
	WebElement changeRelatedToError;

	@FindBy(id = "ISU_LGN_CTR_010_button")
	WebElement changeRelatedTo;

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

	@FindBy(xpath = "//*[text()=' Document']")
	WebElement documentChkBox;

	@FindBy(xpath = "//*[text()=' Facility']")
	WebElement systemChkBox;

	@FindBy(xpath = "//*[text()=' Others']")
	WebElement othersChkBox;

	@FindBy(xpath = "//button[text()='Ok']")
	WebElement ok;
	
	@FindBy(id = "ISU_LGN_CTR_011_error")
	WebElement ProductAddItemsError;
	
	@FindBy(id = "ISU_LGN_CTR_011_button")
	WebElement ProductAddItems;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add'])[2]")
	WebElement addProduct;
	
	@FindBy(id = "ISU_LGN_CTR_012_error")
	WebElement MaterialAddItemsError;
	
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
	
	public void ccInitiation() {
		click(initiate, "Initiate");//S117401606593
		
	}
	
	
	

	
}
