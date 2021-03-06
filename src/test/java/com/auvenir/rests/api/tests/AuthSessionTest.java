package com.auvenir.rests.api.tests;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.spi.SyncFactoryException;
import java.net.UnknownHostException;

/**
 * Created by doai.tran on 4/26/2017.
 */

public class AuthSessionTest extends AbstractTest {
    //public static final String restBaseUrl = "http://finicity-qa-334.com";
    //public static final String database = "serviceFinicity";
    static String[] sData = null;

    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl() throws UnknownHostException, SyncFactoryException {
        //RestAssured.basePath = "http://finicity-qa-334.com";
        //MongoDBService.connectDBServer(dataBaseServer,port, database);
        MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
        MongoDBService.deleteOwner("Owner1");
        MongoDBService.insertOwner("Owner1");
        MongoDBService.deleteConsumer("Consumer1");
        MongoDBService.insertConsumer("Consumer1");
        MongoDBService.deleteInstitution("Institution1");
        MongoDBService.insertInstitution("Institution1");
        MongoDBService.deleteInstitution("ConsumerAccount1");
        MongoDBService.insertConsumerAccount("ConsumerAccount1");
        MongoDBService.deleteAccount("Account1");
        MongoDBService.insertAccount("Account1");
        MongoDBService.deleteAuthSession("AuthSession1");
        MongoDBService.insertAuthSession("AuthSession1");
    }

    @BeforeMethod
    public void preCondition() {
        getBaseUrl();
        AbstractService.sStatusCnt = 0;
    }

    /*
    TestCase1: Get AuthSession with valid sessionID
     */
    @Test(priority = 1, enabled = true, description = "Get AuthSession with valid sessionID")
    public void GetAuthSession() throws Exception {
        try {
            sData = GenericService.toReadExcelData("AuthSession1", "authSessions");
            Response response = (Response) RestAssured.given().get(baseUrl + "/v1/authenticate?sessionID=" + sData[1], new Object[0]);
            if (response.getStatusCode() == 200) {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.FAILED, null);
            }

            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            this.assertionEquals(jp.get("ownerID").toString(), sData[2]);
            this.assertionEquals(jp.get("consumerID").toString(), sData[3]);
            this.assertionEquals(jp.get("dateCreated").toString(), sData[4]);
            response.then().body(JsonSchemaValidator.matchesJsonSchema(sData[27]));
            NXGReports.addStep("Correct Schema of Json", LogAs.PASSED, null);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with AuthSessionTest", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }

    /*
    TestCase 2: Get AuthSession with wrong sessionID
     */
    @Test(priority = 1, enabled = true, description = "Get AuthSession with wrong sessionID")
    public void GetAuthSessionWrongSessionID() throws Exception {
        try {
            sData = GenericService.toReadExcelData("AuthSession1", "authSessions");
            Response response = (Response) RestAssured.given().get(baseUrl + "/v1/authenticate?sessionID=12345", new Object[0]);
            if (response.getStatusCode() == 401) {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.PASSED, (CaptureScreen) null);
            } else {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.FAILED, (CaptureScreen) null);
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            this.assertionEquals(jp.get("code").toString(), "api-001");
            this.assertionEquals(jp.get("msg").toString(), "Error, not authorized.");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with invalid ownerID", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }

    /*
        TestCase: Get AuthSession without sessionID
    */
    @Test(priority = 1, enabled = true, description = "Get AuthSession without sessionID")
    public void GetAuthSessionWithoutSessionID() throws Exception {
        try {
            sData = GenericService.toReadExcelData("AuthSession1", "authSessions");
            Response response = (Response) RestAssured.given().get(baseUrl + "/v1/authenticate?sessionID=", new Object[0]);
            if (response.getStatusCode() == 401) {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.PASSED, (CaptureScreen) null);
            } else {
                NXGReports.addStep("Request successfully with code: " + response.getStatusCode(), LogAs.FAILED, (CaptureScreen) null);
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            this.assertionEquals(jp.get("code").toString(), "api-001");
            this.assertionEquals(jp.get("msg").toString(), "Error, not authorized.");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with invalid ownerID", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}
