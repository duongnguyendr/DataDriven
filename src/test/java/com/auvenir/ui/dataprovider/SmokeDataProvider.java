package com.auvenir.ui.dataprovider;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by doai.tran on 7/10/2017.
 */
public class SmokeDataProvider extends CommonDataProvider{
    private final static String SHEET_NAME = "SmokeTest-R";
    public static final String FRENCH_LANGUAGE = "French";
    private final static String VALID_VALUE_COLUMN = "Valid Value";

    /*private static String superAdminUser = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Super Admin");
    private static String superAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Super Admin Auvernir Password");

    private static String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
    private static String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
*/
    private static String adminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin", VALID_VALUE_COLUMN);
    private static String adminAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auvenir Password", VALID_VALUE_COLUMN);

    private static String superAdminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin", VALID_VALUE_COLUMN);
    private static String superAdminPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin Auvenir Password", VALID_VALUE_COLUMN);

    /*private static String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
    private static String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
    private static String strRoleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
    private static String strPhone = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
    private static String strReference = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
    private static String strName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Name", "Valid Value");
    private static String strPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
    private static String strWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
    private static String strStreetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
    private static String strOffNum = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
    private static String strZipCode = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
    private static String strCity = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
    private static String strCountry = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Country", "Valid Value");
    private static String strState = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
    private static String strMemberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
    private static String strNumEmp = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
    private static String strPhoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
    private static String strAffName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
    private static String strPathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");
*/
    private static String adminAuditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor", VALID_VALUE_COLUMN);
    private static String adminAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Email Password", VALID_VALUE_COLUMN);
    private static String adminAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String adminAuditorFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Full Name", VALID_VALUE_COLUMN);

    private static String roleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Role in Firm", VALID_VALUE_COLUMN);
    private static String phoneNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Phone Number Auditor", VALID_VALUE_COLUMN);
    private static String referenceToAuvenir =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Reference to Auvenir", VALID_VALUE_COLUMN);
    // firm information
    //    private static String firmName = "Test Audits LLC";
    private static String firmName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Name", VALID_VALUE_COLUMN);
    private static String firmPreName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Previous Name", VALID_VALUE_COLUMN);
    private static String firmWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Website", VALID_VALUE_COLUMN);
    private static String streetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Street Address", VALID_VALUE_COLUMN);
    private static String officeNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Suite / Office Number", VALID_VALUE_COLUMN);
    private static String zipCode = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Postal Code/ Zip Code", VALID_VALUE_COLUMN);
    private static String city = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "City", VALID_VALUE_COLUMN);
    private static String country = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Country", VALID_VALUE_COLUMN);
    private static String stateNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Province / State", VALID_VALUE_COLUMN);
    private static String memberID = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Member I.D", VALID_VALUE_COLUMN);
    private static String numberEmployee = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Number of Employee", VALID_VALUE_COLUMN);
    private static String phoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Phone Number Firm", VALID_VALUE_COLUMN);
    private static String affiliateFirmName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Affiliated Firm's Name", VALID_VALUE_COLUMN);
    private static String pathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Path Logo", VALID_VALUE_COLUMN);


    private static String adminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
    private static String gmailAuditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Email Password");
    private static String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
    private static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
    private static String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
    private static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
    private static String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
    private static String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
//    private static String userOnBoardingStatus = "Onboarding";
    private static String roleClient = "";
//    private static String chooseOptionValue = "Onboarding";
    private static String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
    //private static String phoneNumber = "0123456789";
    private static String parentStackHolder = "Titancorpvn";
    private static String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
//    private static String userActiveStatus = "Active";
    private static String todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
    private static String auditorAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Lead Name");
    private static String engagement = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");
    private static String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "ToDo Name");
    private static String clientAssign = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
    private static String commentContent = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Comment");
    private static boolean isClient = true;
//    private static boolean isClient2 = false;
    private static String pathOfUploadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
    private static String fileName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "File Upload Name");
    private static  String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
    private static String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
    private static String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
    private static String request01Value = "request 01";
    private static  String request02Value = "request 02";
    private static String position01Value = "1";
    private static String position02Value = "2";
    private static String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
    private static String requestValue = "request 02";
    private static String pathOfDownloadLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Download Location");
    private static String auditorInvitedUserEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor");
    private static String fullNameMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
//    private static String roleMember = "Partner";
    private static String auditorInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
    private static String fullNameInvitedMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
    private static String auditorInvitedId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor");
    private static String fullNameInvitedClient = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
    private static String clientInvitedId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
    private static String clientInvitedUserPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
    private static String engagementNameT = "Engagement For Test Delete ToDo";
    private static String toDoNameDeleteSingle = "TestDeleteSingle";
    private static String toDoNameDeleteMultiple01 = "TestNameDeleteMultiple01";
    private static String toDoNameDeleteMultiple02 = "TestNameDeleteMultiple02";
    private static String toDoNameDeleteMultiple03 = "TestNameDeleteMultiple03";
    private static String pathOfAttachLocation = GenericService.sDirPath + GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Path of Upload Location");
    private static  String contactName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
    private static  String emailContact = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client");
    private static String company = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Company");

    private static String leadClientFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Full Name", VALID_VALUE_COLUMN);

    @DataProvider(name = "verifySuperAdminLogin")
    public static Object[][] getVerifySuperAdminLogin() {
        Object[][] arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        if (GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminLogin")
    public static Object[][] getVerifyAdminLogin(){


        Object[][] arrayData = new Object[][]{{adminUser,adminAuvenirPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminUser,adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorUser, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite, streetAddress,
                        officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName, pathLogo}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorUser, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite,
                            streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName,
                            pathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminUser, adminAuditorEmailPwd, adminAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminUser, adminAuditorEmailPwd, adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGMailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyCreateSimpleEngagement")
    public static Object[][] getVerifyCreateSimpleEngagement(){
        Object[][] arrayData = new Object[][] {{auditorId, auditorPassword, engagementName, company}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{auditorId, auditorPassword, engagementName,company}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorInvitingTheClient")
    public static Object[][] getVerifyAuditorInvitingTheClient(){

        Object[][] arrayData = new Object[][] {{clientId, adminId, auditorId, adminAuvenirPwd, auditorPassword, engagementName, clientEmailPassword, clientFullName, onboardingStatus, roleClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][] {{clientId, adminId, auditorId, adminAuvenirPwd, auditorPassword, engagementName, clientEmailPassword, clientFullName, onboardingStatus, roleClient}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyChangeTheStatusClientToOnBoarding")
    public static Object[][] getVerifyChangeTheStatusClientToOnBoarding(){
        Object[][] arrayData = new Object[][]{{adminId, clientId, adminAuvenirPwd, onboardingStatus}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, adminAuvenirPwd, onboardingStatus}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive(){

        Object[][] arrayData = new Object[][]{{adminId, clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess(){


        Object[][] arrayData = new Object[][]{{adminId, clientId, adminAuvenirPwd, clientPassword, activeStatus}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, clientId, adminAuvenirPwd, clientPassword, activeStatus}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyAuditorCreateTodoPage")
    public static Object[][] getVerifyAuditorCreateTodoPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, todoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditAssignee")
    public static Object[][] getVerifyAuditAssignee(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, auditorAssign}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, auditorAssign}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientAssignee")
    public static Object[][] getVerifyClientAssignee(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, clientAssign}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagement, toDoName, clientAssign}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientEngagementOverView")
    public static Object[][] getVerifyClientEngagementOverView(){

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagement, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagement, toDoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorPostComment")
    public static Object[][] getVerifyAuditorPostComment(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientViewAuditorComment")
    public static Object[][] getVerifyClientViewAuditorComment(){


        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient,leadClientFullName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient,leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientPostComment")
    public static Object[][] getVerifyClientPostComment(){


        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName, toDoName, commentContent, isClient}};
        }
        return arrayData;
    }



    @DataProvider(name = "verifyAuditorViewClientComment")
    public static Object[][] getVerifyAuditorViewClientComment(){
        isClient = false;

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent, clientFullName, isClient}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, toDoName, commentContent, clientFullName, isClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAddNewRequestOnToDoPage")
    public static Object[][] getVerifyAddNewRequestOnToDoPage(){


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


        Object[][] arrayData = new Object[][]{{clientId, clientPwd, engagementName, pathOfUploadLocation, fileName, requestValue}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPwd, engagementName, pathOfUploadLocation, fileName, requestValue}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorDownloadOnRequest")
    public static Object[][] getVerifyAuditorDownloadOnRequest(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfUploadLocation,fileName, pathOfDownloadLocation}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfUploadLocation,fileName, pathOfDownloadLocation}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyInviteNewMemberAuditor")
    public static Object[][] getVerifyInviteNewMemberAuditor(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, auditorInvitedUserEmail,fullNameMember, partnerRole, auditorInvitedUserPwd}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, auditorInvitedUserEmail,fullNameMember, partnerRole, auditorInvitedUserPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAssignToDoBulkAction")
    public static Object[][] getVerifyAssignToDoBulkAction(){

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


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementNameT, toDoNameDeleteSingle, toDoNameDeleteMultiple01,
                                                toDoNameDeleteMultiple02, toDoNameDeleteMultiple03}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementNameT, toDoNameDeleteSingle, toDoNameDeleteMultiple01,
                    toDoNameDeleteMultiple02, toDoNameDeleteMultiple03}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyDownloadAttachmentFromAllToDo")
    public static Object[][] getVerifyDownloadAttachmentFromAllToDo(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyCheckListTeam")
    public static Object[][] getVerifyCheckListTeam(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameMember, partnerRole}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, fullNameMember, partnerRole}};
        }
        return arrayData;
    }

    @DataProvider(name ="verifyCheckContactList")
    public static Object[][] getVerifyCheckContactList(){


        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, contactName, emailContact}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, contactName, emailContact}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorAttachFile")
    public static Object[][] getVerifyAuditorAttachFile(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfAttachLocation, fileName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfAttachLocation, fileName, toDoName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientDownloadAttachFile")
    public static Object[][] getVerifyClientDownloadAttachFile(){

        Object[][] arrayData = new Object[][]{{clientId, clientPwd, engagementName, fileName, pathOfDownloadLocation, pathOfUploadLocation}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPwd, engagementName, fileName, pathOfDownloadLocation, pathOfUploadLocation}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorMarkAsComplete")
    public static Object[][] getVerifyAuditorMarkAsComplete(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, toDoName, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPwd, toDoName, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientSeeMarkAsComplete")
    public static Object[][] getVerifyClientSeeMarkAsComplete(){

        Object[][] arrayData = new Object[][]{{clientId, clientPassword, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, engagementName}};
        }
        return arrayData;
    }


}


