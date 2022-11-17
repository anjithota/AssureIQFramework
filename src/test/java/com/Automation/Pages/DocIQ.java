package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

public class DocIQ extends ActionEngine{
	
	@FindBy(xpath = "//li[@class='@*menuicon-@item.Product.UniqueCode*@ menu-icons product-icon active']")
	WebElement DocsiqIcon;
	
	@FindBy(xpath = "//ul[@id='MenuModule_DMS']/li[2]/a")
	WebElement DocumentManagerMenu;
	
	@FindBy(xpath = "//ul[@id='DMS_Document Manager']/li[3]/a")
	WebElement TransactionsMenu;
	
	@FindBy(id = "DMS_Document Manager_Transactions_DMS0924")
	WebElement ExtensionofReviewDateMenu;
	
	@FindBy(id = "btnConfirm")
	WebElement SubmitButton;
	
	@FindBy(id = "btnModal_ExtensionReviewDate_MainDocType")
	WebElement MainDocumentType;
	
	@FindBy(id = "ExtensionReviewDate_MainDocType_FindTxt")
	WebElement MainDocumentTypeSearchFilter;
	
	public void demo() {
		switchToDefaultContent(driver);
		click(DocsiqIcon, "Docs iq icon");
		
		click(DocumentManagerMenu, "Document Manager Menu");
		click(TransactionsMenu, "Transactions Menu");
		click(ExtensionofReviewDateMenu, "Transactions Menu");
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		click(MainDocumentType, "Main Document Type Button");
		//sendText(MainDocumentTypeSearchFilter, text, elementName);(MainDocumentTypeSearchFilter, "Main Document Type Search Filter");
		
	}

}
