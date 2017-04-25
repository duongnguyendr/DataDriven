package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.MongoDBService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

/**
 * Created by doai.tran on 4/25/2017.
 */
public class InstitutionTest extends AbstractAPIService {
    public static final String restBaseUrl="http://finicity-qa-331.com";
    public static final String database ="serviceFinicity";
    static String[] sData = null;
    @BeforeClass
    public void getRestBaseUrl()throws UnknownHostException {
        RestAssured.basePath=restBaseUrl;
        MongoDBService.connectDBServer("34.205.90.145",27017,database);
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
    /*
    TestCase1: Get institution from Customer ID
    Created by: Doai.Tran    25. Apr.2017
     */
    @Test(priority = 1, enabled = true, description = "TestCase1: Get account from Customer ID")
    public void GetAccountCustomerID() throws Exception {
        try {
            sData = MongoDBService.toReadExcelData("Institution1", "institutions");
            Response response = given().get(restBaseUrl+"/v1/institution/"+sData[1]+"?consumerID="+sData[4]);
            Assert.assertEquals(response.statusCode(), 200);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("identifier"), sData[1]);
            assertionEquals(response.then().extract().jsonPath().getString("name"),sData[5]);
            assertionEquals(response.then().extract().jsonPath().getString("typeDescription"),sData[6]);
            assertionEquals(response.then().extract().jsonPath().getString("urlHomeApp"),sData[7]);
            assertionEquals(response.then().extract().jsonPath().getString("urlLogonApp"),sData[8]);
            assertionEquals(response.then().extract().jsonPath().getString("urlProductApp"),sData[9]);
            assertionEquals(response.then().extract().jsonPath().getString("phone"),sData[10]);
            assertionEquals(response.then().extract().jsonPath().getString("currency"),sData[11]);
            assertionEquals(response.then().extract().jsonPath().getString("email"),sData[12]);
            assertionEquals(response.then().extract().jsonPath().getString("specialText"),sData[13]);
            assertionEquals(response.then().extract().jsonPath().getString("address"),sData[14]);

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account customer", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase2: Get account from out Customer ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase2: Get account from Out Customer ID")
    public void GetAccountOutCustomerID() throws Exception {
        try{
            sData = MongoDBService.toReadExcelData("Institution1", "institutions");
            Response response = given().get(restBaseUrl+"/v1/institution/"+sData[1]);
            Assert.assertEquals(response.statusCode(), 401);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account from out Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase3: Get account from wrong Customer ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase3: Get account with Out Customer ID")
    public void GetAccountWrongCustomerID() throws Exception {
        try{
            sData = MongoDBService.toReadExcelData("Institution1", "institutions");
            Response response = given().get(restBaseUrl+"/v1/institution/"+sData[1]+"?consumerID=12345");
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-024");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid params.");

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase4: Get account from wrong institutionID
     */
    @Test(priority = 1, enabled = true, description = "TestCase4: Get account with wrong institutionID")
    public void GetAccountWronginstitutionID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f474340175fa?consumerID="+sData[1]);
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-024");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid params.");
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase5: Get account with wrong institutionIDformat
     */
    @Test(priority = 1, enabled = true, description = "TestCase4: Get account with wrong institutionIDformat")
    public void GetAccountWronginstitutionIDFormat() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/zzzzzzzzzz?consumerID=8283407");
            Assert.assertEquals(response.statusCode(), 404);
            NXGReports.addStep("Get correct code.", LogAs.PASSED, null);
            /*assertionEquals(response.getBody().toString(),"Cannot GET /v1/institution/58f73f957d63f4745260175fa?consumerID=8283407");
            System.out.println("----------- "+ response.getBody().toString())*/;
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong institutionIDformat", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}

