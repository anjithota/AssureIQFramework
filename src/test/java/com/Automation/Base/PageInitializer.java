package com.Automation.Base;

import com.Automation.Pages.CCDN_EMtaskSchedule;
import com.Automation.Pages.CCDN_ForceClosureApproval;
import com.Automation.Pages.CCDN_ForceClosureInitiation;
import com.Automation.Pages.CCLoginIHOD;
import com.Automation.Pages.CCOTD_AuditTrail;
import com.Automation.Pages.CCQAD_AuditTrail;
import com.Automation.Pages.CC_ClosureApproval;
import com.Automation.Pages.CC_ClosureAuditTrail;
import com.Automation.Pages.CC_ClosureInitiation;
import com.Automation.Pages.CC_ETD_Initiation;
import com.Automation.Pages.CC_ForceClosureApproval;
import com.Automation.Pages.CC_ForceClosureImpacts;
import com.Automation.Pages.CC_ForceClosureInitiation;
import com.Automation.Pages.CC_OTD;
import com.Automation.Pages.CC_QAD;
import com.Automation.Pages.CC_SelectiveReturnAuditTrail;
import com.Automation.Pages.CM_AttendanceReport;
import com.Automation.Pages.CM_Topic;
import com.Automation.Pages.ChangeControlAgainIHODApproval;
import com.Automation.Pages.ChangeControlIHODApproval;
import com.Automation.Pages.ChangeControlIHODApprovalAuditTrail;
import com.Automation.Pages.ChangeControlIHODReturn;
import com.Automation.Pages.ChangeControlIHODRtnAuditTrail;
import com.Automation.Pages.ChangeControlLogin;
import com.Automation.Pages.ChangeControlLoginAgainReinitAuditTrail;
import com.Automation.Pages.ChangeControlLoginAgainReinitiation;
import com.Automation.Pages.ChangeControlLoginAuditTrails;
import com.Automation.Pages.ChangeControlLoginInitiation;
import com.Automation.Pages.ChangeControlLoginInitiationAuditTrail;
import com.Automation.Pages.ChangeControlLoginReinitAuditTrail;
import com.Automation.Pages.ChangeControlLoginReinitiation;
import com.Automation.Pages.ChangeControlMyTaskSearch;
import com.Automation.Pages.ChangeControlQAApproval;
import com.Automation.Pages.ChangeControlQAApprovalAuditTrail;
import com.Automation.Pages.ChangeControlQAReturn;
import com.Automation.Pages.ChangeControlQARtnAuditTrail;
import com.Automation.Pages.ChangeControlRecordSearchAT;
import com.Automation.Pages.ChangeControlRegistration;
import com.Automation.Pages.DEV_ClosureInitiation;
import com.Automation.Pages.DEV_LoginInitiation;
import com.Automation.Pages.Dev_Closure_Approve;
import com.Automation.Pages.Dev_ETD;
import com.Automation.Pages.Dev_FocreClosure;
import com.Automation.Pages.Dev_ForceClosureApproval;
import com.Automation.Pages.Dev_Lgn_Approval;
import com.Automation.Pages.Dev_Lgn_Review;
import com.Automation.Pages.Dev_OTD;
import com.Automation.Pages.Dev_OTDAutitTrail;
import com.Automation.Pages.Dev_QAD;
import com.Automation.Pages.DnLgnInitiationForCC;
import com.Automation.Pages.DocActionVerify;
import com.Automation.Pages.DocClosure;
import com.Automation.Pages.DocClosure_SP;
import com.Automation.Pages.DocExecutionInitiation;
import com.Automation.Pages.DocLgnApprove;
import com.Automation.Pages.DocLgnAuditTrail;
import com.Automation.Pages.DocLgnAuditTrailSP;
import com.Automation.Pages.DocLgnReinitiate;
import com.Automation.Pages.DocLgnReinitiationSP;
import com.Automation.Pages.DocLoginReview;
import com.Automation.Pages.DocLoginReviewSP;
import com.Automation.Pages.DocTaskAllocation;
import com.Automation.Pages.DocTaskAllocationAuditTrail;
import com.Automation.Pages.Doc_Lgn_Approve_SP;
import com.Automation.Pages.EPIQLoginPage;
import com.Automation.Pages.LogOut;
//import com.Automation.Pages.EPICloginpage;
import com.Automation.Pages.LoginPage;
import com.Automation.Pages.MST_Facility;
import com.Automation.Pages.PlantSelection;
import com.Automation.Pages.VerifyCCClosure;
import com.Automation.Utils.ESign;
import com.Automation.spPages.BatchInitiator;
import com.Automation.spPages.SPLogout;
import com.Automation.spPages.SP_LoginPage;

public class PageInitializer extends TestEngine {

	/*
	 * public static LoginPage login; public static Signout Logout;
	 */
	public static EPIQLoginPage epiqLogin;
	public static LogOut logout;
	public static LoginPage Plant1;
	public static ESign E_sign;
	public static CM_Topic InitiateTopic;
	public static MST_Facility InitiateFacility;
	// public static ChangeControlLogin ccLogin;
	public static ChangeControlRegistration ccRegistration;
	public static ChangeControlLoginAuditTrails ccLoginAuditTrails;
	public static TestEngine Testsetup;
	public static CCLoginIHOD ccLoiginHOD;
	public static DnLgnInitiationForCC dnLgnInitiationForCC;
	public static DnLgnInitiationForCC dnLgnInitiation;

	// Change Control Process
	public static ChangeControlLogin ccLogin;
	public static ChangeControlLoginInitiation ccLoginInitiation;
	public static ChangeControlRecordSearchAT ccRecordSearchAT;
	public static ChangeControlLoginInitiationAuditTrail ccLoginInitAuditTrail;
	public static ChangeControlMyTaskSearch ccMyTaskSearch;
	public static ChangeControlIHODReturn ccIHODReturn;
	public static ChangeControlIHODRtnAuditTrail ccIHODRtnAuditTrail;
	public static ChangeControlLoginReinitiation ccLoginReinit;
	public static ChangeControlLoginReinitAuditTrail ccLoginReinitAuditTrail;
	public static ChangeControlIHODApproval ccIHODApproval;
	public static ChangeControlIHODApprovalAuditTrail ccIHODApprovalAuditTrail;
	public static ChangeControlQAReturn ccQAReturn;
	public static ChangeControlQARtnAuditTrail ccQARtnAuditTrail;
	public static ChangeControlLoginAgainReinitiation ccLoginAgainReinit;
	public static ChangeControlLoginAgainReinitAuditTrail ccLoginAgainAuditTrail;
	public static ChangeControlAgainIHODApproval ccAgainIHODApproval;
	public static ChangeControlQAApproval ccQAApproval;
	public static ChangeControlQAApprovalAuditTrail ccQAApprovalAuditTrail;
	public static DocActionVerify docActionVerify;
	public static CC_OTD ccOTD;
	public static CCOTD_AuditTrail ccOTDAuditTrail;
	public static CC_QAD ccQAD;
	public static CCQAD_AuditTrail ccQADAuditTrail;
	public static VerifyCCClosure verifyCCClosure;
	public static DocLoginReview docLgnReview;
	public static DocLgnApprove doclgnApprove;
	public static DocLgnReinitiate docLgnReinit;
	public static DocLgnAuditTrail docLgnAudTrail;
	public static DocTaskAllocation docTaskAllocation;
	public static DocTaskAllocationAuditTrail docTaskAuditTrail;
	public static DocExecutionInitiation docExeInitiation;
	public static DocClosure docClosure;
	public static CC_ClosureInitiation ccClosureInitiation;
	public static CC_ClosureApproval ccClosureApproval;
	public static CC_ClosureAuditTrail ccClosureAuditTrail;
	public static CC_SelectiveReturnAuditTrail ccSelectiveReturnAudit;
	public static CCDN_EMtaskSchedule ccdnEMSchedule;
	public static CC_ETD_Initiation ccEtdInitiate;
	public static CC_ForceClosureInitiation ccForceClosure;
	public static CC_ForceClosureApproval ccForceClosureApproval;
	public static CC_ForceClosureImpacts ccForceClosureImpacts;
	public static CCDN_ForceClosureInitiation ccdnForceClosureInitiation;
	public static CCDN_ForceClosureApproval ccdnForceClosureApproval;

	// SP build
	public static SP_LoginPage spLogin;
	public static SPLogout spLogout;

	// Deviation
	public static DEV_LoginInitiation devLoginInitiation;
	public static Dev_Lgn_Approval devLoginApprove;
	public static Dev_Lgn_Review devLoginReview;
	public static Dev_OTD devOTD;
	public static Dev_OTDAutitTrail devOTDAuditTrail;
	public static Dev_QAD devQAD;
	public static DEV_ClosureInitiation devClosureInitiation;
	public static Dev_Closure_Approve devClosureAppr;
	public static DocLoginReviewSP docLoginReviewsp;
	public static DocLgnAuditTrailSP doclgnAuditTrailsp;
	public static DocLgnReinitiationSP docLgnReinitatesp;
	public static Doc_Lgn_Approve_SP docLgnApprovesp;
	public static DocClosure_SP docClosuresp;
	public static Dev_ETD devETDsp;
	// public static Dev_FocreClosure devForceClosure;
	public static Dev_FocreClosure devForceclosure;
	public static Dev_ForceClosureApproval devForceClosureApproval;

	public static PlantSelection plants;
	public static CM_AttendanceReport attendanceReport;
	
	
	
	
	//demo
	
	public static BatchInitiator batchInit;

	public PageInitializer(String url) {

		super(url);
	}

	public PageInitializer() {

	}

	public static void initializePageObjects() {
		epiqLogin = new EPIQLoginPage();
		logout = new LogOut();
		/*
		 * login = new LoginPage(); Logout = new Signout();
		 */
		Plant1 = new LoginPage();
		E_sign = new ESign();
		InitiateTopic = new CM_Topic();
		InitiateFacility = new MST_Facility();
		// ccLogin = new ChangeControlLogin();
		ccRegistration = new ChangeControlRegistration();
		Testsetup = new TestEngine();
		ccLoginAuditTrails = new ChangeControlLoginAuditTrails();
		ccLoiginHOD = new CCLoginIHOD();
		// Documentation Action Plan
		dnLgnInitiationForCC = new DnLgnInitiationForCC();
		dnLgnInitiation = new DnLgnInitiationForCC();

		// Change Control
		ccLogin = new ChangeControlLogin();
		ccLoginInitiation = new ChangeControlLoginInitiation();
		ccRecordSearchAT = new ChangeControlRecordSearchAT();
		ccLoginInitAuditTrail = new ChangeControlLoginInitiationAuditTrail();
		ccMyTaskSearch = new ChangeControlMyTaskSearch();
		ccIHODReturn = new ChangeControlIHODReturn();
		ccIHODRtnAuditTrail = new ChangeControlIHODRtnAuditTrail();
		ccLoginReinit = new ChangeControlLoginReinitiation();
		ccLoginReinitAuditTrail = new ChangeControlLoginReinitAuditTrail();
		ccIHODApproval = new ChangeControlIHODApproval();
		ccIHODApprovalAuditTrail = new ChangeControlIHODApprovalAuditTrail();
		ccQAReturn = new ChangeControlQAReturn();
		ccQARtnAuditTrail = new ChangeControlQARtnAuditTrail();
		ccLoginAgainReinit = new ChangeControlLoginAgainReinitiation();
		ccLoginAgainAuditTrail = new ChangeControlLoginAgainReinitAuditTrail();
		ccAgainIHODApproval = new ChangeControlAgainIHODApproval();
		ccQAApproval = new ChangeControlQAApproval();
		ccQAApprovalAuditTrail = new ChangeControlQAApprovalAuditTrail();
		docActionVerify = new DocActionVerify();
		ccOTD = new CC_OTD();
		ccOTDAuditTrail = new CCOTD_AuditTrail();
		ccQAD = new CC_QAD();
		ccQADAuditTrail = new CCQAD_AuditTrail();
		verifyCCClosure = new VerifyCCClosure();
		docLgnReview = new DocLoginReview();
		doclgnApprove = new DocLgnApprove();
		docLgnReinit = new DocLgnReinitiate();
		docLgnAudTrail = new DocLgnAuditTrail();
		docTaskAllocation = new DocTaskAllocation();
		docTaskAuditTrail = new DocTaskAllocationAuditTrail();
		docExeInitiation = new DocExecutionInitiation();
		docClosure = new DocClosure();
		ccClosureInitiation = new CC_ClosureInitiation();
		ccClosureApproval = new CC_ClosureApproval();
		ccClosureAuditTrail = new CC_ClosureAuditTrail();
		ccSelectiveReturnAudit = new CC_SelectiveReturnAuditTrail();
		ccdnEMSchedule = new CCDN_EMtaskSchedule();
		ccEtdInitiate = new CC_ETD_Initiation();
		ccForceClosure = new CC_ForceClosureInitiation();
		ccForceClosureApproval = new CC_ForceClosureApproval();
		ccForceClosureImpacts = new CC_ForceClosureImpacts();
		ccdnForceClosureInitiation = new CCDN_ForceClosureInitiation();
		ccdnForceClosureApproval = new CCDN_ForceClosureApproval();
		// sp build
		spLogin = new SP_LoginPage();
		spLogout = new SPLogout();

		// Deviation pages
		devLoginInitiation = new DEV_LoginInitiation();
		devLoginApprove = new Dev_Lgn_Approval();
		devLoginReview = new Dev_Lgn_Review();
		devOTD = new Dev_OTD();
		devOTDAuditTrail = new Dev_OTDAutitTrail();
		devQAD = new Dev_QAD();
		devClosureInitiation = new DEV_ClosureInitiation();
		devClosureAppr = new Dev_Closure_Approve();
		docLoginReviewsp = new DocLoginReviewSP();
		doclgnAuditTrailsp = new DocLgnAuditTrailSP();
		docLgnReinitatesp = new DocLgnReinitiationSP();
		docLgnApprovesp = new Doc_Lgn_Approve_SP();
		docClosuresp = new DocClosure_SP();
		devETDsp = new Dev_ETD();
		devForceclosure = new Dev_FocreClosure();
		devForceClosureApproval = new Dev_ForceClosureApproval();

		// Test

		plants = new PlantSelection();
		attendanceReport = new CM_AttendanceReport();
		
		//demo
		
		batchInit = new BatchInitiator();

	}
}
