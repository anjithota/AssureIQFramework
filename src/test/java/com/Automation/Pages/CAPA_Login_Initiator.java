package com.Automation.Pages;

import org.apache.tika.config.Field;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class CAPA_Login_Initiator extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessLogin")
	WebElement processLogin;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(xpath = "//label[@for='item_CAPA']")
	WebElement CAPAIcon;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "ISU_LGN_CTR_002_error")
	WebElement ReferenceError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_002_2']")
	WebElement ReferenceNo;

	@FindBy(id = "ISU_LGN_CTR_100_error")
	WebElement ReferenceDocumentNoError;

	@FindBy(id = "ISU_LGN_CTR_100")
	WebElement ReferenceDocumentNo;

	@FindBy(id = "ISU_LGN_CTR_101_error")
	WebElement DateofDocumentInitiationError;

	@FindBy(id = "ISU_LGN_CTR_101")
	WebElement DateofDocumentInitiation;

	@FindBy(id = "DEV_LGN_CTF_004_error")
	WebElement InitiatingDepartmentError;

	@FindBy(id = "ISU_LGN_CTR_005_button")
	WebElement InitiatingDepartmentButton;

	@FindBy(id = "btnOk")
	WebElement popupOkButton;

	@FindBy(className = "toast-message")
	WebElement AlertMessage;

	@FindBy(className = "toast-close-button")
	WebElement AlertCloseButton;

	@FindBy(name = "MST_DEP_CTF_002")
	WebElement DepartmentCodeFilter;

	@FindBy(xpath = "//button[@class='caliber-button-primary caliber-button-sm']")
	WebElement PopupApplyButton;

	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement DepartmentRadioButton;

	@FindBy(id = "btnAdvSearch")
	WebElement PopupSearchButton;

	@FindBy(id = "ISU_LGN_CTR_112_error")
	WebElement OriginOfCAPAError;

	@FindBy(id = "ISU_LGN_CTR_112_button")
	WebElement OriginOfCAPAButton;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_112_7']")
	WebElement OriginOfCAPAOthers;

	@FindBy(xpath = "//button[@class='caliber-button-primary caliber-button-sm']")
	WebElement OriginOfCAPAOkButton;

	@FindBy(id = "ISU_LGN_CTR_016_error")
	WebElement OthersError;

	@FindBy(id = "ISU_LGN_CTR_016")
	WebElement Others;

	@FindBy(id = "ISU_LGN_CTR_111_button")
	WebElement CustomerButton;

	@FindBy(name = "MST_BSA_CTF_002")
	WebElement CustomerCodeFilter;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement CustomerAddButton;

	@FindBy(className = "caliber-button-primary")
	WebElement CustomerPopupAddButton;

	@FindBy(id = "ISU_LGN_CTR_008_button")
	WebElement MarketButton;

	@FindBy(name = "MST_MKT_CTF_001")
	WebElement MarketCodeFilter;

	@FindBy(id = "ISU_LGN_CTR_103_error")
	WebElement InvestigationandRootCauseFindingError;

	@FindBy(id = "ISU_LGN_CTR_103")
	WebElement InvestigationandRootCauseFinding;

	@FindBy(id = "ISU_LGN_CTR_105_error")
	WebElement CorrectiveActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_105_1']")
	WebElement CorrectiveActionPlanRequiredYes;

	@FindBy(id = "ISU_LGN_CTR_106_error")
	WebElement ProposedCorrectiveActionPlanError;

	@FindBy(id = "ISU_LGN_CTR_106_button")
	WebElement ProposedCorrectiveActionPlanButton;

	@FindBy(id = "ISU_LGN_CTR_107_error")
	WebElement PreventiveActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_107_2']")
	WebElement PreventiveActionPlanRequiredNo;

	@FindBy(id = "ISU_LGN_CTR_109_error")
	WebElement OtherActionPlanRequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_109_2']")
	WebElement OtherActionPlanRequiredNo;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;

	public void capaInitiation(String referenceDocumentNo, String dateofDocumentInitiation, String department,
			String others, String customer, String market, String rootCause, String PlanDesc,
			String actionPlanDepartment) {
		switchToDefaultContent(driver);
		// switchToBodyFrame(driver);
		click(initiate, "InitiateButtton");

		click(processLogin, "ProcessLogin");

		// Switch to Frame
		switchToPopupModelFrame(driver);

		click(CAPAIcon, "CAPA Icon");

		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		switchToBodyFrame(driver);
		click(SubmitButton, "Submit button");
		verifyCaptionContains(ReferenceError, "Select Value");
		click(ReferenceNo, "Reference No");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ReferenceDocumentNoError, "Enter Value");
		sendText(ReferenceDocumentNo, referenceDocumentNo, "Reference Document No");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(DateofDocumentInitiationError, "Enter Value");
		sendText(DateofDocumentInitiation, dateofDocumentInitiation, "Date of Document Initiation");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(InitiatingDepartmentError, "Select Value");

		switchToPopupModelFrame(driver);

		click(popupOkButton, "Ok button");

		verifyCaptionContains(AlertMessage, "Select Value");

		click(AlertCloseButton, "Alert close button");

		click(PopupSearchButton, "Department Advanced search button");

		sendText(DepartmentCodeFilter, department, "Department Code");

		click(PopupApplyButton, "Apply button");

		click(DepartmentRadioButton, "Department Radio button");

		click(popupOkButton, "Ok button");

		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(OriginOfCAPAError, "Select Value");
		click(OriginOfCAPAButton, "Origin Of CAPA Button");

		click(OriginOfCAPAOthers, "Others");
		click(OriginOfCAPAOkButton, "Ok Button");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(OthersError, "Enter Value");

		sendText(Others, others, "Others");
		click(CustomerButton, "Customer Button");
		switchToPopupModelFrame(driver);
		click(PopupSearchButton, "Department Advanced search button");

		sendText(CustomerCodeFilter, customer, "Customer Code");
		click(PopupApplyButton, "Apply button");
		click(CustomerAddButton, "Add Button");
		click(CustomerPopupAddButton, "Ok Button");
		switchToParentFrame(driver);

		switchToPopupModelFrame(driver);
		click(PopupSearchButton, "Department Advanced search button");

		sendText(MarketCodeFilter, market, "Customer Code");
		click(PopupApplyButton, "Apply button");
		click(CustomerAddButton, "Add Button");
		click(CustomerPopupAddButton, "Ok Button");
		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(InvestigationandRootCauseFindingError, "Enter Value");
		sendText(InvestigationandRootCauseFinding, rootCause, "Investigation and Root Cause Finding");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(CorrectiveActionPlanRequiredError, "Select Value");
		click(CorrectiveActionPlanRequiredYes, "Corrective Action Plan Required Yes");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ProposedCorrectiveActionPlanError, "Select Value");
		click(ProposedCorrectiveActionPlanButton, "Proposed Corrective Action Plan Button");

		// doc action plan method calling required

		dnLgnInitiation.dnLoginInitiationCC_SP(PlanDesc, actionPlanDepartment);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(PreventiveActionPlanRequiredError, "Select Value");
		click(PreventiveActionPlanRequiredNo, "Preventive Action Plan Required No");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(OtherActionPlanRequiredError, "Select Value");
		click(OtherActionPlanRequiredNo, "Other Action Plan Required No");

		click(SubmitButton, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		switchToDefaultContent(driver);

	}

}
