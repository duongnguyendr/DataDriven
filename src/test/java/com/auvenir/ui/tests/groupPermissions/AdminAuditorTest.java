package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminAccountSettingsService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorTest extends AbstractTest {
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AdminAuditorService adminAuditorService;
    private AdminService adminService;
    private AdminAccountSettingsService adminAccountSettingsService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorCreateToDoService auditorCreateToDoService;

    @Test(priority = 1, enabled = true, description = "Verify admin auditor can create an engagement.",
            dataProvider = "verifyPermissionCreateAnEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyPermissionCreateAnEngagement(String userId, String userPassword) {
        getLogger().info("Verify admin auditor can create an engagement.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        userId = GenericService.sBrowserData + userId;

        try {
            marketingService.loginUsingUsernamePassword(userId, userPassword);
            auditorEngagementService.verifyAuditorEngagementPage();

            adminAuditorService.verifyCanCreateAnEngagement();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can create an engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can create an engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 9, enabled = true, description = "To Verify Permission Admin Auditor see all to-dos")
    public void verifyPermissionAdminAuditorSeeToDo() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        String adminAuditorId = GenericService
                .addBrowserPrefix(GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value"));
        String adminAuditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Password", "Valid Value");
        String toDo1Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 1 name", "Valid Value");
        String toDo2Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 2 name", "Valid Value");
        String toDo3Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 3 name", "Valid Value");
        String toDo4Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 4 name", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 2 Name", "Valid Value");

        String toDoListNames[] = {toDo1Name, toDo2Name, toDo3Name, toDo4Name};

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            adminAuditorService.verifyAuditorAdminSeeListToDo(Arrays.asList(toDoListNames));


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 10, enabled = true, description = "To Verify Admin Auditor can not edit Category")
    public void verifyAdminAuditorCanNotEditCategory() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        /*String adminAuditorId = GenericService
                .addBrowserPrefix(GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor", "Valid Value"));
        String adminAuditorPwd =
                GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Admin Auditor Auvenir Password", "Valid Value");
        String toDo1Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 1 name", "Valid Value");
        String toDo2Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 2 name", "Valid Value");
        String toDo3Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 3 name", "Valid Value");
        String toDo4Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 4 name", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Engagement 2 Name", "Valid Value");

        String toDoListNames[] = {toDo1Name, toDo2Name, toDo3Name, toDo4Name};*/

        String adminAuditorId = "chr.vienpham.admin.auditor@gmail.com";
        String adminAuditorPwd = "Changeit@123";
        String engagementName = "Engagement_Vien 02";
        String todoName = "lead vien1";
        String allTodo = "All";
        String allRequest = "All";
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName, false);
            adminAuditorService.verifyAdminAuditorCanNotEditCategory(allTodo, false);
            adminAuditorService.verifyAdminAuditorCanNotChangeDueDate(allTodo, false);
            adminAuditorService.clickCommentIconByTodoName(todoName, false);
            adminAuditorService.verifyAdminAuditorCanNotDeleteRequest(allRequest, false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not edit all categories: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not edit all categories: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Admin Auditor can not mark todo completed.")
//    public void verifyAdminAuditorCanNotMarkTodoCompleted (String adminUser, String adminPassword, String engagementName2,
//            String todo1, String todo2, String todo3, String todo4, String todo5, String todo6) throws Exception {
    public void verifyAdminAuditorCanNotMarkTodoCompleted (){
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
//        listTodo.add(todo1);
//        listTodo.add(todo2);
//        listTodo.add(todo3);
//        listTodo.add(todo4);
//        listTodo.add(todo5);
//        listTodo.add(todo6);
        listTodo.add("lead vien1");
        listTodo.add("lead vien2");
        listTodo.add("lead vien3");
        listTodo.add("lead vien4");
        String adminUser = "chr.vienpham.admin.auditor@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement_Vien 02";
        try{
            marketingService.loginWithUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotMarkCompleteTodo(listTodo);

           Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
           NXGReports.addStep("Verify Admin Auditor can not mark todo completed.", LogAs.PASSED, null);
       }catch (Exception e){
           NXGReports.addStep("Verify Admin Auditor can not mark todo completed: FAILED", LogAs.FAILED,
                   new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
           throw e;
       }
    }

    @Test(priority = 17, enabled = true, description = "Verify Admin Auditor cannot assign auditor.")
    public void verifyAdminAuditorCanNotAssignAuditor () throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
        //        listTodo.add(todo1);
        //        listTodo.add(todo2);
        //        listTodo.add(todo3);
        //        listTodo.add(todo4);
        //        listTodo.add(todo5);
        //        listTodo.add(todo6);
        listTodo.add("lead vien1");
        listTodo.add("lead vien2");
        String adminUser = "chr.vienpham.admin.auditor@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement_Vien 02";
        try{
            marketingService.loginWithUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotAssignAuditor(listTodo);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify Admin Auditor cannot create todo.")
    public void verifyAdminAuditorCanNotCreateTodo () throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        String adminUser = "chr.vienpham.admin.auditor@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement_Vien 02";
        String todoName = "Todo123";
        try{
            marketingService.loginWithUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotCreateTodo(todoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot create todo.", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Verify Admin Auditor cannot create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
