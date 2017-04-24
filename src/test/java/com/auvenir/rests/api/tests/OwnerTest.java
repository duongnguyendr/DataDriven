package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.ui.services.AbstractService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by doai.tran on 4/20/2017.
 */
public class OwnerTest extends AbstractAPIService {
    public static final String restBaseUrl="http://auvenir-qa.com";
    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl(){
        RestAssured.basePath=restBaseUrl;

    }
    /*
    // Connect DB
    @BeforeMethod
    public void preCondition(){

    }*/

    /*
    TestCase1: Get owner from owner ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase 1")
    public void getOwnerFromOwnerID() throws Exception {
        try {
            Response response = given().get(restBaseUrl+"/v1/owner/78958649565");
            if(response.getStatusCode()==200){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            }
            else {
                Assert.fail();
            }

            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            assertionEquals(jp.get("ownerID").toString(),"78958649565");
            /*assertEquals("78958649565",jp.get("ownerID").toString());
            getLogger().info("Request successfully with owner ID: " + jp.get("ownerID").toString());*/
            //
            assertionEquals(jp.get("uid").toString(),"454684125154");
            /*assertEquals(jp.get("uid").toString(),"454684125154");
            getLogger().info("Request successfully with owner ID: " + jp.get("uid").toString());*/
            //
            assertionEquals(jp.get("status").toString(),"ACTIVE");
            /*assertEquals(jp.get("status").toString(),"ACTIVE");
            getLogger().info("Request successfully with status: " + jp.get("status").toString());*/
            //
            assertionEquals(jp.get("dateCreated").toString(),"1492599536");
            /*assertEquals(jp.get("dateCreated").toString(),"1492599536");
            getLogger().info("Request successfully with dateCreated: " + jp.get("dateCreated").toString());*/
            //
            jp.setRoot("consumers");
            Map consumers = jp.get("find {e -> e.consumerID =~ /28340/}");
            assertionEquals(consumers.get("consumerID").toString(),"8283407");
            /*assertEquals("8283407", consumers.get("consumerID"));
            getLogger().info("Request successfully with consumerID: " + consumers.get("consumerID").toString());*/
            assertionEquals(consumers.get("institutionID").toString(),"58f73f957d63f4745a0175fa");
            /*assertEquals("58f73f957d63f4745a0175fa", consumers.get("institutionID"));
            getLogger().info("Request successfully with institutionID: " + consumers.get("institutionID").toString());*/
            assertionEquals(consumers.get("status").toString(),"ACTIVE");
            /*assertEquals("ACTIVE", consumers.get("status"));
            getLogger().info("Request successfully with institutionID: " + consumers.get("status").toString());*/
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
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
    TestCase2: Send request with invalid owner
     */
    @Test(priority = 2, enabled = true, description = "TestCase2: Send request with invalid owner")
    public void getOwnerFromInvalidOwnerID() throws Exception {
        try {
            Response response = given().get(restBaseUrl+"/v1/owner/12345");
            if(response.getStatusCode()==400){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            }
            else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            //
            assertionEquals(jp.get("code").toString(),"api-022");
            /*assertEquals(jp.get("code").toString(),"api-022");
            getLogger().info("Request successfully with code: " + jp.get("code").toString());*/
            //
            assertionEquals(jp.get("msg").toString(),"Error, missing or invalid ownerID.");
            /*assertEquals("Error, missing or invalid ownerID.",jp.get("msg").toString());
            getLogger().info("Request successfully with msg: " + jp.get("msg").toString());*/
            //
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
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
    TestCase3: Send request with wrong institutionID format
    */
    @Test(priority = 3, enabled = true, description = "TestCase3: Send request with wrong institutionID format")
    public void getOwnerWronginstitutionID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/owner/");
            if(response.getStatusCode()==404){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
                NXGReports.addStep("Request with wrong institutionID format with code: " +response.getStatusCode() , LogAs.PASSED, null);
            }
            else {
                Assert.fail();
            }

            //
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
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
