package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by doai.tran on 4/20/2017.
 */
public class OwnerTest extends AbstractAPIService {
    //public static final String restBaseUrl="http://finicity-qa.com";
    public static final String database ="serviceFinicity";
    static String[] sData = null;

    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl() throws UnknownHostException {
        //RestAssured.basePath=restBaseUrl;
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

    @BeforeMethod
    public void preCondition(){
        getBaseUrl();
    }

    /*
    TestCase1: Get owner from owner ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner with owner ID")
    public void getOwnerFromOwnerID() throws Exception {
        try {
            sData = MongoDBService.toReadExcelData("Owner1", "owners");
            Response response = given().get(baseUrl+"/v1/owner/"+sData[2]);
            if(response.getStatusCode()==200){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
                NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            }
            else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            assertionEquals(jp.get("ownerID").toString(),sData[2]);
            assertionEquals(jp.get("uid").toString(),sData[3]);
            assertionEquals(jp.get("status").toString(),sData[4]);
            assertionEquals(jp.get("dateCreated").toString(),sData[5]);

            jp.setRoot("consumers");
            Map consumers = jp.get("find {e -> e.institutionID =~ /fe0947e/}");
            assertionEquals(consumers.get("consumerID").toString(),sData[6]);
            assertionEquals(consumers.get("institutionID").toString(),sData[7]);
            assertionEquals(consumers.get("status").toString(),sData[8]);
            //Verify Schema
            response.then().body(JsonSchemaValidator.matchesJsonSchema(sData[9]));

            Assert.assertTrue(AbstractAPIService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Request successfully with ownerID", LogAs.PASSED, null);
        }
        catch (AssertionError e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase2: Get Owner with invalid ownerid
     */
    @Test(priority = 2, enabled = true, description = "Get Owner with invalid ownerid")
    public void getOwnerFromInvalidOwnerID() throws Exception {
        try {
            Response response = given().get(baseUrl+"/v1/owner/12345");
            if(response.getStatusCode()==400){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            }
            else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            assertionEquals(jp.get("code").toString(),"api-022");
            assertionEquals(jp.get("msg").toString(),"Error, missing or invalid ownerID.");

            Assert.assertTrue(AbstractAPIService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Request successfully with invalid ownerID", LogAs.PASSED, null);
        }catch (AssertionError e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase3: Get Owner with wrong institutionID format
    */
    @Test(priority = 3, enabled = true, description = "Get Owner with wrong institutionID format")
    public void getOwnerWronginstitutionID() throws Exception {
        try{
            Response response = given().get(baseUrl+"/v1/owner/");
            //Response response = given().get("http://finicity-qa.com/v1/owner/");
            if(response.getStatusCode()==404){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
                NXGReports.addStep("Request with wrong institutionID format with code: " +response.getStatusCode() , LogAs.PASSED, null);
            }
            else {
                Assert.fail();
            }

            //
            Assert.assertTrue(AbstractAPIService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Request successfully with WronginstitutionID", LogAs.PASSED, null);
        }catch (AssertionError e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}
