package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import htmlreport.com.nxgreport.NXGReports;
import htmlreport.com.nxgreport.logging.LogAs;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.spi.SyncFactoryException;
import java.net.UnknownHostException;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by doai.tran on 4/21/2017.
 * Updated by Doai.Tran on 5/9/2017: Refactor parameter dataBaseServer on maven
 */
public class ConsumerTest extends AbstractAPIService {
    //public static final String restBaseUrl="http://finicity-qa.com";
    //public static final String database ="serviceFinicity";
    static String[] sData = null;

    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl() throws UnknownHostException, SyncFactoryException {
        //RestAssured.basePath=restBaseUrl;
        MongoDBService.connectDBServer(dataBaseServer, port, dataBaseServer, userName, password, ssl);

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
    }

    @BeforeMethod
    public void preCondition() {
        getBaseUrl();
        AbstractAPIService.sStatusCnt = 0;
    }

    /*
    TestCase1: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Customer ID")
    public void getCustomerFromCustomerID() throws Exception {
        try {
            sData = GenericService.toReadExcelData("Consumer1", "consumers");
            Response response = given().get(baseUrl + "/v1/consumer/" + sData[4]);
            if (response.getStatusCode() == 200) {
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            } else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            //  CustomerID
            assertionEquals(jp.get("consumerID").toString(), sData[4]);
            //  institutionID
            assertionEquals(jp.get("institutionID").toString(), sData[3]);
            //  userID
            assertionEquals(jp.get("userID").toString(), sData[5]);
            //  status
            assertionEquals(jp.get("status").toString(), sData[7]);
            //  callbackURL
            assertionEquals(jp.get("callbackURL").toString(), sData[6]);
            //  dateCreated
            assertionEquals(jp.get("dateCreated").toString(), sData[9]);
            //Verify Json Schema
            response.then().body(JsonSchemaValidator.matchesJsonSchema(sData[11]));

            Assert.assertTrue(AbstractAPIService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with CustomerID", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }

    /*
    TestCase2: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Invalid Customer ID")
    public void getCustomerInvalidCustomerID() throws Exception {
        try {
            Response response = given().get(baseUrl + "/v1/consumer/12345");
            if (response.getStatusCode() == 400) {
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            } else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            assertionEquals(jp.get("code").toString(), "api-023");
            assertionEquals(jp.get("msg").toString(), "Error, missing or invalid consumerID.");
            Assert.assertTrue(AbstractAPIService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with CustomerID", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }

    /*
    TestCase3: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Invalid Customer ID")
    public void getCustomerWronginstitutionID() throws Exception {
        try {
            Response response = given().get(baseUrl + "/v1/consumer/");
            if (response.getStatusCode() == 404) {
                getLogger().info("Request successfully with code: " + response.getStatusCode());
                NXGReports.addStep("Request with wrong institutionID format with code: " + response.getStatusCode(), LogAs.PASSED, null);
            } else {
                Assert.fail();
            }
            Assert.assertTrue(AbstractAPIService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Request successfully with WronginstitutionID", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}
