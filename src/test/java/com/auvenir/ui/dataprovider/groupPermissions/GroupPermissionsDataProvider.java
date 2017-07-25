package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class GroupPermissionsDataProvider extends CommonDataProvider {

    private static String adminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
    private static String adminAuvenirPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

    private static String adminAuditorEmail =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value");
    private static String adminAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Email Password", "Valid Value");
    private static String adminAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
    private static String adminAuditorFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Full Name", "Valid Value");

    private static String roleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
    private static String phoneNumber =
            GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
    private static String referenceToAuvenir =
            GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
    // firm information
    //    private static String firmName = "Test Audits LLC";
    private static String firmName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Firm Name", "Valid Value");
    private static String firmPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
    private static String firmWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
    private static String streetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
    private static String officeNumber =
            GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
    private static String zipCode = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
    private static String city = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
    private static String country = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Country", "Valid Value");
    private static String stateNumber = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
    private static String memberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
    private static String numberEmployee =
            GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
    private static String phoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
    private static String affiliateFirmName =
            GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
    private static String pathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");

    private static String engagementName1 =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 1 Name", "Valid Value");

    private static String engagementName2 =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 2 Name", "Valid Value");

    private static String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Company Name", "Valid Value");


    private static String leadAuditorEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor", "Valid Value");
    private static String leadAuditorFullName = "Lead Auditor";
    private static String leadAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
    private static String leadAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");

    private static String adminClientEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Valid Value");
    private static String adminClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
    private static String adminClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
    private static String adminClientFullName = "Admin Client";
    private static String roleClient = "";

    private static String clientPhoneNumber = "0123456789";
    private static String parentStackHolder = "Titancorpvn";

    private static String auditorEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Valid Value");
    private static String auditorFullName = "Auvenir Auditor";
    private static String auditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");
    private static String auditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");

    private static String leadClientEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Valid Value");
    private static String leadClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Email Password", "Valid Value");
    private static String leadClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
    private static String leadClientFullName = "Lead Client";

    private static String successMessageInvitation = "Your engagement invitation has been sent.";
    private static String successMessageRemoveTeamMember = "Your team member has been removed.";

    private static String clientEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Valid Value");
    private static String clientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Email Password", "Valid Value");
    private static String clientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");
    private static String clientFullName = "Auvenir Client";

    private static String leadText = "Lead";

    private static String todo1 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 1 name", "Valid Value");
    private static String todo2 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 2 name", "Valid Value");
    private static String todo3 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 3 name", "Valid Value");
    private static String todo4 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 4 name", "Valid Value");
    private static String todo5 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 5 name", "Valid Value");
    private static String todo6 = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 6 name", "Valid Value");

    private static String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Category Name", "Valid Value");

    private static String leadAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor Comment  1", "Valid Value");

    private static String pathDownload =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Path of Download Location", "Valid Value");

    private static String generalAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "General Auditor Comment  4", "Valid Value");

    private static String leadClientCmt = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Comment  1", "Valid Value");

    private static String generalClientCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "General Client Comment  2", "Valid Value");

    //    private static String isAdminAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Can Create An Engagement");
    //    private static String isAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Can Create An Engagement");
    //    private static String isAdminClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Can Create An Engagement");
    //    private static String isLeadClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Can Create An Engagement");
    //    private static String isClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Can Create An Engagement");


    @DataProvider(name = "verifyPermissionCreateAnEngagement")
    public static Object[][] getVerifyPermissionCreateAnEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorEmail, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorEmail, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorEmail, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite,
                        streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName,
                        pathLogo}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorEmail, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite,
                            streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName,
                            pathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding() {
        Object[][] arrayData = new Object[][]{{adminAuditorEmail, adminEmail, adminAuditorEmailPwd, adminAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorEmail, adminEmail, adminAuditorEmailPwd, adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorEmail, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorEmail, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorEmail, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorEmail, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCreateSimpleEngagement")
    public static Object[][] getVerifyAdminAuditorCreateSimpleEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorEmail, engagementName1, companyName, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorEmail, engagementName1, companyName, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteNewMemberAuditor")
    public static Object[][] getVerifyAdminAuditorInviteNewMemberAuditor() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorEmail, leadAuditorAuvenirPwd, adminAuditorEmail, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName,
                        partnerRole, leadAuditorEmailPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorEmail, leadAuditorAuvenirPwd, adminAuditorEmail, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName,
                            partnerRole, leadAuditorEmailPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInvitingNewClient")
    public static Object[][] getVerifyAdminAuditorInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminEmail, adminAuvenirPwd, adminClientEmail, adminClientEmailPwd, adminAuditorEmail, adminAuditorAuvenirPwd, engagementName1,
                        adminClientFullName, roleClient, onboardingStatus, leadClientEmail, clientEmail}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminEmail, adminAuvenirPwd, adminClientEmail, adminClientEmailPwd, adminAuditorEmail, adminAuditorAuvenirPwd, engagementName1,
                            adminClientFullName, roleClient, onboardingStatus, leadClientEmail, clientEmail}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive() {
        Object[][] arrayData =
                new Object[][]{{adminClientEmail, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientEmail, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess() {
        Object[][] arrayData = new Object[][]{{adminEmail, adminAuvenirPwd, adminClientEmail, activeStatus, adminClientAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminEmail, adminAuvenirPwd, adminClientEmail, activeStatus, adminClientAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateNewEngagement")
    public static Object[][] getVerifyLeadAuditorCreateNewEngagement() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, companyName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, companyName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInviteNewAuditorMember")
    public static Object[][] getVerifyLeadAuditorInviteNewAuditorMember() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorEmail, leadAuditorAuvenirPwd, auditorEmail, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                        partnerRole}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorEmail, leadAuditorAuvenirPwd, auditorEmail, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                            partnerRole}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInvitingAdminClient")
    public static Object[][] getVerifyLeadAuditorInvitingAdminClient() {
        Object[][] arrayData = new Object[][]{
                {adminEmail, leadAuditorEmail, adminClientEmail, adminClientEmailPwd, leadAuditorAuvenirPwd, engagementName2, adminClientFullName,
                        roleClient, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, leadClientEmail, clientEmail}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminEmail, leadAuditorEmail, adminClientEmail, adminClientEmailPwd, leadAuditorAuvenirPwd, engagementName2, adminClientFullName,
                            roleClient, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, leadClientEmail, clientEmail}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionAdminClientCanInviteClient")
    public static Object[][] getVerifyPermissionAdminClientCanInviteClient() {
        Object[][] arrayData = new Object[][]{
                {adminClientEmail, adminClientAuvenirPwd, leadClientEmail, leadClientEmailPwd, adminEmail, adminAuvenirPwd, engagementName2,
                        leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientEmail, adminClientAuvenirPwd, leadClientEmail, leadClientEmailPwd, adminEmail, adminAuvenirPwd, engagementName2,
                            leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionClientCanActiveViaEmail")
    public static Object[][] getVerifyPermissionClientCanActiveViaEmail() {
        Object[][] arrayData =
                new Object[][]{{leadClientEmail, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientEmail, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyPermissionLeadPermissionCanBeTranfered")
    public static Object[][] getVerifyPermissionLeadPermissionCanBeTranfered() {
        Object[][] arrayData = new Object[][]{{adminClientEmail, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminClientEmail, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientRemoveAdminClient")
    public static Object[][] getVerifyLeadClientRemoveAdminClient() {
        Object[][] arrayData =
                new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientInviteClient")
    public static Object[][] getVerifyLeadClientInviteClient() {
        Object[][] arrayData = new Object[][]{
                {leadClientEmail, leadClientAuvenirPwd, clientEmail, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                        roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientEmail, leadClientAuvenirPwd, clientEmail, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                            roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientActive")
    public static Object[][] getVerifyGeneralClientActive() {
        Object[][] arrayData = new Object[][]{{clientEmail, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientEmail, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateTodoAndAssignClient")
    public static Object[][] getVerifyLeadAuditorCreateTodoAndAssignClient() {
        Object[][] arrayData =
                new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, leadClientFullName, categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData =
                    new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, leadClientFullName, categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToGeneralAuditor")
    public static Object[][] verifyLeadAuditorAssignToGeneralAuditor() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, auditorFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCommenting")
    public static Object[][] verifyLeadAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, leadAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo1, leadAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorMarkCompleted")
    public static Object[][] verifyLeadAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToDoBulkAction")
    public static Object[][] verifyLeadAuditorAssignToDoBulkAction() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDeleteTodo")
    public static Object[][] verifyLeadAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo3}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, todo3}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDownloadFromAllTodo")
    public static Object[][] verifyLeadAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorEmail, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCreateTodo")
    public static Object[][] verifyGeneralAuditorCreateTodo() {
        Object[][] arrayData =
                new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo4, todo5, todo6, leadClientFullName, categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo4, todo5, todo6, leadClientFullName, categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCommenting")
    public static Object[][] verifyGeneralAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo4, generalAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo4, generalAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorMarkCompleted")
    public static Object[][] verifyGeneralAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo5}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo5}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDeleteTodo")
    public static Object[][] verifyGeneralAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo5}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, todo5}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDownloadFromAllTodo")
    public static Object[][] verifyGeneralAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientPostComment")
    public static Object[][] verifyLeadClientPostComment() {
        Object[][] arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, leadClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, leadClientCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientViewComment")
    public static Object[][] verifyGeneralClientViewComment() {
        Object[][] arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1, leadClientCmt, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1, leadClientCmt, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientPostComment")
    public static Object[][] verifyGeneralClientPostComment() {
        Object[][] arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientViewComment")
    public static Object[][] verifyLeadClientViewComment() {
        Object[][] arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
            arrayData = new Object[][]{{auditorEmail, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientSeeToDo")
    public static Object[][] getVerifyLeadClientSeeToDo() {
        Object[][] arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientAssignTodoTaskToClient")
    public static Object[][] getVerifyLeadClientAssignTodoTaskToClient() {
        Object[][] arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientEmail, leadClientAuvenirPwd, engagementName2, todo1, clientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientCanViewTodoTaskAssigned")
    public static Object[][] getVerifyGeneralClientCanViewTodoTaskAssigned() {
        Object[][] arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientEmail, clientAuvenirPwd, engagementName2, todo1}};
        }
        return arrayData;
    }
}
