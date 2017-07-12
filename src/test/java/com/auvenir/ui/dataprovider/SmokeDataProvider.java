package com.auvenir.ui.dataprovider;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by doai.tran on 7/10/2017.
 */
public class SmokeDataProvider {
    public static final String FRENCH_LANGUAGE = "French";

    @DataProvider(name = "verifyAdminLogin")
    public static Object[][] getVerifyAdminLogin(){
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

        Object[][] arrayData = new Object[][]{{adminId,adminPassword}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId,adminPassword}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
        String strRoleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
        String strPhone = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
        String strReference = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
        // firm information
        String strName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Name", "Valid Value");
        String strPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
        String strWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
        String strStreetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
        String strOffNum = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
        String strZipCode = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
        String strCity = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
        String strCountry = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Country", "Valid Value");
        String strState = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
        String strMemberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
        String strNumEmp = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
        String strPhoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
        String strAffName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
        String strPathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");

        Object[][] arrayData = new Object[][]{{emailCreate,strFullName, strRoleFirm, strPhone, strReference,
                                               strName, strPreName, strWebsite, strStreetAddress, strOffNum,
                                               strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp,
                                               strPhoneFirm, strAffName, strPathLogo}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailCreate,strFullName, strRoleFirm, strPhone, strReference,
                                        strName, strPreName, strWebsite, strStreetAddress, strOffNum,
                                        strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp,
                                        strPhoneFirm, strAffName, strPathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String adminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

        Object[][] arrayData = new Object[][] {{emailCreate,adminEmail,gmailAuditorPassword,strAdminPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{emailCreate,adminEmail,gmailAuditorPassword,strAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser(){
        String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

        Object[][] arrayData = new Object[][] {{gmailAuditorPassword,emailCreate, auditorPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{gmailAuditorPassword,emailCreate, auditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser(){
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");

        Object[][] arrayData = new Object[][] {{emailCreate, auditorPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{emailCreate, auditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyCreateSimpleEngagement")
    public static Object[][] getVerifyCreateSimpleEngagement(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        Object[][] arrayData = new Object[][] {{auditorId, auditorPassword, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{auditorId, auditorPassword, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorInvitingTheClient")
    public static Object[][] getVerifyAuditorInvitingTheClient(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
        String userOnBoardingStatus = "Onboarding";
        String roleClient = "";

        Object[][] arrayData = new Object[][] {{clientId, adminId, auditorId, adminPassword, auditorPassword, engagementName, clientEmailPassword, clientFullName, userOnBoardingStatus, roleClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{clientId, adminId, auditorId, adminPassword, auditorPassword, engagementName, clientEmailPassword, clientFullName, userOnBoardingStatus, roleClient}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyChangeTheStatusClientToOnBoarding")
    public static Object[][] getVerifyChangeTheStatusClientToOnBoarding(){
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String chooseOptionValue = "Onboarding";
        Object[][] arrayData = new Object[][]{{adminId, clientId, adminPassword, chooseOptionValue}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, adminPassword, chooseOptionValue}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive(){
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String phoneNumber = "0123456789";
        String parentStackHolder = "Titancorpvn";

        Object[][] arrayData = new Object[][]{{adminId, clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess(){
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String userActiveStatus = "Active";

        Object[][] arrayData = new Object[][]{{adminId, clientId, adminPassword, clientPassword, userActiveStatus}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, adminPassword, clientPassword, userActiveStatus}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyAuditorCreateTodoPage")
    public static Object[][] getVerifyAuditorCreateTodoPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, todoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditAssignee")
    public static Object[][] getVerifyAuditAssignee(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String auditorAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, auditorAssign}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, auditorAssign}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientAssignee")
    public static Object[][] getVerifyClientAssignee(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String clientAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, clientAssign}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, clientAssign}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientEngagementOverView")
    public static Object[][] getVerifyClientEngagementOverView(){
        String clientId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagement, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagement, toDoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorPostComment")
    public static Object[][] getVerifyAuditorPostComment(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientViewAuditorComment")
    public static Object[][] getVerifyClientViewAuditorComment(){
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        boolean isClient = true;

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientPostComment")
    public static Object[][] getVerifyClientPostComment(){
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        boolean isClient = true;

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        }
        return arrayData;
    }



    @DataProvider(name = "verifyAuditorViewClientComment")
    public static Object[][] getVerifyAuditorViewClientComment(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Comment");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
        boolean isClient = false;

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent, clientFullName, isClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent, clientFullName, isClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAddNewRequestOnToDoPage")
    public static Object[][] getVerifyAddNewRequestOnToDoPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Upload Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String request01Value = "request 01";
        String request02Value = "request 02";
        String position01Value = "1";
        String position02Value = "2";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, pathOfUploadLocation, fileName, toDoName,
                                                deadlineDate, endDate, startDate, request01Value, request02Value, position01Value, position02Value}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, pathOfUploadLocation, fileName, toDoName,
                    deadlineDate, endDate, startDate, request01Value, request02Value, position01Value, position02Value}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientUploadOnRequest")
    public static Object[][] getVerifyClientUploadOnRequeste(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User2", "File Upload Name");
        String requestValue = "request 02";

        Object[][] arrayData = new Object[][]{{clientId, clientPwd, engagementName, pathOfUploadLocation, fileName, requestValue}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPwd, engagementName, pathOfUploadLocation, fileName, requestValue}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorDownloadOnRequest")
    public static Object[][] getVerifyAuditorDownloadOnRequest(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User2", "File Upload Name");
        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfUploadLocation,fileName, pathOfDownloadLocation}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfUploadLocation,fileName, pathOfDownloadLocation}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyInviteNewMemberAuditor")
    public static Object[][] getVerifyInviteNewMemberAuditor(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String auditorInvitedUserEmail = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Invited Auditor");
        String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String roleMember = "Partner";
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, auditorInvitedUserEmail,fullNameMember, roleMember, auditorInvitedUserPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, auditorInvitedUserEmail,fullNameMember, roleMember, auditorInvitedUserPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAssignToDoBulkAction")
    public static Object[][] getVerifyAssignToDoBulkAction(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fullNameInvitedMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String auditorInvitedId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor");
        String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
        String fullNameInvitedClient = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
        String clientInvitedId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameInvitedMember, auditorInvitedId,
                                               auditorInvitedUserPwd, fullNameInvitedClient, clientInvitedId, clientInvitedUserPwd, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameInvitedMember, auditorInvitedId,
                    auditorInvitedUserPwd, fullNameInvitedClient, clientInvitedId, clientInvitedUserPwd, toDoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyDeleteSingleAndMultipleToDo")
    public static Object[][] getVerifyDeleteSingleAndMultipleToDo(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = "Engagement For Test Delete ToDo";
        String toDoNameDeleteSingle = "TestDeleteSingle";
        String toDoNameDeleteMultiple01 = "TestNameDeleteMultiple01";
        String toDoNameDeleteMultiple02 = "TestNameDeleteMultiple02";
        String toDoNameDeleteMultiple03 = "TestNameDeleteMultiple03";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoNameDeleteSingle, toDoNameDeleteMultiple01,
                                                toDoNameDeleteMultiple02, toDoNameDeleteMultiple03}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoNameDeleteSingle, toDoNameDeleteMultiple01,
                    toDoNameDeleteMultiple02, toDoNameDeleteMultiple03}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyDownloadAttachmentFromAllToDo")
    public static Object[][] getVerifyDownloadAttachmentFromAllToDo(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyCheckListTeam")
    public static Object[][] getVerifyCheckListTeam(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
        String roleMember = "Partner";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameMember, roleMember}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameMember, roleMember}};
        }
        return arrayData;
    }

    @DataProvider(name ="verifyCheckContactList")
    public static Object[][] getVerifyCheckContactList(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String contactName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
        String emailContact = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Client");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, contactName, emailContact}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, contactName, emailContact}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorAttachFile")
    public static Object[][] getVerifyAuditorAttachFile(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String pathOfAttachLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Attach Name");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfAttachLocation, fileName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfAttachLocation, fileName, toDoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientDownloadAttachFile")
    public static Object[][] getVerifyClientDownloadAttachFile(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
        String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Attach Name");
        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");

        Object[][] arrayData = new Object[][]{{clientId, clientPwd, engagementName, fileName, pathOfDownloadLocation, pathOfUploadLocation}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPwd, engagementName, fileName, pathOfDownloadLocation, pathOfUploadLocation}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorMarkAsComplete")
    public static Object[][] getVerifyAuditorMarkAsComplete(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, toDoName, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, toDoName, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientSeeMarkAsComplete")
    public static Object[][] getVerifyClientSeeMarkAsComplete(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName}};
        }
        return arrayData;
    }

}


