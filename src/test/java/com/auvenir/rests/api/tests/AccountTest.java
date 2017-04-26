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
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by doai.tran on 4/21/2017.
 */
public class AccountTest extends AbstractAPIService {
    public static final String restBaseUrl="http://finicity-qa-331.com";
    public static final String database ="serviceFinicity";
    static String[] sData = null;
    // Connect DB and reset Data
    @BeforeSuite
    public void prepareData() {


    }
    /*
    // Connect DB
    @BeforeMethod
    public void preCondition(){

    }*/
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
    TestCase1: Get all account with Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get all account with Customer ID")
    public void GetAllAccountCustomerID() throws Exception {
        try {
            sData = MongoDBService.toReadExcelData("Account1","accounts");

            Response response = given().get(restBaseUrl+"/v1/account/all?consumerID="+sData[6]);
            Assert.assertEquals(response.statusCode(), 200);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            jp.setRoot("result");
            Map result = jp.get("find {e -> e.finCustomerID =~ /8283407/}");
            assertionEquals(result.get("_id").toString(),sData[1]);
            assertionEquals(result.get("ownerID").toString(),sData[2]);
            assertionEquals(result.get("institutionID").toString(),sData[3]);
            assertionEquals(result.get("integration").toString(),sData[4]);
            assertionEquals(result.get("dateCreated").toString(),sData[5]);
            assertionEquals(result.get("finID").toString(),sData[6]);
            assertionEquals(result.get("finCustomerID").toString(),sData[7]);
            assertionEquals(result.get("finInstitutionID").toString(),sData[8]);
            assertionEquals(result.get("finLoginID").toString(),sData[9]);
            assertionEquals(result.get("number").toString(),sData[10]);
            assertionEquals(result.get("name").toString(),sData[11]);
            assertionEquals(result.get("status").toString(),sData[12]);
            assertionEquals(result.get("type").toString(),sData[13]);
            assertionEquals(result.get("balanceDate").toString(),sData[15]);
            assertionEquals(result.get("currency").toString(),sData[16]);
            assertionEquals(result.get("finDateCreated").toString(),sData[17]);
            assertionEquals(result.get("lastTransactionDate").toString(),sData[18]);
            assertionEquals(result.get("raw").toString(),sData[19]);
            assertionEquals(result.get("position").toString(),sData[20]);
            assertionEquals(result.get("order").toString(),sData[21]);
            //Verify Schema
            response.then().body(JsonSchemaValidator.matchesJsonSchema(sData[22]));

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
    TestCase2: Get account from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get account from Customer ID")
    public void GetAccountCustomerID() throws Exception {
        try {
            sData = MongoDBService.toReadExcelData("Account1","accounts");
            Response response = given().get(restBaseUrl+"/v1/account/"+sData[1]+"?consumerID="+sData[6]);
            Assert.assertEquals(response.statusCode(), 200);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            jp.setRoot("result");
            Map result = jp.get("find {e -> e.finCustomerID =~ /8283407/}");
            assertionEquals(result.get("_id").toString(),sData[1]);
            assertionEquals(result.get("ownerID").toString(),sData[2]);
            assertionEquals(result.get("institutionID").toString(),sData[3]);
            assertionEquals(result.get("integration").toString(),sData[4]);
            assertionEquals(result.get("dateCreated").toString(),sData[5]);
            assertionEquals(result.get("finID").toString(),sData[6]);
            assertionEquals(result.get("finCustomerID").toString(),sData[7]);
            assertionEquals(result.get("finInstitutionID").toString(),sData[8]);
            assertionEquals(result.get("finLoginID").toString(),sData[9]);
            assertionEquals(result.get("number").toString(),sData[10]);
            assertionEquals(result.get("name").toString(),sData[11]);
            assertionEquals(result.get("status").toString(),sData[12]);
            assertionEquals(result.get("type").toString(),sData[13]);
            assertionEquals(result.get("balanceDate").toString(),sData[15]);
            assertionEquals(result.get("currency").toString(),sData[16]);
            assertionEquals(result.get("finDateCreated").toString(),sData[17]);
            assertionEquals(result.get("lastTransactionDate").toString(),sData[18]);
            assertionEquals(result.get("raw").toString(),sData[19]);
            assertionEquals(result.get("position").toString(),sData[20]);
            assertionEquals(result.get("order").toString(),sData[21]);
            //Verify Schema
            response.then().body(JsonSchemaValidator.matchesJsonSchema(sData[22]));

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
    TestCase2: Get account with wrong Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get account with wromg Customer ID")
    public void GetAccountWrongCustomerID() throws Exception {
        try{
            sData = MongoDBService.toReadExcelData("Account1", "accounts");
            Response response = given().get(restBaseUrl+"/v1/account/"+sData[1]+"?consumerID=12345");
            System.out.println(restBaseUrl+"/v1/account/"+sData[1]+"?consumerID=12345");
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-024");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid params.");

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
    TestCase3: Get account from wrong account ID
     */
    @Test(priority = 1, enabled = true, description = "Get account with wromg account ID")
    public void GetAccountWrongAccountID() throws Exception {
        try {
            sData = MongoDBService.toReadExcelData("Account1", "accounts");
            System.out.println(restBaseUrl+"/v1/account/aaaaaaa"+"?consumerID="+sData[6]);
            Response response = given().get(restBaseUrl+"/v1/account/aaaaaaa"+"?consumerID="+sData[6]);
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-024");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid params.");

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
}


