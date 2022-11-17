package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class MC_Login_Initiator extends ActionEngine {
	@FindBy(id = "ISU_LGN_CTR_114")
	WebElement BlockDropdown;

	@FindBy(id = "ISU_LGN_CTR_114_error")
	WebElement BlockDropdownError;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "ISU_LGN_CTR_135_error")
	WebElement DatrofRecieptError;

	@FindBy(id = "ISU_LGN_CTR_135")
	WebElement DatrofReciept;

	@FindBy(id = "ISU_LGN_CTR_136")
	WebElement JustificationOfDelay;

	@FindBy(id = "ISU_LGN_CTR_137_error")
	WebElement ComplaintDescriptionError;

	@FindBy(id = "ISU_LGN_CTR_137")
	WebElement ComplaintDescription;

	@FindBy(id = "ISU_LGN_CTR_174_error")
	WebElement SimilarComplaintReceivedIfAnyError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_174_2']")
	WebElement SimilarComplaintReceivedNo;

	@FindBy(id = "ISU_LGN_CTR_175_error")
	WebElement ReopeningOfComplaintIfanyError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_175_2']")
	WebElement ReopeningOfComplaintNo;

	@FindBy(id = "ISU_LGN_CTR_176_error")
	WebElement DosageFormError;

	@FindBy(id = "ISU_LGN_CTR_176_button")
	WebElement DosageFormButton;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_176_1']")
	WebElement DosageFormAerosols;

	@FindBy(id = "ISU_LGN_CTR_008_error")
	WebElement MarketError;

	@FindBy(id = "ISU_LGN_CTR_008_button")
	WebElement MarketButton;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearchButton;

	@FindBy(id = "MST_MKT_CTF_001")
	WebElement MarketUcodeSearchFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement MarketAddButton;

	@FindBy(id = "btnOk")
	WebElement OkButton;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement addMarket;

	@FindBy(id = "btnOk")
	WebElement addButton;

	@FindBy(id = "ISU_LGN_CTR_177_error")
	WebElement ComplaintSourceError;

	@FindBy(id = "ISU_LGN_CTR_177_button")
	WebElement ComplaintSource;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_177_5']")
	WebElement HealthcareProfessional;

	@FindBy(id = "ISU_LGN_CTR_145_error")
	WebElement HealthcareProfessionalError;

	@FindBy(id = "ISU_LGN_CTR_145")
	WebElement HealthcareProfessionaldropdown;

	@FindBy(id = "ISU_LGN_CTR_147_error")
	WebElement AdditionalInformatioRequiredError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_147_1']")
	WebElement AdditionalInformatioRequiredYes;

	@FindBy(id = "ISU_LGN_CTR_148_error")
	WebElement AdditionalInformationError;

	@FindBy(id = "ISU_LGN_CTR_148_button")
	WebElement AdditionalInformation;

	@FindBy(xpath = "//button[@class='caliber-button-primary float-right']")
	WebElement AllcationSubmit;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement TaskAllocationAlert;

	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement TaskAllocationAlertClose;

	@FindBy(id = "btnAddTask_3457")
	WebElement TaskAllocationPopupAddItem;

	@FindBy(xpath = "//select[@class='task-allocation-ugp select2-hidden-accessible']")
	WebElement SelectDepartment;

	@FindBy(id = "ISU_LGN_CTR_179_error")
	WebElement ComplainantDetailsAvailableError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_179_1']")
	WebElement ComplainantDetailsAvailableYes;

	@FindBy(id = "ISU_LGN_CTR_150_error")
	WebElement NameError;

	@FindBy(id = "ISU_LGN_CTR_150")
	WebElement Name;

	@FindBy(id = "ISU_LGN_CTR_151_error")
	WebElement AddressError;

	@FindBy(id = "ISU_LGN_CTR_151")
	WebElement Address;

	@FindBy(id = "ISU_LGN_CTR_152_error")
	WebElement EmailError;

	@FindBy(id = "ISU_LGN_CTR_152")
	WebElement Email;

	@FindBy(id = "ISU_LGN_CTR_152_error")
	WebElement ContactNoError;

	@FindBy(id = "ISU_LGN_CTR_152")
	WebElement ContactNo;

	@FindBy(id = "ISU_LGN_CTR_154_error")
	WebElement BatchAvailableError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_154_2']")
	WebElement BatchAvailableNo;

	@FindBy(id = "ISU_LGN_CTR_180_error")
	WebElement ModeofComplaintReceiptError;

	@FindBy(id = "ISU_LGN_CTR_180_button")
	WebElement ModeofComplaintReceipt;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_180_5']")
	WebElement ModeOfReceiptOther;

	@FindBy(id = "ISU_LGN_CTR_156")
	WebElement CaseNo;

	@FindBy(id = "ISU_LGN_CTR_157")
	WebElement AnyOtherTrackingNo;

	@FindBy(id = "ISU_LGN_CTR_181_error")
	WebElement ComplaintRelatedToError;

	@FindBy(id = "ISU_LGN_CTR_181_button")
	WebElement ComplaintRelatedToButton;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_181_3']")
	WebElement ComplaintRelatedToQuantity;

	@FindBy(id = "ISU_LGN_CTR_164_error")
	WebElement QuantityError;

	@FindBy(id = "ISU_LGN_CTR_164")
	WebElement Quantity;

	@FindBy(id = "ISU_LGN_CTR_166_error")
	WebElement ComplaintSampleRecievedError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_166_1']")
	WebElement ComplaintSampleRecievedYes;

	@FindBy(id = "ISU_LGN_CTR_167_error")
	WebElement PackConditionError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_167_2']")
	WebElement PackConditionNotOk;

	@FindBy(id = "ISU_LGN_CTR_168_error")
	WebElement SampleConditionError;

	@FindBy(xpath = "//label[@for='ISU_LGN_CTR_168_2']")
	WebElement SampleConditionNotOk;

	@FindBy(id = "ISU_LGN_CTR_169_error")
	WebElement SpecifyError;

	@FindBy(id = "ISU_LGN_CTR_169")
	WebElement Specify;

	@FindBy(id = "ISU_LGN_CTR_170_error")
	WebElement ComplaintSampleQualityError;

	@FindBy(id = "ISU_LGN_CTR_170")
	WebElement ComplaintSampleQuality;

	@FindBy(id = "ISU_LGN_CTR_171")
	WebElement OtherObservations;

	// @FindBy

	public void mcLoginInitiation(String block, String dateofReciept, String justification, String complaintDescription,
			String healthcareProfessional, String department, String name, String address, String email, String contact,
			String caseNo, String anyOtherTrackingNo, String quantity, String specify, String complaintSampleQuality) {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit button");
		verifyCaptionContains(BlockDropdownError, "Select Value");
		selectDropdownUsingVisisbleText(BlockDropdown, block, "Block");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(DatrofRecieptError, "Select Value");
		sendText(DatrofReciept, dateofReciept, "Date of reciept");
		sendText(JustificationOfDelay, justification, "Justification of Delay");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplaintDescriptionError, "Enter Value");
		sendText(ComplaintDescription, complaintDescription, "Complaint Description");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(SimilarComplaintReceivedIfAnyError, "Select Value");
		click(SimilarComplaintReceivedNo, "Similar Complaint Received No");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(ReopeningOfComplaintIfanyError, "Select Value");
		click(ReopeningOfComplaintNo, "Reopening Of Complaint No");
		click(SubmitButton, "Submit button");
		verifyCaptionContains(DosageFormError, "Select Value");
		click(DosageFormButton, "Dosage Form Button");
		click(DosageFormAerosols, "Aerosols");
		click(OkButton, "Ok button");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(MarketError, "Select Value");

		click(MarketButton, "Market Button");
		switchToPopupModelFrame(driver);
		click(addMarket, "AddMarket");
		click(addButton, "AddButton");
		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplaintSourceError, "Select Value");
		click(ComplaintSource, "complaint Source");
		click(OkButton, "Ok button");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(HealthcareProfessionalError, "Select Value");
		selectDropdownUsingVisisbleText(HealthcareProfessionaldropdown, healthcareProfessional,
				"Health care Professional dropdown");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(AdditionalInformatioRequiredError, "Select Value");
		click(AdditionalInformatioRequiredYes, "Additional Informatio Required Yes");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(AdditionalInformationError, "Select Value");
		click(AdditionalInformation, "Additional Information");
		switchToPopupModalFrame2(driver);
		click(AllcationSubmit, "Allocation Submit");
		verifyCaptionContains(TaskAllocationAlert, "Select Atleast one task to allocate");
		click(TaskAllocationAlertClose, "Alert Close");
		click(TaskAllocationPopupAddItem, "AddItem Allocation");
		selectDropdownUsingVisisbleText(SelectDepartment, department, "Department"); // Information Technology ( IT )
		click(AllcationSubmit, "Allocation Submit");
		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplainantDetailsAvailableError, "Select Value");
		click(ComplainantDetailsAvailableYes, "Complainant Details Available Yes");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(NameError, "Enter Value");
		sendText(Name, name, "Name");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(AddressError, "Enter Value");
		sendText(Address, address, "Address");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(EmailError, "Enter Value");
		sendText(Email, email, "Email");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ContactNoError, "Enter Value");
		sendText(ContactNo, contact, "Contact No.");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ModeofComplaintReceiptError, "Select Value");
		click(ModeofComplaintReceipt, "Mode of Complaint Receipt");
		click(ModeOfReceiptOther, "Mode of Receipt Other");
		sendText(CaseNo, caseNo, "Case No.");
		sendText(AnyOtherTrackingNo, anyOtherTrackingNo, "Any Other Tracking No.");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplaintRelatedToError, "Select Value");
		click(ComplaintRelatedToButton, "Complaint Related To Button");
		click(ComplaintRelatedToQuantity, "Complaint Related To Quantity");
		click(OkButton, "Ok Button");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(QuantityError, "Enter Value");
		sendText(Quantity, quantity, "Quantity");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplaintSampleRecievedError, "Select Value");
		click(ComplaintSampleRecievedYes, "Complaint Sample Recieved Yes");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(PackConditionError, "Select Value");
		click(PackConditionNotOk, "Pack Condition Not Ok");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(SampleConditionError, "Select Value");
		click(SampleConditionNotOk, "Sample Condition Not Ok");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(SpecifyError, "Enter Value");
		sendText(Specify, specify, "Specify");

		click(SubmitButton, "Submit button");
		verifyCaptionContains(ComplaintSampleQualityError, "Enter Value");
		sendText(ComplaintSampleQuality, complaintSampleQuality, "Complaint Sample Quality");

		click(SubmitButton, "Submit button");
		

	}

}
