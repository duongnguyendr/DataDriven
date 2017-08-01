package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class GroupPermissionsDataProvider extends CommonDataProvider {
    private final static String SHEET_NAME = "GroupPermissionTest";
    private final static String VALID_VALUE_COLUMN = "Valid Value";
    public static final String FRENCH_LANGUAGE = "French";

    private static String adminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin", VALID_VALUE_COLUMN);
    private static String adminAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auvenir Password", VALID_VALUE_COLUMN);

    private static String superAdminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin", VALID_VALUE_COLUMN);
    private static String superAdminPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin Auvenir Password", VALID_VALUE_COLUMN);


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

    private static String engagementName1 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Engagement 1 Name", VALID_VALUE_COLUMN);

    private static String engagementName2 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Engagement 2 Name", VALID_VALUE_COLUMN);

    private static String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Company Name", VALID_VALUE_COLUMN);

    private static String leadAuditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor", VALID_VALUE_COLUMN);
    private static String leadAuditorFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Full Name", VALID_VALUE_COLUMN);
    private static String leadAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String leadAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Email Password", VALID_VALUE_COLUMN);

    private static String adminClientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client", VALID_VALUE_COLUMN);
    private static String adminClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String adminClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Email Password", VALID_VALUE_COLUMN);
    private static String adminClientFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Full Name", VALID_VALUE_COLUMN);
    private static String roleClient = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Role Client", VALID_VALUE_COLUMN);

    private static String clientPhoneNumber =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Phone Number", VALID_VALUE_COLUMN);
    private static String parentStackHolder =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Parent Stack Holder", VALID_VALUE_COLUMN);

    private static String auditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor", VALID_VALUE_COLUMN);
    private static String auditorFullName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Full Name", VALID_VALUE_COLUMN);
    private static String auditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String auditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Auvenir Password", VALID_VALUE_COLUMN);

    private static String leadClientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client", VALID_VALUE_COLUMN);
    private static String leadClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Email Password", VALID_VALUE_COLUMN);
    private static String leadClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String leadClientFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Full Name", VALID_VALUE_COLUMN);

    private static String successMessageInvitation =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Success Message Invitation", VALID_VALUE_COLUMN);
    private static String successMessageRemoveTeamMember =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Success Message Remove Team Member", VALID_VALUE_COLUMN);

    private static String clientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client", VALID_VALUE_COLUMN);
    private static String clientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Email Password", VALID_VALUE_COLUMN);
    private static String clientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Full Name", VALID_VALUE_COLUMN);

    private static String leadText = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Text", VALID_VALUE_COLUMN);

    private static String todo1 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 1 name", VALID_VALUE_COLUMN);
    private static String todo2 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 2 name", VALID_VALUE_COLUMN);
    private static String todo3 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 3 name", VALID_VALUE_COLUMN);
    private static String todo4 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 4 name", VALID_VALUE_COLUMN);
    private static String todo5 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 5 name", VALID_VALUE_COLUMN);
    private static String todo6 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 6 name", VALID_VALUE_COLUMN);

    private static String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Category Name", VALID_VALUE_COLUMN);

    private static String leadAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Comment  1", VALID_VALUE_COLUMN);

    private static String pathDownload = GenericService.sDirPath + GenericService
            .getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Path of Download Location", "Valid Value");

    private static String generalAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "General Auditor Comment  4", VALID_VALUE_COLUMN);

    private static String leadClientCmt = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Comment  1", VALID_VALUE_COLUMN);

    private static String generalClientCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "General Client Comment  2", VALID_VALUE_COLUMN);

    //    private static String isAdminAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor", "Can Create An Engagement");
    //    private static String isAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor", "Can Create An Engagement");
    //    private static String isAdminClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client", "Can Create An Engagement");
    //    private static String isLeadClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client", "Can Create An Engagement");
    //    private static String isClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client", "Can Create An Engagement");
    @DataProvider(name = "verifySuperAdminLogin")
    public static Object[][] getVerifySuperAdminLogin() {
        Object[][] arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        if (GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminLogin")
    public static Object[][] getVerifyAdminLogin() {
        Object[][] arrayData = new Object[][]{{adminUser, adminAuvenirPwd}};
        if (GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{adminUser, adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionCreateAnEngagement")
    public static Object[][] getVerifyPermissionCreateAnEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
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

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
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

    @DataProvider(name = "verifyAdminAuditorCreateSimpleEngagement")
    public static Object[][] getVerifyAdminAuditorCreateSimpleEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, engagementName1, companyName, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, engagementName1, companyName, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteNewMemberAuditor")
    public static Object[][] getVerifyAdminAuditorInviteNewMemberAuditor() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName, partnerRole,
                        leadAuditorEmailPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName,
                            partnerRole, leadAuditorEmailPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInvitingNewClient")
    public static Object[][] getVerifyAdminAuditorInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminUser, adminAuvenirPwd, adminClientUser, adminClientEmailPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1,
                        adminClientFullName, roleClient, onboardingStatus, leadClientUser, clientUser}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminUser, adminAuvenirPwd, adminClientUser, adminClientEmailPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1,
                            adminClientFullName, roleClient, onboardingStatus, leadClientUser, clientUser}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive() {
        Object[][] arrayData =
                new Object[][]{{adminClientUser, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess() {
        Object[][] arrayData = new Object[][]{{adminUser, adminAuvenirPwd, adminClientUser, activeStatus, adminClientAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminUser, adminAuvenirPwd, adminClientUser, activeStatus, adminClientAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateNewEngagement")
    public static Object[][] getVerifyLeadAuditorCreateNewEngagement() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, companyName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, companyName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInviteNewAuditorMember")
    public static Object[][] getVerifyLeadAuditorInviteNewAuditorMember() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, auditorUser, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                        partnerRole}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, auditorUser, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                            partnerRole}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInvitingAdminClient")
    public static Object[][] getVerifyLeadAuditorInvitingAdminClient() {
        Object[][] arrayData = new Object[][]{
                {adminUser, leadAuditorUser, adminClientUser, adminClientEmailPwd, leadAuditorAuvenirPwd, engagementName2, adminClientFullName,
                        roleClient, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, leadClientUser, clientUser}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminUser, leadAuditorUser, adminClientUser, adminClientEmailPwd, leadAuditorAuvenirPwd, engagementName2, adminClientFullName,
                            roleClient, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, leadClientUser, clientUser}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionAdminClientCanInviteClient")
    public static Object[][] getVerifyPermissionAdminClientCanInviteClient() {
        Object[][] arrayData = new Object[][]{
                {adminClientUser, adminClientAuvenirPwd, leadClientUser, leadClientEmailPwd, adminUser, adminAuvenirPwd, engagementName2,
                        leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientAuvenirPwd, leadClientUser, leadClientEmailPwd, adminUser, adminAuvenirPwd, engagementName2,
                            leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionClientCanActiveViaEmail")
    public static Object[][] getVerifyPermissionClientCanActiveViaEmail() {
        Object[][] arrayData =
                new Object[][]{{leadClientUser, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData =
                    new Object[][]{{leadClientUser, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionLeadPermissionCanBeTranfered")
    public static Object[][] getVerifyPermissionLeadPermissionCanBeTranfered() {
        Object[][] arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientRemoveAdminClient")
    public static Object[][] getVerifyLeadClientRemoveAdminClient() {
        Object[][] arrayData =
                new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientInviteClient")
    public static Object[][] getVerifyLeadClientInviteClient() {
        Object[][] arrayData = new Object[][]{
                {leadClientUser, leadClientAuvenirPwd, clientUser, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                        roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientUser, leadClientAuvenirPwd, clientUser, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                            roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientActive")
    public static Object[][] getVerifyGeneralClientActive() {
        Object[][] arrayData = new Object[][]{{clientUser, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateTodoAndAssignClient")
    public static Object[][] getVerifyLeadAuditorCreateTodoAndAssignClient() {
        Object[][] arrayData =
                new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, leadClientFullName, categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData =
                    new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, leadClientFullName, categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToGeneralAuditor")
    public static Object[][] verifyLeadAuditorAssignToGeneralAuditor() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, auditorFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCommenting")
    public static Object[][] verifyLeadAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, leadAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, leadAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorMarkCompleted")
    public static Object[][] verifyLeadAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToDoBulkAction")
    public static Object[][] verifyLeadAuditorAssignToDoBulkAction() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDeleteTodo")
    public static Object[][] verifyLeadAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDownloadFromAllTodo")
    public static Object[][] verifyLeadAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCreateTodo")
    public static Object[][] verifyGeneralAuditorCreateTodo() {
        Object[][] arrayData =
                new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, todo5, todo6, leadClientFullName, categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, todo5, todo6, leadClientFullName, categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCommenting")
    public static Object[][] verifyGeneralAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, generalAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, generalAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorMarkCompleted")
    public static Object[][] verifyGeneralAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo5}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo5}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDeleteTodo")
    public static Object[][] verifyGeneralAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo5}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo5}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDownloadFromAllTodo")
    public static Object[][] verifyGeneralAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientPostComment")
    public static Object[][] verifyLeadClientPostComment() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, leadClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, leadClientCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientViewComment")
    public static Object[][] verifyGeneralClientViewComment() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, leadClientCmt, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, leadClientCmt, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientPostComment")
    public static Object[][] verifyGeneralClientPostComment() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientViewComment")
    public static Object[][] verifyLeadClientViewComment() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientSeeToDo")
    public static Object[][] getVerifyLeadClientSeeToDo() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientAssignTodoTaskToClient")
    public static Object[][] getVerifyLeadClientAssignTodoTaskToClient() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, clientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientCanViewTodoTaskAssigned")
    public static Object[][] getVerifyGeneralClientCanViewTodoTaskAssigned() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionSeeAllEngagementsWithinFirm")
    public static Object[][] getVerifyPermissionSeeAllEngagementsWithinFirm() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, engagementName2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, engagementName2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionInviteClientIntoEngagement")
    public static Object[][] getVerifyPermissionInviteClientIntoEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionInviteGeneralClientIntoEngagement")
    public static Object[][] getVerifyPermissionInviteGeneralClientIntoEngagement() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadClientFullName, leadClientUser, roleClient, successMessageInvitation,
                        adminUser, adminPwd, GenericData.UserRole.Client.value}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadClientFullName, leadClientUser, roleClient,
                    successMessageInvitation, adminUser, adminPwd, GenericData.UserRole.Client.value}};
        }
        return arrayData;
    }
}
