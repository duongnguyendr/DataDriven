package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class GroupPermissionsDataProvider extends CommonDataProvider{

    private static String adminID = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin");
    private static String adminAuvenirPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");

//    private static String adminAuditorID = "auvenirauditor01@gmail.com";
    private static String adminAuditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value");
//    private static String adminAuditorGmailPwd = "TESTPASSWORD";
    private static String adminAuditorGmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Email Password", "Valid Value");
    private static String adminAuditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
    private static String adminAuditorFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Full Name", "Valid Value");

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


    private static String leadAuditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor", "Valid Value");
//    private static String leadAuditorID = GenericService.getTestDataFromExcel("GroupPermissionTest", "Lead Auditor", "Valid Value");
    private static String leadAuditorFullName = "Lead Auditor";
    private static String leadAuditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
    private static String leadAuditorGmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Password");
    //        String fullNameInvitedMember = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor Full Name");
    //        String auditorInvitedId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Invited Auditor");

    private static String adminClientID = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin " + "Client", "Valid Value");
    private static String adminClientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
    private static String adminClientEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Email Password");
    private static String adminClientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Assignee");
    private static String roleClient = "";

    private static String clientPhoneNumber = "0123456789";
    private static String parentStackHolder = "Titancorpvn";

    private static String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Valid Value");
    private static String auditorFullName = "Auvenir Auditor";
    private static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");
    private static String auditorGmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");


    private static String adminAuditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
    private static String leadAuditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor", "Valid Value");
    private static String leadAuditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Auditor Auvenir Password", "Valid Value");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Valid Value");
    private static String auditorPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor Auvenir Password", "Valid Value");
    private static String adminClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Valid Value");
    private static String adminClientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client Auvenir Password", "Valid Value");
    private static String leadClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Valid Value");
    private static String leadClientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client Auvenir Password", "Valid Value");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Valid Value");
    private static String clientPassword =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client Auvenir Password", "Valid Value");

    private static String isAdminAuditorCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Can Create An Engagement");
    private static String isAuditorCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Auditor", "Can Create An Engagement");
    private static String isAdminClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Client", "Can Create An Engagement");
    private static String isLeadClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Lead Client", "Can Create An Engagement");
    private static String isClientCanCreateAnEngagement =
            GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Client", "Can Create An Engagement");


    @DataProvider(name = "verifyPermissionCreateAnEngagement")
    public static Object[][] getVerifyPermissionCreateAnEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorID, adminAuditorPassword}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorID, adminAuditorPassword}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorID, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite, streetAddress,
                        officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName, pathLogo}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorID, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite,
                            streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName,
                            pathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding() {
        Object[][] arrayData = new Object[][]{{adminAuditorID, adminID, adminAuditorGmailPwd, adminAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorID, adminID, adminAuditorGmailPwd, adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorID, adminAuditorGmailPwd, adminAuditorPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorID, adminAuditorGmailPwd, adminAuditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorID, adminAuditorPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorID, adminAuditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCreateSimpleEngagement")
    public static Object[][] getVerifyAdminAuditorCreateSimpleEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorID, engagementName1, companyName, adminAuditorPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorID, engagementName1, companyName, adminAuditorPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteNewMemberAuditor")
    public static Object[][] getVerifyAdminAuditorInviteNewMemberAuditor() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorID, leadAuditorPwd, adminAuditorID, adminAuditorPwd, engagementName1, leadAuditorFullName, partnerRole,
                        leadAuditorGmailPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorID, leadAuditorPwd, adminAuditorID, adminAuditorPwd, engagementName1, leadAuditorFullName, partnerRole,
                            leadAuditorGmailPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInvitingNewClient")
    public static Object[][] getVerifyAdminAuditorInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminID, adminAuvenirPwd, adminClientID, adminClientEmailPwd, adminAuditorID, adminAuditorPwd, engagementName1, adminClientFullName,
                        roleClient, onboardingStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminID, adminAuvenirPwd, adminClientID, adminClientEmailPwd, adminAuditorID, adminAuditorPwd, engagementName1, adminClientFullName,
                            roleClient, onboardingStatus}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive() {
        Object[][] arrayData =
                new Object[][]{{adminClientID, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminClientID, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess() {
        Object[][] arrayData =
                new Object[][]{{adminID, adminAuvenirPwd, adminClientID, activeStatus, adminClientPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminID, adminAuvenirPwd, adminClientID, activeStatus, adminClientPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateNewEngagement")
    public static Object[][] getVerifyLeadAuditorCreateNewEngagement() {
        Object[][] arrayData =
                new Object[][]{{leadAuditorID, leadAuditorPwd, engagementName2, companyName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorID, leadAuditorPwd, engagementName2, companyName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInviteNewAuditorMember")
    public static Object[][] getVerifyLeadAuditorInviteNewAuditorMember() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorID, leadAuditorPwd, auditorID, auditorGmailPwd, auditorPwd, engagementName2, auditorFullName, partnerRole}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorID, leadAuditorPwd, auditorID, auditorGmailPwd, auditorPwd, engagementName2, auditorFullName, partnerRole}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInvitingAdminClient")
    public static Object[][] getVerifyLeadAuditorInvitingAdminClient() {
        Object[][] arrayData = new Object[][]{
                {adminID, leadAuditorID, adminClientID, adminClientEmailPwd, leadAuditorPwd, engagementName2, adminClientFullName, roleClient,
                        clientPhoneNumber, parentStackHolder, adminClientPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminID, leadAuditorID, adminClientID, adminClientEmailPwd, leadAuditorPwd, engagementName2, adminClientFullName, roleClient,
                            clientPhoneNumber, parentStackHolder, adminClientPwd}};
        }
        return arrayData;
    }


}
