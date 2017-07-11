package com.auvenir.ui.dataprovider.client;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 11/07/2017.
 */
public class ClientDataProvider {
    private static String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
    private static String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Auvenir Password");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    private static String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
    private static String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Auvenir Password");
    private static String clientEmailPassword = GenericService
            .getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");
    private static String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Assignee");
    private static String invalidClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Invalid User", "Client");

    private static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");

    private static String imageLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Image Logo", "Valid Value");
    private static String greetingTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Greeting Title", "Valid Value");
    private static String announcementTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Announcement Title", "Valid Value");
    private static String auvenirIntroducingTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Auvenir Introducing Title", "Valid Value");
    private static String introducingBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Introducing Benefit Title", "Valid Value");
    private static String firstBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "First Benefit Title", "Valid Value");
    private static String secondBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Second Benefit Title", "Valid Value");
    private static String thirdBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Third Benefit Title", "Valid Value");
    private static String feedbackTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Feedback Title", "Valid Value");
    private static String goodbyeTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Goodbye Title", "Valid Value");


    @DataProvider(name = "verifyInvitingNewClient")
    public static Object[][] getVerifyInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminId, adminPassword, auditorId, auditorPassword, clientId, clientEmailPassword, clientFullName, invalidClientId, engagementName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminId, adminPassword, auditorId, auditorPassword, clientId, clientEmailPassword, clientFullName, invalidClientId,
                            engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyInvitationEmail")
    public static Object[][] getVerifyInvitationEmail() {
        Object[][] arrayData = new Object[][]{
                {clientId, clientEmailPassword, imageLogo, greetingTitle, announcementTitle, auvenirIntroducingTitle, introducingBenefitTitle,
                        firstBenefitTitle, secondBenefitTitle, thirdBenefitTitle, feedbackTitle, goodbyeTitle}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {clientId, clientEmailPassword, imageLogo, greetingTitle, announcementTitle, auvenirIntroducingTitle, introducingBenefitTitle,
                            firstBenefitTitle, secondBenefitTitle, thirdBenefitTitle, feedbackTitle, goodbyeTitle}};
        }
        return arrayData;
    }
}
