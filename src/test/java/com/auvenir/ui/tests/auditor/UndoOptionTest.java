package com.auvenir.ui.tests.auditor;

import com.auvenir.ui.services.*;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.extentionLibraries.MongoDB;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONSerializers;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huy.huynh on 12/05/2017.
 * Scenarios : PLAT 2285 - Add undo option
 */
public class UndoOptionTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorUndoOptionService auditorUndoOptionService;

    String userId;

    @BeforeMethod(dependsOnMethods = {"setUp"})
    public void initVariable() {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        auditorUndoOptionService = new AuditorUndoOptionService(getLogger(), getDriver());

        userId = GenericService.getCongigValue(GenericService.sConfigFile, "AUDITOR_ID");
    }

    @BeforeMethod(dependsOnMethods = {"initVariable"})
    public void navigationPreconditions() throws Exception {
        auditorEngagementService.loginWithUserRole(userId);
        auditorEngagementService.verifyAuditorEngagementPage();
        auditorEngagementService.clickNewEnagementButton();
        auditorNewEngagementService.verifyNewEngagementPage();
        //String timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        //auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

    }

    @Test(priority = 1, enabled = true, testName = "Verify GUI.", description = "undo_1")
    public void verifyAuditorTodoListPage() throws Exception {
        try {
            //TODO move to precondition later
            String timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            auditorNewEngagementService.enterDataForNewEngagementPage("engagement" + timeStamp, "type" + timeStamp, "company" + timeStamp);

            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage("engagement01");

            auditorDetailsEngagementService.navigateToTodoListPage();
            /* end of block should be on precondition, wait bug fix*/

            auditorUndoOptionService.createToDoRecord("toDoName01", "25");
            auditorUndoOptionService.createToDoRecord("toDoName02", "26");
            auditorUndoOptionService.chooseARowWithName("toDoName01");

            auditorUndoOptionService.selectOnBulkActions("Mark as complete");

            MongoDB db = new MongoDB("34.200.249.134", 27017, "TestDB");
            DBObject dBObject = db.getObject("auvenir", "engagements", "name", "engagement1205_152552");
            JSONObject output = new JSONObject(new JSON().serialize(dBObject));
            System.out.println("+++++++++++++++++++++++++++++  " + dBObject);
            System.out.println("+++++++++++++++++++++++++++++= " + output);

            JSONArray jsonArray= output.getJSONArray("todos");
            JSONObject jsonObject= null;
            for(int i=0; i<jsonArray.length();i++){
                JSONObject object= jsonArray.getJSONObject(i);
                if(object.get("name").toString().equals("toDoName01")){
                    if (object.get("completed").toString().equals("true")){

                    }
                    System.out.println("+++++++++++++++++++++++++==== " + object.get("completed").toString());
                }
            }




//            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED,null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
