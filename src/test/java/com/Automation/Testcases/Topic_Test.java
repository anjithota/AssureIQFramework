/*package com.Automation.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.aventstack.extentreports.ExtentReports;

public class Topic_Test extends ActionEngine {
	WebDriver driver;
	ExtentReports extentReport;
	int numberOfApprovalReq = 1;
	int returnDropAt = 1;

	String ExcelPath = "./TestData/TOPIC.xlsx";

	@DataProvider(name = "TopicRegAprvMODAprvData")
	public Object[][] getTopicRegAprvMODAprvData() {
		Object getTopicRegAprvMODAprvData[][] = Excelutil.getTestData(ExcelPath, "TOPICREGAPRMODAPR");
		return getTopicRegAprvMODAprvData;
	}

	@DataProvider(name = "TopicReinitMODReinitData")
	public Object[][] getTopicReinitMODReinitData() {
		Object getTopicReinitMODReinitData1[][] = Excelutil.getTestData(ExcelPath, "TOPICREGRIAPRMODRIAPR");
		return getTopicReinitMODReinitData1;
	}

	@DataProvider(name = "TopicRegTRNMODTRNData")
	public Object[][] getTopicTRNMODTRNData() {
		Object getTopicTRNMODTRNData1[][] = Excelutil.getTestData(ExcelPath, "TOPICREGTRNRIAPRMODTRNRIAPR");
		return getTopicTRNMODTRNData1;
	}

	@DataProvider(name = "TopicRegSTCMODSTCData")
	public Object[][] getTopicRegSTCMODSTCData() {
		Object getTopicRegSTCMODSTCData[][] = Excelutil.getTestData(ExcelPath, "TOPICREGSTCMODDRPSTC");
		return getTopicRegSTCMODSTCData;
	}

	@Test(priority = 1)
	public void CourseManag() {
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectMasterPlant();
		InitiateTopic.Topicconfig(ConfigsReader.getPropValue("ConfigApprovalReq"), ConfigsReader.getPropValue("ConfigApprovalReq"), ConfigsReader.getPropValue("ConfigApprovalReq"));
	}

	*//**
	 * Method is for topicRegistration Approval & Modification Approval
	 * 
	 * @parameters
	 *//*
	@Test(priority = 1, dataProvider = "TopicRegAprvMODAprvData", enabled = false, groups = { "regression",
			"CourseManagerInitiate_Topic" })
	public void CourseManagerInitiate_Topic(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String InitActionVal, String AppActionVal, String ModDocument,
			String AppRemarks, String ModinitRemarks) {

		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicRegistration(Menuname, TopicName, TopicUniqueCode, Description, Document,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();

		// TOPIC Registration Approve
		// --------------------------
		if (numberOfApprovalReq > 0) {
			for (int i = 1; i <= numberOfApprovalReq; i++) {

				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicApproval(Menuname, TopicName, TopicUniqueCode, Description, Document,
						ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
						ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}

		} else {
			test.info("No of Approvals:0, So not executed");
		}

		// TOPIC Modification Initiation
		// -----------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicModInit(Menuname, TopicName, TopicUniqueCode, Description, Document, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ModinitRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();

		if (numberOfApprovalReq > 0) {
			for (int i = 1; i <= numberOfApprovalReq; i++) {

				// TOPIC Modification Approve
				// -----------------------------
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicModApproval(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
						ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();

			}

		} else {

			test.info("No of Approvals:0, So not executed");
		}

	}

	// 2ND FLOW :TOPIC
	// REGISTRATION_RETURN_REINITIATION_APROVAL_MODIFICATION_RETURN_REINITIATION_APROVAL
	// =================================================================================
	@Test(priority = 2, dataProvider = "TopicReinitMODReinitData", enabled = false, groups = { "regression",
			"CourseManagerInitiate_Topic" })
	public void REG_RET_REIN_APR_MOD_RET_REIN_APR(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String ReinitTopic, String ModDocument, String InitActionVal,
			String RTNActionVal, String ReInitActionVal, String AppActionVal, String RTNRemarks, String AppRemarks,
			String ReinitRemarks, String ModinitRemarks, String ModReinitRemarks) {

		// TOPIC Registration Initiation
		// -----------------------------

		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicRegistration(Menuname, TopicName, TopicUniqueCode, Description, Document,
				ConfigsReader.getPropValue("password"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();

		// TOPIC Registration Return
		// -------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				if (i == returnDropAt) {
					InitiateTopic.topicReturn(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), RTNActionVal,
							ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"),
							ConfigsReader.getPropValue("ApprovalCompVal"));
					Logout.signOutPage();
				} else {
					login.loginToApplication(ConfigsReader.getPropValue("AprvID"),
							ConfigsReader.getPropValue("AprvPWD"));
					login.selectPlant1();
					InitiateTopic.topicApproval(Menuname, TopicName, TopicUniqueCode, Description, Document,
							ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
							ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
							ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
							ConfigsReader.getPropValue("Approvalcompleted"));
					Logout.signOutPage();
				}
			}
		} else {
			test.info("No of Approvals:0, So not executed");
		}

		// TOPIC Registration Re-initiation
		// ------------------------------------
		if (numberOfApprovalReq > 0) {
			login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
			login.selectPlant1();
			InitiateTopic.topicReinitation(Menuname, TopicName, TopicUniqueCode, Description, ModDocument, ReinitTopic,
					ConfigsReader.getPropValue("UserPWD"), RTNActionVal, ConfigsReader.getPropValue("RTNActionByVal"),
					RTNRemarks, ReInitActionVal, ConfigsReader.getPropValue("ReInitActionByVal"), ModReinitRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();
		}

		else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Registration Re-initiation Approve
		// --------------------------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicReinitApproval(Menuname, ReinitTopic, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), ReInitActionVal,
						ConfigsReader.getPropValue("ReInitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, ModReinitRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}

		}
		// TOPIC Modification Initiation
		// -----------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicModInit(Menuname, TopicName, TopicUniqueCode, Description, Document, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ModinitRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();
		// TOPIC Modification Return
		// -----------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {

				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();

				if (i == returnDropAt) {
					InitiateTopic.topicModReturn(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), RTNActionVal,
							ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"),
							ConfigsReader.getPropValue("ApprovalCompVal"));
					Logout.signOutPage();
				}

				else {
					login.loginToApplication(ConfigsReader.getPropValue("AprvID"),
							ConfigsReader.getPropValue("AprvPWD"));
					login.selectPlant1();
					InitiateTopic.topicModApproval(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
							ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
							ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
							ConfigsReader.getPropValue("Approvalcompleted"));
					Logout.signOutPage();
				}
			}
		} else

		{
			test.info("No of Approvals:0, So not executed");
		}

		// TOPIC Modification Re-initiation
		// ----------------------------------

		if (numberOfApprovalReq > 0) {
			login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
			login.selectPlant1();
			InitiateTopic.topicModReinitation(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
					ConfigsReader.getPropValue("UserPWD"), ReinitTopic, RTNActionVal,
					ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks, ReInitActionVal,
					ConfigsReader.getPropValue("ReInitActionByVal"), ModReinitRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();

		} else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Modification Re-initiation Approve
		// -------------------------------------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicModReinitApproval(Menuname, ReinitTopic, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), ReInitActionVal,
						ConfigsReader.getPropValue("ReInitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, ModReinitRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();

			}

		}

	}

	// 3RD FLOW :
	// REGISTRATION_RETURN_TRANSFER_REINITIATION_APROVAL_MODIFICATION_RETURN_TRANSFER_REINITIATION_APROVAL
	// ===================================================================================================
	@Test(priority = 3, dataProvider = "TopicRegTRNMODTRNData", enabled = false, groups = { "regression",
			"CourseManagerInitiate_Topic" })
	public void REG_RET_TRN_REIN_APR_MOD_RET_TRN_REIN_APR(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String ModDocument, String ReinitTopic, String InitActionVal,
			String RTNActionVal, String ReInitActionVal, String AppActionVal, String TrnsfrActionVal, String TRNFrom,
			String TRNTo, String TRNBy, String RTNRemarks, String AppRemarks, String TRNRemarks, String ReinitRemarks,
			String ModinitRemarks, String ModReinitRemarks) {

		// TOPIC Registration Initiation
		// --------------------------------

		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicRegistration(Menuname, TopicName, TopicUniqueCode, Description, Document,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();
		// TOPIC Registration Return
		// ----------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				if (i == returnDropAt) {
					InitiateTopic.topicReturn(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), RTNActionVal,
							ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"),
							ConfigsReader.getPropValue("ApprovalCompVal"));
					Logout.signOutPage();
				} else {
					login.loginToApplication(ConfigsReader.getPropValue("AprvID"),
							ConfigsReader.getPropValue("AprvPWD"));
					login.selectPlant1();
					InitiateTopic.topicApproval(Menuname, TopicName, TopicUniqueCode, Description, Document,
							ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
							ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
							ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
							ConfigsReader.getPropValue("Approvalcompleted"));
					Logout.signOutPage();
				}
			}
		} else {
			test.info("No of Approvals:0, So not executed");
		}

		// TOPIC Registration Transfer
		// ------------------------------
		if (numberOfApprovalReq > 0) {
			login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
			login.selectPlant1();
			InitiateTopic.topicRI_Transfer(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
					ConfigsReader.getPropValue("UserPWD"), RTNActionVal, ConfigsReader.getPropValue("RTNActionByVal"),
					RTNRemarks, ConfigsReader.getPropValue("Tuser"), TRNFrom, TRNTo, TRNBy, TRNRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();

		} else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Registration Re-initiation
		// ------------------------------------
		if (numberOfApprovalReq > 0) {

			login.loginToApplication(ConfigsReader.getPropValue("TRNUserID"), ConfigsReader.getPropValue("TRNUserPWd"));
			login.selectPlant1();
			InitiateTopic.topicTransferReinitation(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
					ConfigsReader.getPropValue("TRNUserPWd"), ReinitTopic, RTNActionVal,
					ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks, TrnsfrActionVal,
					ConfigsReader.getPropValue("TrnsfrActionByVal"), TRNFrom, TRNTo, TRNBy, TRNRemarks, ReinitRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();

		}

		else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Registration Re-initiation Approve
		// ----------------------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicTrnsfrReinitApproval(Menuname, ReinitTopic, TopicUniqueCode, Description,
						ModDocument, ConfigsReader.getPropValue("AprvPWD"), ReInitActionVal,
						ConfigsReader.getPropValue("ReInitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, TRNFrom, TRNTo, TRNBy, TRNRemarks,
						ModReinitRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
						ConfigsReader.getPropValue("ApprovalCompVal"), ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}

		}
		// TOPIC Modification Initiation
		// -----------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicModInit(Menuname, TopicName, TopicUniqueCode, Description, Document, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ModinitRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();
		// TOPIC Modification Return
		// -----------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {

				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();

				if (i == returnDropAt) {
					InitiateTopic.topicModReturn(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), RTNActionVal,
							ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"),
							ConfigsReader.getPropValue("ApprovalCompVal"));
					Logout.signOutPage();
				}

				else {
					login.loginToApplication(ConfigsReader.getPropValue("AprvID"),
							ConfigsReader.getPropValue("AprvPWD"));
					login.selectPlant1();
					InitiateTopic.topicModApproval(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
							ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
							ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
							ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
							ConfigsReader.getPropValue("Approvalcompleted"));
					Logout.signOutPage();
				}
			}
		} else

		{
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Modification Transfer
		// ---------------------------
		if (numberOfApprovalReq > 0) {
			login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
			login.selectPlant1();
			InitiateTopic.topicModRI_Transfer(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
					ConfigsReader.getPropValue("UserPWD"), RTNActionVal, ConfigsReader.getPropValue("RTNActionByVal"),
					RTNRemarks, ConfigsReader.getPropValue("Tuser"), TRNFrom, TRNTo, TRNBy, TRNRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();
		} else {
			test.info("No of Approvals:0, So not executed");
		}

		// TOPIC Modification Re-initiation
		// -------------------------------
		if (numberOfApprovalReq > 0) {
			login.loginToApplication(ConfigsReader.getPropValue("TRNUserID"), ConfigsReader.getPropValue("TRNUserPWd"));
			login.selectPlant1();
			InitiateTopic.TopicModTransferReinitation(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
					ConfigsReader.getPropValue("TRNUserPWd"), ReinitTopic, RTNActionVal,
					ConfigsReader.getPropValue("RTNActionByVal"), RTNRemarks, TrnsfrActionVal,
					ConfigsReader.getPropValue("TrnsfrActionByVal"), TRNFrom, TRNTo, TRNBy, TRNRemarks, ReinitRemarks,
					ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
			Logout.signOutPage();

		} else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Modification Re-initiation Approve
		// ----------------------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicModReinitApproval(Menuname, ReinitTopic, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), ReInitActionVal,
						ConfigsReader.getPropValue("ReInitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, ReinitRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}

		}
	}

	// 4TH FLOW :TOPIC REGISTRATION_DROP_INACTIVE to
	// ACTIVE_MODIFICATION_DROP_ACTIVE_INACTIVE
	// ========================================================================================
	@Test(priority = 4, dataProvider = "TopicRegDRPMODDRPData", enabled = false)
	public void REG_DRP_INACT_MOD_DRP_ACTINACT(String Menuname, String TopicName, String TopicUniqueCode,
			String Description, String Document, String ModDocument, String InitActionVal, String AppActionVal,
			String DPActionVal, String STActive, String STInActive, String DropRemarks, String AppRemarks,
			String STCRemarks, String ModinitRemarks) {

		// TOPIC Registration Initiation
		// ---------------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicRegistration(Menuname, TopicName, TopicUniqueCode, Description, Document,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();
		// TOPIC Registration Drop
		// --------------------------
		if (numberOfApprovalReq > 0) {

			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				if (i == returnDropAt) {
					InitiateTopic.topicDrop(Menuname, TopicName, TopicUniqueCode, Description, ModDocument, DPActionVal,
							ConfigsReader.getPropValue("DPActionByVal"), ConfigsReader.getPropValue("AprvPWD"),
							DropRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
							ConfigsReader.getPropValue("ApprovalCompVal"));
					Logout.signOutPage();
				} else {
					login.loginToApplication(ConfigsReader.getPropValue("AprvID"),
							ConfigsReader.getPropValue("AprvPWD"));
					login.selectPlant1();
					InitiateTopic.topicApproval(Menuname, TopicName, TopicUniqueCode, Description, Document,
							ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
							ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
							ConfigsReader.getPropValue("AppActionByVal"), AppRemarks,
							ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
							ConfigsReader.getPropValue("Approvalcompleted"));
					Logout.signOutPage();
				}
			}
		} else {
			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Status change Inactive to Active
		// -----------------------------------------

		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicStatusChangeInActivetoActive(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				STActive, STInActive, STCRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();
		// TOPIC Status change Approve
		// ---------------------------

		if (numberOfApprovalReq > 0) {
			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicSTCApprove(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
						ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, STActive, STInActive, STCRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}
		} else {
			test.info("No of Approvals:0, So not executed");

		}

		// TOPIC Modification Initiation
		// ---------------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicModInit(Menuname, TopicName, TopicUniqueCode, Description, Document, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), InitActionVal, ConfigsReader.getPropValue("InitActionByVal"),
				ModinitRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();

		if (numberOfApprovalReq > 0) {
			for (int i = 1; i <= numberOfApprovalReq; i++) {

				// TOPIC Modification Drop
				// ------------------------------
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicModDrop(Menuname, TopicName, TopicUniqueCode, Description, ModDocument, DPActionVal,
						ConfigsReader.getPropValue("DPActionByVal"), ConfigsReader.getPropValue("AprvPWD"), DropRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"));
				Logout.signOutPage();
			}

		} else {

			test.info("No of Approvals:0, So not executed");
		}
		// TOPIC Status change Active to Inactive
		// -----------------------------------------
		login.loginToApplication(ConfigsReader.getPropValue("UserID"), ConfigsReader.getPropValue("UserPWD"));
		login.selectPlant1();
		InitiateTopic.topicStatusChangeActivetoInActive(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
				ConfigsReader.getPropValue("UserPWD"), STActive, STInActive, InitActionVal,
				ConfigsReader.getPropValue("InitActionByVal"), STCRemarks, ConfigsReader.getPropValue("ApprovalReqVal"),
				ConfigsReader.getPropValue("ApprovalCompVal"));
		Logout.signOutPage();

		// TOPIC Status change Approve
		// ------------------------------

		if (numberOfApprovalReq > 0) {
			for (int i = 1; i <= numberOfApprovalReq; i++) {
				login.loginToApplication(ConfigsReader.getPropValue("AprvID" + i),
						ConfigsReader.getPropValue("AprvPWD" + i));
				login.selectPlant1();
				InitiateTopic.topicSTCApprove(Menuname, TopicName, TopicUniqueCode, Description, ModDocument,
						ConfigsReader.getPropValue("AprvPWD"), InitActionVal,
						ConfigsReader.getPropValue("InitActionByVal"), AppActionVal,
						ConfigsReader.getPropValue("AppActionByVal"), AppRemarks, STActive, STInActive, STCRemarks,
						ConfigsReader.getPropValue("ApprovalReqVal"), ConfigsReader.getPropValue("ApprovalCompVal"),
						ConfigsReader.getPropValue("Approvalcompleted"));
				Logout.signOutPage();
			}
		} else {
			test.info("No of Approvals:0, So not executed");

		}

	}

}
*/